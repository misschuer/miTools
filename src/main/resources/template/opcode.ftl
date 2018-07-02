package ${package};

import cc.mi.core.packet.Packet;
import cc.mi.core.packet.PacketImpl;

<#list classInfos as classInfo>
import ${classInfo.package}.${classInfo.name};
</#list>

public final class ${className}  {
	private static final PacketImpl[] coders = new PacketImpl[${opcodeSize}];

	<#list classInfos as classInfo>
	public static final int ${classInfo.var} = ${classInfo.opcode}; //${classInfo.comment}
	</#list>
	
	static {
		<#list classInfos as classInfo>
		coders[${classInfo.var}] = new ${classInfo.name}();
		</#list>
	}
	
	private ${className}(){}
	
	public static Packet newInstance(int opcode) {
		return coders[opcode].newInstance();
	}
	
	public static boolean contains(int opcode) {
		return coders[opcode] != null;
	}
}