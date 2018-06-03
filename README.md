# CustomerManagement
## JavaWeb项目-客户管理系统 

## 项目介绍
管理客户的信息，JSP + Servlet + MySql

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
- 前端的弹窗使用js+css

## 准备
1.导入第三方jar包以及c3p0配置文件。

- c3p0.jar
- mchange-commons.java.jar
- commons-dbutils.jar
- taglibs-standard-impl-1.2.5.jar
- mysql-connector-java.jar

2.建包

- dao
-- impl
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
 ![image](https://github.com/FJianC/CustomerManagement/blob/master/image/add.JPG)
 

### 查询客户
 ![image](https://github.com/FJianC/CustomerManagement/blob/master/image/cuslist.JPG)


### 编辑客户
 ![image](https://github.com/FJianC/CustomerManagement/blob/master/image/edit.JPG)



## 项目步骤
### 了解自己要做一个什么项目
- 我要做一个客户信息的管理系统，要看到所有的客户信息，可以对客户信息进行增删查改。
### 设计这个项目的界面
- 一个表格用来呈现客户信息，三个按钮用来对客户信息进行增删改，一个搜索框用来查询客户信息。
- 增删改我选择用弹出窗。
- 如果客户信息太多，显示客户信息的表格会很长，所有我要增加一个分页栏。
- 写好html、js、css
### 设计数据库
- customer表应该有5个字段，id、name、gender、phone、email，id作为主键可以用UUID或者自增。
### 写customer实体类
- customer实体类应该有5个变量对应数据库的5个列。
- 测试
### 建立数据库连接
- 导入c3p0相关的包，配置c3p0-config.xml相关配置。
- 写JdbcUtils的类，用于获取c3p0连接池，建立连接断开连接等。
- 测试
### 写dao
- 我是先写dao的接口，再实现dao的。dao是对数据库进行操作，应该有增删改查4个方法，考虑到搜索框以客户名字进行搜索，应该增加一个findByName(String name)的方法。
- 为了简化、方便，我导入commons-dbutils.jar，用来简化代码，方便操作。
- 测试
### 写service
- 实现数据库操作时，也可以对事务逻辑的处理。
- 在add、edit客户信息的方法中，如果客户名称为空或者纯空格时进行了处理。
- 测试
### 写主页的servlet与jsp
- servlet和jsp我是同时写的。
- 先写呈现客户信息的cuslist的servlet，调用service的findAll()方法，获得一个list集合。
- 然后传到域中，在jsp页面遍历这个list集合，在这我用了JSTL标签库<c:forech>进行遍历。
- 测试
### 写add的servlet与jsp
- 用表单提交数据，servlet获取数据，封装到一个customer实体中添加到数据库，重定向到cuslist的servlet进行表格刷新。
- 测试
### 写edit的servlet与jsp
- 由于我不想在表格增加一个修改/删除的操作列，所以我选择以勾选到的行然后点击修改。
- 如果点击了多个勾选，则只会对第一个勾选到的行进行修改，用js获取勾选到的行的信息，填充到修改弹出框中。
- 表单提交数据（在这应该也要提交客户的id），然后写servlet获取数据，封装到customer实体中，修改数据库，重定向到cuslist的servlet进行表格刷新。
- 测试
### 写delete的servlet与jsp
- 删除操作，我选择了可以支持同时删除多个客户信息，勾选多个行，点击删除按钮，弹出提示框是否继续删除，是则跳转到delete的servlet。
- 获取数据，遍历删除数据库信息，重定向到cuslist的servlet进行表格刷新。
- 测试
### 写分页功能
- 写一个pageBean实体类，用于设置分页信息，及封装每页显示的数据。
- 写pageBean的dao方法，实现对数据库的查找，涉及到sql语句 limit关键字
- 重写cuslist的servlet。用pageBean封装的数据替换原来的list集合的数据。
- 在jsp页面遍历pageBean的数据，分页栏同样显示pageBean的数据。
- 修改全部from表单的action，带上一个pageNum的参数。
- 测试
### 写搜索功能
- 初步设计是，搜索框为空则查找全部，不为空时则进行模糊搜索。
- 在cuslist的servlet中增加一个判断search是否为空，不为空则模糊查询，获得的数据集合，对数据进行分页的处理，替换pageBean的data数据。
- 为了实现对搜索到的结果进行增删改，所有jsp的from的action都增加searchName的参数，传递到servlet。
- 测试






