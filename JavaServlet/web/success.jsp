<%--
  Created by IntelliJ IDEA.
  User: 91949
  Date: 2019/8/17
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>用户管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td,th{
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(username) {
            if(confirm("您确定要删除吗？"))
            {
                location.href="${pageContext.request.contextPath}/servletDelete?username="+username;
            }
        }
        window.onload=function ()
        {
            document.getElementById("del").onclick=function()
            {
                if(confirm("您确定要删除吗？")) {
                    var flag=false;
                    var cbs= document.getElementsByName("uid");
                    for (var i = 0; i <cbs.length ; i++) {
                        if(cbs[i].checked)
                        {
                            flag=true;
                            break;
                        }
                    }
                    if(flag){
                    document.getElementById("checkform").submit();
                    }
                }
            }
            document.getElementById("firstCb").onclick=function () {
               var cbs= document.getElementsByName("uid");
                for (var i = 0; i <cbs.length ; i++) {
                    cbs[i].checked=this.checked;
                }
            }
        }
    </script>

</head>
<body>
<br>
<h1 align="center"><%=request.getSession().getAttribute("user")%>,欢迎您</h1>
<div class="container">
    <br>
    <h2 align="center">用户信息列表</h2>
    <br>
    <div style="float: left;">
        <form class="form-inline" action="/servletCondition" method="post">
            <div class="form-group">
                <label >姓名</label>
                <input type="text" class="form-control" value="${map.name[0]}" name="name" placeholder="输入姓名">
            </div>
            <div class="form-group">
                <label >年龄</label>
                <input type="text" class="form-control" onkeyup="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')" value="${map.age1[0]}" name="age1" placeholder="输入年龄">
            </div>
            <div class="form-group">
                <label >—</label>
                <input type="text" class="form-control" onkeyup="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')" value="${map.age2[0]}" name="age2" placeholder="输入年龄">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float:right;">
        <a class="btn btn-primary btn-lg" href="add.jsp">添加</a>
        <a class="btn btn-primary btn-lg" href="javascript:void(0);" id="del">批量删除</a>
    </div>
    <form id="checkform" action="/servletDel" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
            <th>账号</th>
            <th>密码</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>操作</th>

        </tr>
        <c:forEach items="${page.list}" var="user">
            <tr>
                <td><input type="checkbox" name="uid" value="${user.number}"></td>
                <td>${user.number}</td>
                <td>${user.password}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/servletFind?username=${user.number}">修改</a>
                <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.number});">删除</a></td>
            </tr>
        </c:forEach>
        <tr>

        </tr>

    </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.currentPage==1}">
                    <li class="disabled">
                </c:if>
                <c:if test="${page.currentPage!=1}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/servletCondition?currentPage=${page.currentPage-1}&rows=5&name=${map.name[0]}&age1=${map.age1[0]}&age2=${map.age2[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${page.totalPage}" var="i">
                    <c:if test="${page.currentPage==i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/servletCondition?currentPage=${i}&rows=5&name=${map.name[0]}&age1=${map.age1[0]}&age2=${map.age2[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${page.currentPage!=i}">
                        <li ><a href="${pageContext.request.contextPath}/servletCondition?currentPage=${i}&rows=5&name=${map.name[0]}&age1=${map.age1[0]}&age2=${map.age2[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.currentPage==page.totalPage}">
                    <li class="disabled">
                </c:if>
                <c:if test="${page.currentPage!=page.totalPage}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/servletCondition?currentPage=${page.currentPage+1}&rows=5&name=${map.name[0]}&age1=${map.age1[0]}&age2=${map.age2[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 8px">
                    共${page.totalCount}条记录，共${page.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
