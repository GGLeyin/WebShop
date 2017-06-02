<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>店铺开通</title>
	<link rel="stylesheet" type="text/css" href="style/register.css" />
	<script type="text/javascript" src="./js/msg.js"></script>
	<script src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/openshop.js"></script>
    
  </head>
  
  <body>
    <div class="top"><a href="./index.jsp"><img src="images/shop.jpg" width="113" height="80" /></a></div>
   <div class="background">
  <div class="registerbg">
    <div class="registertitle">店铺开通</div>
    <form action="servlet/OpenCtrl"  method="post">
    	<div id="message" class="tips"></div>
     	<div class="account"><input id="shopName" name="shopName" type="text" class="accountarea"maxLength="24" placeholder="你的小铺名称"/></div>
      	<div class="account"><input id="description" name="description" type="text" class="accountarea"maxLength="24" placeholder="描述下你的小铺"/></div>
      	<div class="register"><input id="button" type="submit" class="registerbutton" value="立即开通" onclick="return check2()"/></div>
      	<div class="mylink"><a href="index.jsp">返回</a></div>
    </form>
  </div>
</div>
  </body>
</html>
