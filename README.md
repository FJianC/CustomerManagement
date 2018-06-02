# CustomerManagement
## JavaWeb项目-客户管理系统 

## 项目介绍
管理客户的信息

### 功能介绍

- 添加客户:添加客户的信息，包括姓名，性别，手机，邮箱
- 查询客户:查询数据库中所有的客户，查询结果将客户信息以列表的形式给出，可以对列表中的客户信息进行编辑及删除
- 搜索:根据名字在数据库中进行客户信息的查询，支持模糊搜索，搜索结果以列表的形式给出，可以对列表中的客户信息进行编辑及删除
- 分页:查询到的数据分页显示，同时支持搜索后的数据的分页显示
 
### 运用知识

- 数据库基本查询
- 数据库连接池c3p0
- 运用dbutil.jar包一键封装表单数据到bean对象中
- 利用dbutils.jar包简化对数据库增、删、改、查的代码
- 标签库
- JavaWeb三层框架的分离
- 将servlet的转发、重定向及方法进行封装，这样当设计到多个功能时不用建立多个servlet类。

## 准备
1.导入第三方jar包以及c3p0配置文件。

- c3p0.jar
- mchange-commons.java.jar
- commons-dbutils.jar
- taglibs-standard-impl-1.2.5.jar
- mysql-connector-java.jar

2.建包

- dao
--- impl
- service
- servlet
- domain

## 搭建环境
IntelliJ IDEA  +  MySQL

## 使用方法

1. git clone 
2. 使用IntelliJ IDEA导入打开
3. 创建相应的数据库及表
4. 修改`c3p0-config.xml`中数据库相关信息
5. 部署Tomcat并启动

## 项目功能截图
### 添加客户
 ![image](https://github.com/ButBueatiful/dotvim/raw/master/screenshots/vim-screenshot.jpg)

### 查询客户


### 编辑客户








