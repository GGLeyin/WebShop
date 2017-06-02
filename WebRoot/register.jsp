<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>注册界面</title>
	<link rel="stylesheet" type="text/css" href="style/register.css" />
	<script type="text/javascript" src="./js/msg.js"></script>
	<script src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/register.js"></script>
    
  </head>
  
  <body>
    <div class="top"><a href="./index.jsp"><img src="images/shop.jpg" width="113" height="80" /></a></div>
   <div class="background">
  <div class="registerbg">
    <div class="registertitle">商城注册</div>
    <form action="./RegisterCtrl" method="post">
    	<div id="message" class="tips"></div>
     	<div class="account"><input id="username" name="username" type="text" class="accountarea"maxLength="24" placeholder="用户名"/></div>
      	<div class="password"><input id="password" name="password" type="password" class="passwordarea" maxLength="24" placeholder="密码" /></div>
      	<div class="password"><input id="password2" name="password2" type="password" class="passwordarea" maxLength="24" placeholder="确认密码" /></div>
      	<div class="register"><input id="button" type="submit" class="registerbutton" value="注册" onclick="return check()"/></div>
      	<div class="mylink"><a href="login.jsp">登录</a></div>
    </form>
  </div>
</div>
  </body>
</html>
