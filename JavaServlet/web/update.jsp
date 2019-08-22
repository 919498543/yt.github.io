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
    <style>
        div2{
            color: red;

            font-size: 40px;
        }
    </style>
</head>
<body>
<br>
<h3 align="center">修改用户信息</h3>
<br>
<br>
<div align="center">
    <div class="container" style="..." align="center">
        <form class="form-horizontal" action="/servletUpdate" method="post" >
            <div class="form-group" align="center" hidden >
                <label for="inputPassword3" class="col-sm-4 control-label">用户名：</label>
                <div class="col-sm-5" align="center">
                    <input type="text" align="center" class="form-control" value="${user.number}" name="username"  placeholder="密码">
                </div>
            </div>
            <div class="form-group" align="center">
                <label for="inputPassword3" class="col-sm-4 control-label">密码：</label>
                <div class="col-sm-5" align="center">
                    <input type="password" align="center" class="form-control" value="${user.password}" name="password" id="inputPassword3" placeholder="密码">
                </div>
            </div>
            <div class="form-group" align="center">
                <label for="inputPassword3" class="col-sm-4 control-label">姓名：</label>
                <div class="col-sm-5" align="center">
                    <input type="text" align="center" onkeyup="this.value=value.replace(/\D/g,'')" class="form-control" value="${user.name}" name="name"  placeholder="姓名">
                </div>
            </div>
            <div class="form-group" align="center">
                <label for="inputPassword3" class="col-sm-4 control-label">年龄：</label>
                <div class="col-sm-5" align="center">
                    <input type="text" align="center" onkeyup="value=value.replace(/\D/g,'')" onafterpaste="value=value.replace(/\D/g,'')" class="form-control" value="${user.age}" name="age"  placeholder="年龄">
                </div>
            </div>
            <div class="form-group" align="center">
                <div class="col-sm-offset-2 col-sm-8">
                    <button type="submit" class="btn btn-default btn-lg">确定</button>
                    <button type="reset"
                            class="btn btn-default btn-lg">取消</button>
                    <button type="button" onclick="javascript:history.back(-1);" class="btn btn-default btn-lg">返回</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div align="center">
    <div2 >${update_error}</div2>
</div>
</body>
</html>
