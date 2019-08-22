<%@ page import="LoginTest.User" %><%--
  Created by IntelliJ IDEA.
  User: 91949
  Date: 2019/8/17
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>用户管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>Title</title>
    <script>
        window.onload=function () {
            var img =document.getElementById("img");
            img.onclick=function () {
                //加时间戳
                var date =new Date().getTime();
                img.src="/checkedServlet?"+date;
            }
        }
    </script>
    <style>
        div2{
            color: red;

            font-size: 40px;
        }
    </style>
</head>
<body>
<h3 align="center">登录系统</h3>
<div align="center">
    <div class="container" style="..." align="center">
    <form class="form-horizontal" action="/loginServlet" method="post">
        <div class="form-group" align="center">
            <label for="inputEmail3" class="col-sm-4 control-label">用户名：</label>
            <div class="col-sm-5" align="center">
                <input type="text" align="center" class="form-control" name="username" id="inputEmail3" placeholder="账号/手机号/邮箱">
            </div>
        </div>
        <div class="form-group" align="center">
            <label for="inputPassword3" class="col-sm-4 control-label">密码：</label>
            <div class="col-sm-5" align="center">
                <input type="password" align="center" class="form-control" name="password" id="inputPassword3" placeholder="密码">
            </div>
        </div>
        <div class="form-group">
                <label class="col-sm-4 control-label">验证码：</label>
            <div class="col-sm-2 ">
                <input type="text" align="center" class="form-control" name="checkCode" placeholder="请输入验证码">
            </div>
        </div>
        <div class="form-group">

            <div class="col-sm-10 ">
                <img id="img" src="/checkedServlet">
            </div>
        </div>
        <div class="form-group" align="center">
            <div class="col-sm-offset-2 col-sm-8">
                <button type="submit" class="btn btn-default btn-lg">登录</button>
            </div>
        </div>
    </form>
    </div>
</div>
<div align="center">
<div2 >
    <%=request.getAttribute("check_error")==null?"":request.getAttribute("check_error")%>
</div2>
<div2>
    <%=request.getAttribute("login_error")==null?"":request.getAttribute("login_error")%>
    ${login_msg}
</div2>
</div>
</body>
</html>
