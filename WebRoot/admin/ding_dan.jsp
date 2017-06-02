<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>订单详情页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<script src="${pageContext.request.contextPath }/admin/js/del_dingdan.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/style.css" />
	</head>
	<body>
		<div class="m-right">
			<div class="right-nav">
			<ul>
			  <li><img src="${pageContext.request.contextPath }/admin/images/home.png"></li>
			  <li style="margin-left:5px;"><a href="${pageContext.request.contextPath }/admin/right.jsp">返回首页</a></li>
			  <li style="margin-left:5px;">您当前的位置：</li>
			  <li><span>订单详情</span></li>
			</ul>
		 </div>
		 
		 <!--右边内容-->
		 <div class="main">	
		 <!--此处为模糊查询-->
		 		<form name="form1" action="${pageContext.request.contextPath }/AdminOrdersAction?action=all" method="post">
					<p align="center">
						请输入客户名:<input type="text" name="name">
						<input type="submit" value="查询">
					</p>
				</form>				
				<!--此处为显示所有信息-->
				
					<table border="1px" align="center" width="600px" cellspacing="0px" bgcolor="#f0f0f0">
					<caption>订单</caption>
						<tr bgcolor="#7fdbf9">
							<td>id</td>
							<td>客户名</td>
							<td>商店名</td>
							<td>商品名</td>
							<td>数量</td>
							<td>价格</td>
							<td>收货人</td>
							<td>电话</td>
							<td>地址</td>
							<td>状态</td>
							<td>时间</td>
							<td>操作</td>
						</tr>
											
						<!--此处循环出数据库里的内容-->
						<c:forEach var="n" items="${orderslist}">
						
							<tr onMouseOver="this.style.backgroundColor='yellow'" onMouseOut="this.style.backgroundColor='' ">
								<td>${n.orderID}</td>
								<td>${n.username}</td>
								<td>${n.shopName}</td>
								<td>${n.goodsName}</td>
								<td>${n.quantity}</td>
								<td>${n.price}</td>
								<td>${n.consignee}</td>
								<td>${n.phone}</td>
								<td>${n.address}</td>
								<td>${n.state}</td>
								<td>${n.time}</td>
								<td><input type="button" id="btn" value="发货" onclick="sendGoods()"></td>
								
							</tr>
						</c:forEach>					
					</table>
				
		 </div>
		</div>
	</body>
</html>
