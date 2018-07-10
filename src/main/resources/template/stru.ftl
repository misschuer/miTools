package ${package};

import io.netty.buffer.ByteBuf;
<#if hasString>
import cc.mi.core.packet.StringCoder;
</#if>
<#if hasList>
import java.util.List;
import java.util.ArrayList;
</#if>

/**
 * ${comment}
 **/
public class ${className}  {
	<#list fields as field>
	//${field.comment}
	<#if !field.isList>
	private ${field.type} ${field.name};
	<#else>
	<#if field.type == "int">
	private List<Integer> ${field.name};
	<#elseif field.type == "byte">
	private List<Byte> ${field.name};
	<#elseif field.type == "short">
	private List<Short> ${field.name};
	<#elseif field.type == "long">
	private List<Long> ${field.name};
	<#elseif field.type == "float">
	private List<Float> ${field.name};
	<#elseif field.type == "double">
	private List<Double> ${field.name};
	<#elseif field.type == "boolean">
	private List<Boolean> ${field.name};
	<#else>
	private List<${field.type}> ${field.name};
	</#if>
	</#if>
	</#list>

	public void encode(ByteBuf buffer) {
		<#list fields as field>
		<#if field.type == "String">
		<#if field.isList>
		buffer.writeShort(this.${field.name}.size());
		for (${field.type} element : this.${field.name}) {
			StringCoder.writeString(buffer, element);
		}
		<#else>
		StringCoder.writeString(buffer, this.${field.name});
		</#if>
		<#else>
		<#if field.isList>
		buffer.writeShort(this.${field.name}.size());
		for (${field.type} element : this.${field.name}) {
			buffer.write${field.type?cap_first}(element);
		}
		<#else>
		buffer.write${field.type?cap_first}(this.${field.name});
		</#if>
		</#if>
		</#list>
	}

	public void decode(ByteBuf buffer) {
		<#list fields as field>
		<#if field.type == "String">
		<#if field.isList>
		int ${field.name}Size = buffer.readUnsignedShort();
		this.${field.name} = new ArrayList<>(${field.name}Size);
		for (int i = 0; i < ${field.name}Size; ++ i) {
			${field.type} element = StringCoder.readString(buffer);
			this.${field.name}.add(element);
		}
		<#else>
		this.${field.name} = StringCoder.readString(buffer);
		</#if>
		<#else>
		<#if field.isList>
		int ${field.name}Size = buffer.readUnsignedShort();
		this.${field.name} = new ArrayList<>(${field.name}Size);
		for (int i = 0; i < ${field.name}Size; ++ i) {
			${field.type} element = buffer.read${field.type?cap_first}();
			this.${field.name}.add(element);
		}
		<#else>
		this.${field.name} = buffer.read${field.type?cap_first}(); 
		</#if>
		</#if>
		</#list>
	}
	
		<#list fields as field>
	<#if !field.isList>
	public ${field.type} get${field.name?cap_first}() {
		return this.${field.name};
	}
	
	public void set${field.name?cap_first}(${field.type} ${field.name}) {
		this.${field.name} = ${field.name};
	}
		
	<#else>
	<#if field.type == "int">
	public List<Integer> get${field.name?cap_first}() {
	<#elseif field.type == "byte">
	public List<Byte> get${field.name?cap_first}() {
	<#elseif field.type == "short">
	public List<Short> get${field.name?cap_first}() {
	<#elseif field.type == "long">
	public List<Long> get${field.name?cap_first}() {
	<#elseif field.type == "float">
	public List<Float> get${field.name?cap_first}() {
	<#elseif field.type == "double">
	public List<Double> get${field.name?cap_first}() {
	<#elseif field.type == "boolean">
	public List<Boolean> get${field.name?cap_first}() {
	<#else>
	public List<${field.type}> get${field.name?cap_first}() {
	</#if>
		return this.${field.name};
	}
	
	<#if field.type == "int">
	public void set${field.name?cap_first}(List<Integer> ${field.name}) {
	<#elseif field.type == "byte">
	public void set${field.name?cap_first}(List<Byte> ${field.name}) {
	<#elseif field.type == "short">
	public void set${field.name?cap_first}(List<Short> ${field.name}) {
	<#elseif field.type == "long">
	public void set${field.name?cap_first}(List<Long> ${field.name}) {
	<#elseif field.type == "float">
	public void set${field.name?cap_first}(List<Float> ${field.name}) {
	<#elseif field.type == "double">
	public void set${field.name?cap_first}(List<Double> ${field.name}) {
	<#elseif field.type == "boolean">
	public void set${field.name?cap_first}(List<Boolean> ${field.name}) {
	<#else>
	public void set${field.name?cap_first}(List<${field.type}> ${field.name}) {
	</#if>
		this.${field.name} = ${field.name};
	}
	
	</#if>
	</#list>
}