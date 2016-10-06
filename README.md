# MyBatis3AutoCode (For MySQL)
MyBatis3的代码自动生成工具，简单实用，java，for MySQL。
官方的代码生成工具 MyBatis Generator 非常强大，但是配置起来有点啰嗦，而且生成注释也很麻烦。
对于绝大多数项目来说，代码生成器就是为了简单而生的，所以我不自量力，自己写了一个。
优点：配置使用简单，根据数据库脚本批量生成代码和完整的注释。

## 使用方法
### 1、生成数据库脚本
* 数据库脚本文件以 .sql 结尾；
* 所有数据库脚本文件请放在同一个文件夹下，不要放在子目录中；
* 程序自动遍历所有脚本文件，根据建表脚本生成代码，建表脚本格式：
```SQL
CREATE TABLE `TB_Users` (
  `ID` int(11) NOT NULL COMMENT '用户ID',
  `UserName` varchar(50) NOT NULL COMMENT '用户姓名',
  `UserLevel` tinyint(4) NOT NULL COMMENT '用户级别',
  `UserNotes` varchar(200) DEFAULT NULL COMMENT '用户注释',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
```
注意：必须有字段注释和表注释！

### 2、生成配置文件
配置文件格式如下：
```XML
<?xml version="1.0" encoding="UTF-8" ?>
<Config>
	<!-- 包名 -->
	<PackageName>cn.run2.TG.HelloWorld</PackageName>
	<!-- 数据表前缀 -->
	<TableNamePrefixion>TB_</TableNamePrefixion>
	<!-- 数据表脚本文件所在目录 -->
	<TableScriptDir ConType="dir">/root/demo/table</TableScriptDir>
	<!-- model目录 -->
	<ModelDir ConType="dir">/root/demo/demo/src/main/java/com/bookool/demo/model</ModelDir>
	<!-- dao目录 -->
	<DaoDir ConType="dir">/root/demo/demo/src/main/java/com/bookool/demo/dao</DaoDir>
	<!-- service目录 -->
	<ServiceDir ConType="dir">/root/demo/demo/src/main/java/com/bookool/demo/service</ServiceDir>
	<!-- service.impl目录 -->
	<ServiceImplDir ConType="dir">/root/demo/demo/src/main/java/com/bookool/demo/service\impl</ServiceImplDir>
</Config>
```
注意：目录必须存在！

### 2、执行
1.生成jar包；
2.使用命令行执行下列命令：
```
java -jar MyBatis3AutoCode.jar config.xml
```
其中：MyBatis3AutoCode.jar 为生成的 jar 包， config.xml 为配置文件路径。

## 注意
* 表脚本必须要有字段注释和表注释。
* 程序会生成 autocode.log 日志文件。
