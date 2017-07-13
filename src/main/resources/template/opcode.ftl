package ${package};

import cc.mi.core.coder.Coder;
import cc.mi.core.coder.AbstractCoder;

<#list classInfos as classInfo>
import ${classInfo.package}.${classInfo.name};
</#list>

public final class ${className}  {
	private static final AbstractCoder[] coders = new AbstractCoder[${opcodeSize}];

	<#list classInfos as classInfo>
	public static final int ${classInfo.var} = ${classInfo.opcode}; //${classInfo.comment}
	</#list>
	
	static {
		<#list classInfos as classInfo>
		coders[${classInfo.var}] = new ${classInfo.name}();
		</#list>
	}
	
	private ${className}(){}
	
	public static Coder newInstance(int opcode) {
		return coders[opcode].newInstance();
	}
	
	public static boolean contains(int opcode) {
		return coders[opcode] != null;
	}
}