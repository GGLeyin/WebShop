<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>购物车</title>
	<link href="../style/cart.css" rel="stylesheet" type="text/css" />
    <script src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/cart.js"></script>

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
                        <img class="ico" src="../images/customer.png" width="15" height="14" />个人中心
                    </a>
                    <a href="${pageContext.request.contextPath }/CartShowCtrl">
                        <img class="ico" src="../images/shoppingcart.png" width="15" height="14" />购物车
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
               <form id="form1" name="form1" method="post" action="${pageContext.request.contextPath }/SearchGoodsCtrl?option=sales">
	    	   <input name="goodsNameInput" type="text" class="searchtext" required="required"/>
               <input name="" type="submit" class="searchbutton" value="搜索" />
               </form>
	  	</div>
 </div>
  <form action="${pageContext.request.contextPath }/SettlementCtrl" method="post">
     <div class="goodstable">
        <c:if test="${cart.isEmpty() }">
  			<div align="center">你的购物车还没有商品</div>
  			<div align="center"><a href="../index.jsp" style="color:red">返回首页</a></div>
  		</c:if>
  		<c:if test="${!cart.isEmpty() }">
		  	<table>
		  	<tr><th>请勾选</th><th>商品</th><th>单价</th><th>数量</th><th>小计</th><th>操作</th></tr>
		  	<c:forEach items="${cart}" var="map"> 
		  		<tr>
		  			<td class="checkbox"><input type="checkbox" name="cartID" value="${map.get('cartID') }" id="cartID"/></td>
			    	<td class="goods"><img src="../${map.get('imagePath') }"/><span><a href="${pageContext.request.contextPath }/GoodsDetailsCtrl?goodsID=${map.get('goodsID')}">${map.get('goodsName') }</a></span></td>
			    	<td class="price">${map.get('price') }</td>
			    	<td class="count"><input type="text" value="${map.get('quantity') }" onchange="changeQuantity(this,${map.get('cartID') },${map.get('quantity') })"/></td>
			    	<td id="subtotal" class="subtotal">${map.get('subtotal') }</td>
			    	<td class="operation"><a href="${pageContext.request.contextPath }/DeleteCartCtrl?cartID=${map.get('cartID') }" id="deleteCart">删除</a></td>
			    </tr>
			</c:forEach>
			</table>
		</c:if>
    </div>
    <div class="foot">
        <label><input type="checkbox" id="allSelect" name=""/>全选</label>
        <div class="delete"><a href="#" id="alldelete">删除</a></div>
        <div class="settlement"><input type="submit" value="结算" id="settlement"/></div>
        <div class="total">合计：￥<span id="totalNum">0</span></div>
        <div class="selected">已选商品<span id="selectedNum">0</span>件</div>
      </div>
 </form>
</body>
</html>
