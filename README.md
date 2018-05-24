# SSMLayUI

#### 项目介绍
1. SSMLayUI + 分页插件PageHelper + 通用Mapper插件 + 通用Service + Maven方式Mybatis Geneator示例

#### 软件架构
1. Spring + SpringMVC + MyBatis + PageHelper + 通用Mapper

#### 安装教程

1. 解压后执行src\main\resources\sql\MySQL.sql脚本创建数据库和表
2. 在pom.xml这一级目录(即项目根目录下)的命令行窗口执行(前提是配置了mvn)，创建Entity和Mapper后正常启动即可
```
mvn mybatis-generator:generate
```

#### 使用说明

1. 个人借鉴通用Mapper的Demo加入LayUI整合SSM做的一个小Demo
2. 一个简单的增删改查Demo

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
