<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.zhku.linye.shop.Shop" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShopInfo.jsp' starting page</title>
<style type="text/css">
	div{
		text-align:justify;
		font-size:25px;
		line-height:50px;
	}
	input{
		height:30px;
		font-size:25px;
	}
</style>
  </head>
  
  <body>
  	<%
  		request.setCharacterEncoding("UTF-8");
    	Shop shop = (Shop)request.getAttribute("shop");
   	%>
   	<form action="servlet/ShopInfoCtrl"  method="post">
    <h3>卖家资料 / Personal information</h3>
    <hr align="left" width="95%" color="#d0d0d0" size="1">
    
    <div align="center"> 
    <img src="images/getAvatar.do.jpg" style="border:3px solid #cccccc;border-radius:50%;height:100px;width:100px"><br>
   店铺名字：<input type="text" name="shopName" value="<%= shop.getShopName()%>" ><br>
   店铺描述：<input type="text" name="description" value="<%= shop.getDescription()%>" ><br>
   建立时间：<%= shop.getBuildTime() %><br> 
   店铺主人：<%= shop.getUsername()  %><br>
    </div>
    <div ><input type="submit" value="保存修改"></div>
    </form> 
  </body>
</html>
