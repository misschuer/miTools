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
import java.util.Set;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class ProrocolTools {
	private static Configuration cfg = null;
	private static String struPackagePath = "cc.mi.generate.stru";
	private static String struPath = "G:\\gradleProjects\\miTools\\src\\main\\java\\cc\\mi\\generate\\stru";
	
	private static String msgPackagePath = "cc.mi.generate.msg";
	private static String msgPath = "G:\\gradleProjects\\miTools\\src\\main\\java\\cc\\mi\\generate\\msg";
	
	private static Set<String> classNameSet = null;
	
	public static void main(String[] args) throws IOException {
		cfg = new Configuration(Configuration.VERSION_2_3_22);
		URL url = ProrocolTools.class.getResource("/template");
		cfg.setDirectoryForTemplateLoading(new File(url.getPath()));
		
		classNameSet = new HashSet<>();
		// 先加载结构体
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
			field.put("type", params[ 1 ]);
			field.put("name", params[ 0 ]);
			fields.add(field);
			
			if ("String".equals(params[ 1 ])) {
				hasString = true;
			}
		}
		Map<String, Object> hash = new HashMap<>();
		String[] params	= list.get(1).split(",");
		hash.put("className", params[ 0 ]);
		hash.put("comment", params[ 1 ]);
		hash.put("package", struPackagePath);
		hash.put("fields", fields);
		hash.put("hasString", hasString);

		classNameSet.add(params[ 0 ]);
		System.out.println("doing " + params[ 0 ]);
		Template template = cfg.getTemplate("stru.ftl");
		String pathname = struPath + "\\" + params[ 0 ] + ".java";
		File file = new File(pathname);
		PrintWriter pw = new PrintWriter(file);
		template.process(hash, pw);
		pw.flush();
		System.out.println(file.getPath() + " ...OK");
	}
	
	
	private static void loadMsg() {
		
		URL url = ProrocolTools.class.getResource("/Cow.Msg");
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
					parseMsg(list);
					list.clear();
					continue;
				}
				// 必须有开头
				if (list.size() > 0) {
					list.add(line.trim());
				}
			}
			
			// 如果最后没有空行也试着解析一下
			parseMsg(list);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	private static void parseMsg(List<String> list) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		// 小于4行就不需要有结构体
		if (list.size() < 4) {
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
		
		System.out.println("parse msg " + params[ 0 ]);
		Template template = cfg.getTemplate("msg.ftl");
		String pathname = msgPath + "\\" + params[ 0 ] + ".java";
		File file = new File(pathname);
		PrintWriter pw = new PrintWriter(file);
		template.process(hash, pw);
		pw.flush();
		System.out.println(file.getPath() + " ...OK");
	}
}
