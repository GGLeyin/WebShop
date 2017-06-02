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
    
    <title>My JSP 'OrderCheck.jsp' starting page</title>
  
	
	  <style type="text/css" >
	  	td{height:50px;}
	  	a:hover {color: #F30;}
	  	a {color: #ff00000;font-weight: normal;text-decoration: none;}
	  </style>
  </head>
  
  
  
  
  <body>
  <h3>订单管理/ Orders</h3>
    <hr align="left" width="95%" color="#d0d0d0" size="1">
   <form method="post" id="form1">
	   <table border="1" cellspacing="0" align="center">
	   
	   	<tr align="left">
		   	<th colspan="8" align="left">
			   	订单编号：<input type="text" name="orderID" style="width:400px"><input type="submit" value="搜索" ><br><br>
			   	交易状态：<a href="servlet/OrderCheckCtrl">全部</a>
			   	 <a href="servlet/OrderCheckCtrl?state=待发货">待发货</a>
			   	 <a href="servlet/OrderCheckCtrl?state=待收货">待收货</a>
			   	 <a href="servlet/OrderCheckCtrl?state=已收货">已收货</a>

		   	 </th>
	   	</tr>
	  
	   	<tr style="background:#ccc">
	   		<th>商品信息</th>
	   		<th>单价(元)</th>
	   		<th>数量</th>
	   		<th>总价格(元)</th>
	   		<th>订单状态</th>
	   		<th>操作</th>
	   	</tr>
	 	 	<%
			request.setCharacterEncoding("utf-8");
			List<Order> list =(List<Order>)request.getAttribute("list");
			if(list==null||list.size()<1){
				out.print("<tr><td align='center' colspan='6'>没有订单信息！</td></tr>");
			}else{
				for(Order order:list){
				   	pageContext.setAttribute("order",order);
		 %> 
		 <tr>
		 	<th colspan="6" style="text-align:left">
		 	订单编号：<a href="servlet/DetailOrderCtrl?orderID=${order.orderID}">${order.orderID}</a>&nbsp;&nbsp;
		 	下单时间：${order.time}&nbsp;&nbsp;
		 	买家：${order.username}
		 	</th>
		 </tr>
		
	   	<tr style="text-align:center">  
	   		<td>${order.goodsName}</td>
	   		<td>￥${order.price*1.0}</td>
	   		<td>${order.quantity}</td>
	   		<td>￥${order.price * order.quantity * 1.0}</td>
	   		<td>${order.state}</td>
	   		<td>
		   		<c:if test="${order.state eq '待发货'}">	
		   			<input type="button" value="发货" onclick="location.href='servlet/OrderEditCtrl?orderID=${order.orderID}'" >
		   		</c:if>
		   		<c:if test="${order.state eq '待收货'}">	
		   			<a href="servlet/DetailOrderCtrl?orderID=${order.orderID}">订单详情</a>
		   		</c:if>
		   		<c:if test="${order.state eq '已收货'}">	
		   			<a href="servlet/OrderDeleCtrl?orderID=${order.orderID}" >删除订单</a>
		   		</c:if>
	   		</td>
	   	</tr>
	   	
	   	<%
		    	}
		    }
		 %>
	   </table>
   </form>
  </body>
</html>
