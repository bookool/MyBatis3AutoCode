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
* 仅支持 UTF-8 。


### 生成的dao下的xml文件示例：

```XML
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<!-- 用户表 -->
<mapper namespace="cn.run2.TG.HelloWorld.dao.UsersMapper" >
	<resultMap id="BaseResultMap" type="cn.run2.TG.HelloWorld.model.Users" >
		<!-- 用户ID -->
		<id column="ID" property="id" jdbcType="INTEGER" />
		<!-- 用户姓名 -->
		<result column="UserName" property="username" jdbcType="VARCHAR" />
		<!-- 用户级别 -->
		<result column="UserLevel" property="userlevel" jdbcType="TINYINT" />
		<!-- 用户注释 -->
		<result column="UserNotes" property="usernotes" jdbcType="VARCHAR" />
	</resultMap>

	<sql id="Base_Column_List" >
		ID, UserName, UserLevel, UserNotes
	</sql>

	<!-- 分页 -->
	<sql id="Page">
		<if test="Offset!=null and Rows!=null">
			LIMIT #{Offset,jdbcType=INTEGER}, #{Rows,jdbcType=INTEGER}
		</if>
	</sql>

	<!-- 基础模板 取得 Users 分页列表 -->
	<select id="baseselectListPage" resultMap="BaseResultMap" parameterType="java.util.Map" >
		SELECT
		<include refid="Base_Column_List" />
		FROM TB_Users
		<trim prefix="WHERE" prefixOverrides="AND|OR">
			<if test="id!=null">
				AND ID = #{id, jdbcType=INTEGER}
			</if>
			<if test="username!=null and username!=''">
				AND UserName LIKE CONCAT('%', #{username, jdbcType=VARCHAR}, '%')
			</if>
			<if test="userlevel!=null">
				AND UserLevel = #{userlevel, jdbcType=TINYINT}
			</if>
			<if test="usernotes!=null and usernotes!=''">
				AND UserNotes LIKE CONCAT('%', #{usernotes, jdbcType=VARCHAR}, '%')
			</if>
		</trim>
		<include refid="Page"></include>
	</select>

	<!-- 基础模板 取得一个 Users 对象 -->
	<select id="baseselectTopOneByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.Integer" >
		SELECT
		<include refid="Base_Column_List" />
		FROM TB_Users
		WHERE ID = #{id,jdbcType=INTEGER}
		LIMIT 0,1
	</select>

	<!-- 基础模板 删除 Users 中的数据 -->
	<delete id="basesdeleteByPrimaryKey" parameterType="java.lang.Integer" >
		DELETE FROM TB_Users
		WHERE ID = #{id,jdbcType=INTEGER}
	</delete>

	<!-- 基础模板 添加一条完整的 Users 记录 -->
	<insert id="baseinsert" parameterType="cn.run2.TG.HelloWorld.model.Users" >
		INSERT INTO TB_Users (
			ID, UserName, UserLevel, UserNotes)
		VALUES (
			#{id, jdbcType=INTEGER}, #{username, jdbcType=VARCHAR}, 
			#{userlevel, jdbcType=TINYINT}, #{usernotes, jdbcType=VARCHAR})
	</insert>

	<!-- 基础模板 添加一条 Users 记录 -->
	<insert id="baseinsertSelective" parameterType="cn.run2.TG.HelloWorld.model.Users" >
		INSERT INTO TB_Users
		<trim prefix="(" suffix=")" suffixOverrides="," >
			<if test="id!=null" >
				id,
			</if>
			<if test="username!=null" >
				username,
			</if>
			<if test="userlevel!=null" >
				userlevel,
			</if>
			<if test="usernotes!=null" >
				usernotes,
			</if>
		</trim>
		<trim prefix="VALUES (" suffix=")" suffixOverrides="," >
			<if test="id!=null" >
				#{id, jdbcType=INTEGER},
			</if>
			<if test="username!=null" >
				#{username, jdbcType=VARCHAR},
			</if>
			<if test="userlevel!=null" >
				#{userlevel, jdbcType=TINYINT},
			</if>
			<if test="usernotes!=null" >
				#{usernotes, jdbcType=VARCHAR},
			</if>
		</trim>
	</insert>

	<!-- 基础模板 更新完整的 Users 记录 -->
	<update id="baseupdate" parameterType="cn.run2.TG.HelloWorld.model.Users" >
		UPDATE TB_Users
		<set>
			UserName = #{username,jdbcType=VARCHAR},
			UserLevel = #{userlevel,jdbcType=TINYINT},
			UserNotes = #{usernotes,jdbcType=VARCHAR},
		</set>
		WHERE
			ID = #{id,jdbcType=INTEGER}
	</update>

	<!-- 基础模板 更新 Users 记录 -->
	<update id="baseupdateSelective" parameterType="cn.run2.TG.HelloWorld.model.Users" >
		UPDATE TB_Users
		<set>
			<if test="username!=null" >
				UserName = #{username,jdbcType=VARCHAR},
			</if>
			<if test="userlevel!=null" >
				UserLevel = #{userlevel,jdbcType=TINYINT},
			</if>
			<if test="usernotes!=null" >
				UserNotes = #{usernotes,jdbcType=VARCHAR},
			</if>
		</set>
		WHERE
			ID = #{id,jdbcType=INTEGER}
	</update>

</mapper>
```

### 更新：

### 17-2-2
1、表前缀现在可以为空了；
2、修改了获取字段的正则表达式的bug。

### 17-2-15
1、可指定生成某一张表的代码。
```
java -jar MyBatis3AutoCode.jar config.xml TableName
```

其中：TableName为表名(不加前缀)。

### 17-2-23
1、修改了bug。

### 17-3-4
1、修改了错误的单词。

### 17-4-1
1、修改了时间类型的错误。

### 17-4-12
1、修改了Bug。

### 17-4-16
1、修改了数据类型Bug。

### 17-5-5
1、修改了检测空的Bug。
