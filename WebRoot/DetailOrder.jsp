<%@ page language="java" import="java.util.*,cn.edu.zhku.linye.shop.Order" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DetailOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style type="text/css">
  		th{text-align:center; width:100px;}
  		
  </style>
  
  	<%
		request.setCharacterEncoding("utf-8");
		List<Order> list =(List<Order>)request.getAttribute("list");
		for(Order order:list){
			pageContext.setAttribute("order",order);			
	%> 
  <body>
  	<form action="servlet/OrderCheckCtrl" method="post">
  	<h2 align="center">订单详情</h2>
 	<table align="center" border="1" cellspacing="0">
 		<tr class="tr2">
	 		<td colspan="4">
		 		买家信息<br>
		 		订单编号：${order.orderID}&nbsp;&nbsp;买家用户名：${order.username}<br>
		 		收货人：${order.consignee}&nbsp;&nbsp;收货地址：${order.address}<br>
		 		手机号码：${order.phone}
	 		</td>
 		</tr>
 		<tr>
 			<th>商品信息</th>
 			<th>单价(元)</th>
 			<th>数量</th>
 			<th>总价格(元)</th>
 		</tr>
 		
 		<tr class="tr1">	
 			<td>${order.goodsName}</td>
 			<td>￥${order.price*1.0}</td>
 			<td>${order.quantity}</td>
 			<td>￥${order.price*order.quantity*1.0}</td>
 		</tr>
 		
 		<tr>
 			<td colspan="4" align="center">
 				<input type="submit" value="返货订单列表">
 			</td>
 		</tr>
 	</table>
 	</form>
  	<%
		}
	%>
  </body>
</html>
