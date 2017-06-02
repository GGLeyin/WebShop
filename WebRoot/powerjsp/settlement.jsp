<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>结算</title>
	<link href="../css/settlement.css" rel="stylesheet" type="text/css" />
    <script src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/settlement.js"></script>

</head>

<body>
<div class="top">
	  <div>
             <c:if test="${user.getUsername()==null }">
			  	<div class="titleleft"><a href="../login.jsp">亲，请登录</a><a href="../register.jsp">免费注册</a></div>
			 </c:if>
			 <c:if test="${user.getUsername()!=null }">
	    		<div class="titleleft">${user.getUsername() }<a href="${pageContext.request.contextPath }/LoginOutCtrl">注销</a></div>
	    	</c:if>
               <div class="titleright">
                    <a href="./person.jsp">
                        <img class="ico" src="../image/customer.png" width="15" height="14" />个人中心
                    </a>
                    <a href="${pageContext.request.contextPath }/CartShowCtrl">
                        <img class="ico" src="../image/shoppingcart.png" width="15" height="14" />购物车
                    </a>
                    <c:if test="${user.shopName != null }">
			    	<a href="../SaleBack.jsp?shopName=${user.shopName}">
			    		<img class="ico" src="../images/seller.png" width="17" height="16" />卖家中心
			    	</a>
			    	</c:if>
			    	<c:if test="${user.shopName == null && user.username != null}">
			    	<a href="../FreeOpen.jsp">
			    		<img class="ico" src="../images/seller.png" width="17" height="16" />卖家中心
			    	</a>
			    	</c:if>
			    	<c:if test="${user.username == null && user.shopName== null }">
			    	<a href="../login.jsp">
			    		<img class="ico" src="../images/seller.png" width="17" height="16" />卖家中心
			    	</a>
			    	</c:if>
               </div>
      	</div>
	  	<div class="search">
               <form id="form1" name="form1" method="post" action="${pageContext.request.contextPath }/NameOSalesCtrl">
	    	   <input name="goodsNameInput" type="text" class="searchtext" required="required"/>
               <input name="" type="submit" class="searchbutton" value="搜索" />
               </form>
	  	</div>
 </div>
 <div class="content">
    <form action="../AddOrdersCtrl" method="post">
    	<div class="mytitle">确认收货地址</div>
        <table width="200" border="1">
          <tr>
            <td width="12%">收货人：</td>
            <td width="70%"><input name="consignee" type="text" class="inputstyle" value="${user.consignee }" required/></td>
            <td id="msg1" style="color:red;font-size:14px"></td>
          </tr>
          <tr>
            <td>手机号码：</td>
            <td><input name="phone" type="text" class="inputstyle" value="${user.phone }" required/></td>
            <td id="msg2" style="color:red;font-size:14px"></td>
          </tr>
          <tr>
            <td>收货地址：</td>
            <td>
            <input name="address" type="text" class="inputstyle" value="${user.address }" required/>
            </td>
          </tr>
        </table>
        <div class="mytitle">确认支付方式</div>
        <div style="margin-top:20px;margin-bottom:16px" ><input type="radio" name="" checked/>余额支付</div>
        <div class="mytitle">订单信息</div>
		<table>
          <tr>
            <th>商品信息</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
          </tr>
          <c:forEach items="${pendingCart}" var="map"> 
		  		<tr>
			    	<td>${map.get("goodsName") }</td>
			    	<td>${map.get("price") }</td>
			    	<td>x${map.get("quantity") }</td>
			    	<td class="subtotal">${map.get("subtotal") }</td>
			    </tr>
		 </c:forEach>
      </table>
      <div class="total">合计：￥<span id="totalNum">0</span></div>
		<div class="submitarea"><input name="submit" type="submit" class="submitbutton" value="提交订单" onclick="return check()"/><a href="#" class="reset" onclick="makesure()">取消</a></div>
    </form>
    </div>
 </body>
</html>
