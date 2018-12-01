package cc.mi.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class ProrocolTools {
	static Logger logger = Logger.getLogger(ProrocolTools.class);
	private static Configuration cfg = null;
	private static String generalPath = "C:\\Users\\gy\\git\\micore\\src\\main\\java\\cc\\mi\\core\\generate";
	
	private static String struPackagePath = "cc.mi.core.generate.stru";
	private static String struPath = String.format("%s\\stru", generalPath);
	
	private static String msgPackagePath = "cc.mi.core.generate.msg";
	private static String msgPath = String.format("%s\\msg", generalPath);
	
	private static String opcodePackagePath = "cc.mi.core.generate";
	
	private static Set<String> classNameSet = null;
	
	public static void main(String[] args) throws IOException {
		cfg = new Configuration(Configuration.VERSION_2_3_22);
		URL url = ProrocolTools.class.getResource("/template");
		cfg.setDirectoryForTemplateLoading(new File(url.getPath()));
		
		classNameSet = new HashSet<>();
		// 先加结构体
		loadStru();
		// 加载消息
		loadMsg();
		
		cfg = null;
		classNameSet = null;
	}
	
	private static void loadStru() {
		
		URL url = ProrocolTools.class.getResource("/Cow.Stru");
		try (BufferedReader br = new BufferedReader(new FileReader(new File(url.getPath())));) {
			
			List<String> list = new ArrayList<>();
			String line = null;
			while ((line = br.readLine()) != null) {
				// 开头
				if (line.startsWith("#")) {
					list.clear();
					list.add(line);
					continue;
				}
				// 结尾
				if ("".equals(line.trim())) {
					parseStru(list);
					list.clear();
					continue;
				}
				// 必须有开头
				if (list.size() > 0) {
					list.add(line.trim());
				}
			}
			parseStru(list);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	private static void parseStru(List<String> list) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		// 小于4行就不需要有结构体
		if (list.size() < 4) {
			return;
		}
		boolean hasString = false;
		boolean hasList = false;
		List<Map<String, Object>> fields = new ArrayList<>();
		for (int i = 2; i < list.size(); ++ i) {
			Map<String, Object> field = new HashMap<>();
			String content = list.get(i);
			String[] params = content.split(",");
			String comment = "";
			if (params.length > 3) {
				comment = params[ 3 ];
			}
			field.put("comment", comment);
			field.put("isList", "1".equals(params[ 2 ]));
			field.put("type", params[ 1 ]);
			field.put("name", params[ 0 ]);
			fields.add(field);
			
			if ("String".equals(params[ 1 ])) {
				hasString = true;
			}
			if ("1".equals(params[ 2 ])) {
				hasList = true;
			}
		}
		Map<String, Object> hash = new HashMap<>();
		String[] params	= list.get(1).split(",");
		hash.put("className", params[ 0 ]);
		hash.put("comment", params[ 1 ]);
		hash.put("package", struPackagePath);
		hash.put("fields", fields);
		hash.put("hasString", hasString);
		hash.put("hasList", hasList);

		classNameSet.add(params[ 0 ]);
		logger.info("doing " + params[ 0 ]);
		Template template = cfg.getTemplate("stru.ftl");
		String pathname = struPath + "\\" + params[ 0 ] + ".java";
		File file = new File(pathname);
		PrintWriter pw = new PrintWriter(file);
		template.process(hash, pw);
		pw.flush();
		logger.info(file.getPath() + " ...OK");
	}
	
	
	private static void loadMsg() {
		
		URL url = ProrocolTools.class.getResource("/Cow.Msg");
		try (BufferedReader br = new BufferedReader(new FileReader(new File(url.getPath())));) {
			Map<Integer, OpcodeInfo> opcodeHash = new HashMap<>();
			List<String> list = new ArrayList<>();
			String line = null;
			while ((line = br.readLine()) != null) {
				// 开头
				if (line.startsWith("#")) {
					list.clear();
					list.add(line);
					continue;
				}
				// 结尾
				if ("".equals(line.trim())) {
					parseMsg(list, opcodeHash);
					list.clear();
					continue;
				}
				// 必须有开头
				if (list.size() > 0) {
					list.add(line.trim());
				}
			}
			
			// 如果最后没有空行也试着解析一下
			parseMsg(list, opcodeHash);
			// 生成协议号常量
			parseOpcode(opcodeHash);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	private static void parseMsg(List<String> list, Map<Integer, OpcodeInfo> opcodeHash) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		// 小于4行就不需要结构体
		if (list.size() < 2) {
			return;
		}
		
		boolean hasString = false;
		boolean hasList = false;
		List<Map<String, Object>> fields = new ArrayList<>();
		Set<String> importSet = new HashSet<>();
		for (int i = 2; i < list.size(); ++ i) {
			Map<String, Object> field = new HashMap<>();
			String content = list.get(i);
			String[] params = content.split(",");
			String comment = "";
			if (params.length > 3) {
				comment = params[ 3 ];
			}
			field.put("comment", comment);
			field.put("type", params[ 1 ]);
			field.put("name", params[ 0 ]);
			field.put("isList", "True".equals(params[ 2 ]));
			field.put("isStru", classNameSet.contains(params[ 1 ]));
			fields.add(field);
			
			if ("String".equals(params[ 1 ])) {
				hasString = true;
			}
			if ("True".equals(params[ 2 ])) {
				hasList = true;
			}
			if (classNameSet.contains(params[ 1 ])) {
				importSet.add(String.format("import %s.%s;", struPackagePath, params[ 1 ]));
			}
		}

		Map<String, Object> hash = new HashMap<>();
		String[] params	= list.get(1).split(",");
		hash.put("className", params[ 0 ]);
		hash.put("opcode", params[ 2 ]);
		hash.put("comment", params[ 3 ]);
		hash.put("package", msgPackagePath);
		hash.put("fields", fields);
		hash.put("hasString", hasString);
		hash.put("hasList", hasList);
		hash.put("importSet", importSet);
		
		int opcode = Integer.parseInt(params[ 2 ]);
		opcodeHash.put(opcode, new OpcodeInfo(opcode, params[ 0 ], params[ 3 ], msgPackagePath, "MSG_" + params[ 0 ].toUpperCase()));
		
		logger.info("parse msg " + params[ 0 ]);
		Template template = cfg.getTemplate("msg.ftl");
		String pathname = msgPath + "\\" + params[ 0 ] + ".java";
		File file = new File(pathname);
		PrintWriter pw = new PrintWriter(file);
		template.process(hash, pw);
		pw.flush();
		logger.info(file.getPath() + " ...OK");
	}
	
	private static void parseOpcode(Map<Integer, OpcodeInfo> opcodeHash) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map<String, Object> hash = new HashMap<>();
		
		int opcodeSize = 0;
		List<Map<String, Object>> classInfos = new ArrayList<>();
		for (Entry<Integer, OpcodeInfo> entry : opcodeHash.entrySet()) {
			Map<String, Object> field = new HashMap<>();
			int opcode = entry.getValue().getOpcode();
			field.put("comment", entry.getValue().getComment());
			field.put("opcode", opcode);
			field.put("name", entry.getValue().getName());
			field.put("package", entry.getValue().getPack());
			field.put("var", entry.getValue().getVar());
			classInfos.add(field);
			if (opcodeSize < opcode) {
				opcodeSize = opcode;
			}
		}
		String className = "Opcodes";
		hash.put("className", className);
		hash.put("package", opcodePackagePath);
		hash.put("opcodeSize", opcodeSize + 1);
		hash.put("classInfos", classInfos);
		
		Template template = cfg.getTemplate("opcode.ftl");
		String pathname = generalPath + "\\" + className + ".java";
		File file = new File(pathname);
		PrintWriter pw = new PrintWriter(file);
		template.process(hash, pw);
		pw.flush();
	}
	
	static class OpcodeInfo {
		private final int opcode;
		private final String name;
		private final String comment;
		private final String pack;
		private final String var;
		
		public OpcodeInfo(int opcode, String name, String comment, String pack, String var) {
			this.opcode		= opcode;
			this.name		= name;
			this.comment	= comment;
			this.pack		= pack;
			this.var 		= var;
		}

		public int getOpcode() {
			return opcode;
		}

		public String getName() {
			return name;
		}

		public String getComment() {
			return comment;
		}

		public String getPack() {
			return pack;
		}

		public String getVar() {
			return var;
		}
	}
}
