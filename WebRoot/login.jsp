<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>登录界面</title>
    <link href="style/login.css" rel="stylesheet" type="text/css" />
    <script src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/msg.js"></script>
    
  </head>
  
  <body>
  <div class="top"><a href="./index.jsp"><img src="images/shop.jpg" width="113" height="80" /></a></div>
  	<div class="background">
  		<div class="loginbg">
    		<div class="logintitle">商城登录</div>
   			<form action="./LoginCtrl" method="post">
   				<div id="message" class="tips"> ${msg } </div>
      			<div class="account">
      				<input name="username" type="text" class="accountarea"maxLength="24" placeholder="用户名" required/>
      			</div>
      			<div class="password">
      				<input name="password" type="password" class="passwordarea" maxLength="24" placeholder="密码" required/>
      			</div>
      			<div class="login">
      				<input type="submit" class="loginbutton" value="登录" />
      			</div>
     			<div class="mylink"><a href="register.jsp">注册</a></div>
    		</form>
  		</div>
	</div>
  </body>
</html>
