package com.bookool.MyBatis3AutoCode;

public class myfield
{

	/**
	 * 字段名
	 */
	private String FieldName;

	/**
	 * 字段名在Model中的全小写名称
	 */
	private String FieldModelName;

	/**
	 * 字段名在Model中Get\Set时的首字母大写名称
	 */
	private String FieldGetSetName;

	/**
	 * 字段注释
	 */
	private String FieldComment;

	/*
	 * 字段可以为空
	 */
	private Boolean FieldNotNull;

	/**
	 * MySql中的类型名(必须全小写)
	 */
	private String FDBType;

	/**
	 * jdbc中的类型名
	 */
	private String FJDBCType;

	/*
	 * Model中的类型名(全)
	 */
	private String FModleTypeFull;

	/*
	 * Model中的类型名(简)
	 */
	private String FModleType;

	public String getFieldName()
	{
		return FieldName;
	}

	public void setFieldName(String fieldName)
	{
		FieldName = fieldName;
		SetFieldName();
	}

	public String getFieldModelName()
	{
		return FieldModelName;
	}

//	public void setFieldModelName(String fieldModelName)
//	{
//		FieldModelName = fieldModelName;
//	}

	public String getFieldGetSetName()
	{
		return FieldGetSetName;
	}

//	public void setFieldGetSetName(String fieldGetSetName)
//	{
//		FieldGetSetName = fieldGetSetName;
//	}

	public String getFieldComment()
	{
		return FieldComment;
	}

	public void setFieldComment(String fieldComment)
	{
		FieldComment = fieldComment;
	}

	public Boolean getFieldNotNull()
	{
		return FieldNotNull;
	}

	public void setFieldNotNull(Boolean fieldNotNull)
	{
		FieldNotNull = fieldNotNull;
	}

	public String getFDBType()
	{
		return FDBType;
	}

	public void setFDBType(String fDBType) throws Exception
	{
		FDBType = fDBType;
		SetTypeByDBType();
	}

	public String getFJDBCType()
	{
		return FJDBCType;
	}

//	public void setFJDBCType(String fJDBCType)
//	{
//		FJDBCType = fJDBCType;
//	}

	public String getFModleTypeFull()
	{
		return FModleTypeFull;
	}

//	public void setFModleTypeFull(String fModleTypeFull)
//	{
//		FModleTypeFull = fModleTypeFull;
//	}

	public String getFModleType()
	{
		return FModleType;
	}

//	public void setFModleType(String fModleType)
//	{
//		FModleType = fModleType;
//	}

	/**
	 * 设置字段名
	 */
	private void SetFieldName()
	{
		this.FieldModelName = this.FieldName.toLowerCase();
		String zstr0 = this.FieldModelName.substring(0, 1).toUpperCase();
		String zstr = this.FieldModelName.substring(1);
		this.FieldGetSetName = zstr0 + zstr;
	}

	/**
	 * 通过数据库类型名，设置其他类型名
	 */
	private void SetTypeByDBType() throws Exception
	{
		switch (this.FDBType)
		{
			case "tinyint":
				this.FJDBCType = "TINYINT";
				this.FModleType = "Byte";
				this.FModleTypeFull = "java.lang.Byte";
				break;
			case "smallint":
				this.FJDBCType = "SMALLINT";
				this.FModleType = "Short";
				this.FModleTypeFull = "java.lang.Short";
				break;
			case "mediumint":
				this.FJDBCType = "INTEGER";
				this.FModleType = "Integer";
				this.FModleTypeFull = "java.lang.Integer";
				break;
			case "int":
				this.FJDBCType = "INTEGER";
				this.FModleType = "Integer";
				this.FModleTypeFull = "java.lang.Integer";
				break;
			case "integer":
				this.FJDBCType = "INTEGER";
				this.FModleType = "Integer";
				this.FModleTypeFull = "java.lang.Integer";
				break;
			case "bigint":
				this.FJDBCType = "BIGINT";
				this.FModleType = "Long";
				this.FModleTypeFull = "java.lang.Long";
				break;
			case "bit":
				this.FJDBCType = "BIT";
				this.FModleType = "Boolean";
				this.FModleTypeFull = "java.lang.Boolean";
				break;
			case "real":
				this.FJDBCType = "DOUBLE";
				this.FModleType = "Double";
				this.FModleTypeFull = "java.lang.Double";
				break;
			case "double":
				this.FJDBCType = "DOUBLE";
				this.FModleType = "Double";
				this.FModleTypeFull = "java.lang.Double";
				break;
			case "float":
				this.FJDBCType = "REAL";
				this.FModleType = "Float";
				this.FModleTypeFull = "java.lang.Float";
				break;
			case "decimal":
				this.FJDBCType = "DECIMAL";
				this.FModleType = "BigDecimal";
				this.FModleTypeFull = "	java.math.BigDecimal";
				break;
			case "numeric":
				this.FJDBCType = "DECIMAL";
				this.FModleType = "BigDecimal";
				this.FModleTypeFull = "	java.math.BigDecimal";
				break;
			case "char":
				this.FJDBCType = "CHAR";
				this.FModleType = "String";
				this.FModleTypeFull = "java.lang.String";
				break;
			case "varchar":
				this.FJDBCType = "VARCHAR";
				this.FModleType = "String";
				this.FModleTypeFull = "java.lang.String";
				break;
			case "date":
				this.FJDBCType = "DATE";
				this.FModleType = "Date";
				this.FModleTypeFull = "java.util.Date";
				break;
			case "time":
				this.FJDBCType = "TIME";
				this.FModleType = "Date";
				this.FModleTypeFull = "java.util.Date";
				break;
			case "year":
				this.FJDBCType = "DATE";
				this.FModleType = "Date";
				this.FModleTypeFull = "java.util.Date";
				break;
			case "timestamp":
				this.FJDBCType = "TIMESTAMP";
				this.FModleType = "Date";
				this.FModleTypeFull = "java.util.Date";
				break;
			case "datetime":
				this.FJDBCType = "TIMESTAMP";
				this.FModleType = "Date";
				this.FModleTypeFull = "java.util.Date";
				break;
			case "tinytext":
				this.FJDBCType = "VARCHAR";
				this.FModleType = "String";
				this.FModleTypeFull = "java.lang.String";
				break;
			case "tinyblob":
				this.FJDBCType = "BINARY";
				this.FModleType = "byte[]";
				this.FModleTypeFull = "";
				break;
			case "blob":
				this.FJDBCType = "LONGVARBINARY";
				this.FModleType = "byte[]";
				this.FModleTypeFull = "";
				break;
			case "mediumblob":
				this.FJDBCType = "LONGVARBINARY";
				this.FModleType = "byte[]";
				this.FModleTypeFull = "";
				break;
			case "longblob":
				this.FJDBCType = "LONGVARBINARY";
				this.FModleType = "byte[]";
				this.FModleTypeFull = "";
				break;
			case "text":
				this.FJDBCType = "LONGVARCHAR";
				this.FModleType = "String";
				this.FModleTypeFull = "java.lang.String";
				break;
			case "mediumtext":
				this.FJDBCType = "LONGVARCHAR";
				this.FModleType = "String";
				this.FModleTypeFull = "java.lang.String";
				break;
			case "longtext":
				this.FJDBCType = "LONGVARCHAR";
				this.FModleType = "String";
				this.FModleTypeFull = "java.lang.String";
				break;
			default:
				throw new Exception("没有找到 [" + this.FDBType + "]对应的类型名！");
		}
	}
}
