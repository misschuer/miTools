package ${package};

public class ${className}  {
	private ${className}(){}

	<#list fields as field>
	public static final int ${field}
	</#list>
}