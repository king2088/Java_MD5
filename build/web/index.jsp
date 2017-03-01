<%-- 
    Document   : 用户注册登录页面
    Created on : 2017-2-28, 14:20:50
    Author     : 深夜徘徊
--%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户注册与登录</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="main">
            <h1>用户注册登录</h1>
            <div class="reg">
                <h2>用户注册</h2>
                <form action="<%=basePath%>AddUser" method="post">
                    <label>用户名：</label><input type="text" name="uname"><br>
                    <label>密&nbsp;&nbsp;&nbsp;码：</label><input type="text" name="pwd"><br>
                    <label>性&nbsp;&nbsp;&nbsp;别：</label><input id="sex" name="sex" type="radio" value="男" checked>男<input id="sex" name="sex" type="radio" value="女">女<br>
                    <label>地&nbsp;&nbsp;&nbsp;址：</label><input type="text" name="address"><br>
                    <label>Email：</label><input type="text" name="email"><br>
                    <label>电&nbsp;&nbsp;&nbsp;话：</label><input type="text" name="tel"><br>
                    <input type="submit" value="注册">
                </form>
            </div>
            <div class="login">
                <h2>用户登录</h2>
                <form action="<%=basePath%>Login" method="post">
                    <label>用户名：</label><input type="text" name="uname"><br>
                    <label>密&nbsp;&nbsp;&nbsp;码：</label><input type="text" name="pwd"><br>
                    <a class="loginx" href="">找回密码？</a><input type="submit" value="登录">
                </form>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
        <div class="foot">
            CopyRight 2017 Author:深夜徘徊. Power by <a class="loginx" href="http://www.egtch.com">egtch.com</a>
        </div>    
    </body>
</html>