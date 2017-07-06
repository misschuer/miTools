package ${package};

import io.netty.buffer.ByteBuf;
<#if hasString>
import cc.mi.core.coder.StringCoder;
</#if>

/**
 * ${comment}
 **/
public class ${className}  {
	<#list fields as field>
	//${field.comment}
	private ${field.type} ${field.name};
	</#list>

	public void encode(ByteBuf buffer) {
		<#list fields as field>
		<#if field.type == "String">
		StringCoder.writeString(buffer, this.${field.name});
		<#else> 
		buffer.write${field.type?cap_first}(this.${field.name}); 
		</#if>
		</#list>
	}

	public void decode(ByteBuf buffer) {
		<#list fields as field>
		<#if field.type == "String">
		this.${field.name} = StringCoder.readString(buffer);
		<#else> 
		this.${field.name} = buffer.read${field.type?cap_first}(); 
		</#if>
		</#list>
	}
	
	<#list fields as field>
	public ${field.type} get${field.name?cap_first}() {
		return this.${field.name};
	}
	
	public void set${field.name?cap_first}(${field.type} ${field.name}) {
		this.${field.name} = ${field.name};
	}
	
	</#list>
}