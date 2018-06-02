<%--
  Created by IntelliJ IDEA.
  User: FJianC
  Date: 2018/5/28
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html" charset="UTF-8">
        <title>客户管理系统</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">

        <script src="js/jquery-3.3.1.min.js"></script>
    </head>
    <body>
        <div>
            <div class="tool">
                <div class="tool-left">
                    <button onclick="showAdd()">添加</button>
                    <button onclick="showEdit()">修改</button>
                    <button type="submit" form="cus-form" onclick="delCus()">删除</button>
                </div>
                <div class="tool-right">
                    <form action="${pageContext.request.contextPath}/cuslist?pageNum=1" method="post">
                        <label>客户名称：</label>
                        <input type="text" name="searchName" value="${searchName}">
                    </form>
                </div>
                <%--<a href="${pageContext.request.contextPath}/test">测试：批量添加1000</a>--%>
            </div>
            <div class="table">
                <c:if test="${empty pageBean}">
                    <%response.sendRedirect(request.getContextPath() + "/cuslist?pageNum=1");%>
                </c:if>
                <form method="post" id="cus-form" action="${pageContext.request.contextPath}/cusdel?pageNum=1&searchName=${searchName}">
                    <table border="1" align="center" width="600px">
                        <caption style="font-size: 30px">客户列表</caption>
                        <thead>
                        <th>勾选</th><th>名称</th><th>性别</th><th>电话</th><th>邮箱</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageBean.data}" var="cus">
                            <tr>
                                <td><input type="checkbox" name="item" value="${cus.id}"/></td>
                                <td>${cus.name}</td>
                                <td>${cus.gender}</td>
                                <td>${cus.phone}</td>
                                <td>${cus.email}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
            <div class="page">
                <span>共有${pageBean.totalPage}页，${pageBean.totalRecord}个客户</span><br/><br/>
                <c:if test="${pageBean.pageNum != 1}">
                    <a href="${pageContext.request.contextPath}/cuslist?pageNum=1">首页</a>
                    <a href="${pageContext.request.contextPath}/cuslist?pageNum=${pageBean.pageNum - 1}&searchName=${searchName}">上一页</a>
                </c:if>
                <c:if test="${pageBean.pageNum == 1}">
                    <a href="javascript:return false" style="visibility: hidden">首页</a>
                    <a href="javascript:return false" style="visibility: hidden">下一页</a>
                </c:if>
                <c:forEach begin="${pageBean.startPage}" end="${pageBean.endPage}" var="i">
                    <c:if test="${pageBean.pageNum == i}">
                        ${i}
                    </c:if>
                    <c:if test="${pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/cuslist?pageNum=${i}&searchName=${searchName}">${i}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${pageBean.pageNum != pageBean.totalPage}">
                    <a href="${pageContext.request.contextPath}/cuslist?pageNum=${pageBean.pageNum + 1}&searchName=${searchName}">下一页</a>
                    <a href="${pageContext.request.contextPath}/cuslist?pageNum=${pageBean.totalPage}&searchName=${searchName}">尾页</a>
                </c:if>
                <c:if test="${pageBean.pageNum == pageBean.totalPage}">
                    <a href="javascript:return false" style="visibility: hidden">上一页</a>
                    <a href="javascript:return false" style="visibility: hidden">尾页</a>
                </c:if>
            </div>
        </div>
        <div class="dialog">
            <div class="cus-add">
                <div class="dialog-title">添加客户</div>
                <div class="dialog-content">
                    <form action="${pageContext.request.contextPath}/cusadd?pageNum=${pageBean.totalPage}" method="post" id="add-form">
                        <label>名称：</label><input type="text" name="name"><br/><br/>
                        <label>性别：</label>
                        <input type="radio" name="gender" checked="checked" value="男">男
                        <input type="radio" name="gender" value="女">女<br/><br/>
                        <label>电话：</label><input type="text" name="phone"><br/><br/>
                        <label>邮箱：</label><input type="text" name="email"><br/><br/>
                    </form>&emsp;&emsp;
                    <button type="submit" form="add-form" onclick="closeAdd()">添加</button>&emsp;&emsp;
                    <button onclick="closeAdd()">取消</button>
                </div>
            </div>
            <div class="cus-edit">
                <div class="dialog-title">修改客户</div>
                <div class="dialog-content">
                    <form action="${pageContext.request.contextPath}/cusedit?pageNum=${pageBean.pageNum}&searchName=${searchName}" method="post" id="edit-form">
                        <input type="hidden" id="edit-id" name="id">
                        <label>名称：</label>
                            <input type="text" id="edit-name" name="name"><br/><br/>
                        <label>性别：</label>
                            <input type="radio" id="edit-gender-male" name="gender" value="男">男
                            <input type="radio" id="edit-gender-female" name="gender" value="女">女<br/><br/>
                        <label>电话：</label>
                            <input type="text" id="edit-phone" name="phone"><br/><br/>
                        <label>邮箱：</label>
                            <input type="text" id="edit-email" name="email"><br/><br/>
                    </form>&emsp;&emsp;
                    <button type="submit" form="edit-form">修改</button>&emsp;&emsp;
                    <button onclick="closeEdit()">取消</button>
                </div>
            </div>
        </div>
    </body>
    <script src="js/index.js"></script>
</html>
