<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>商品详情</title>
    <script src="./js/jquery.js"></script>
    <script type="text/javascript" src="js/goodsDetails.js"> </script> 
    <link href="./style/detail.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(function(){
			$("#addcart").click(function(){
				if("${user.username!=null}"=="false"){
					alert("请先登录！");
					return false;
				}else{
					return true;
				}
			});
		});
	 </script> 
  </head>
  
  <body>
    <div class="top">
	  <div>
	  	<c:if test="${user.username==null }">
	  		<div class="titleleft"><a href="login.jsp">亲，请登录</a><a href="register.jsp">免费注册</a></div>
	  	</c:if>
	    <c:if test="${user.username!=null }">
	    <div class="titleleft">${user.username }<a href="${pageContext.request.contextPath }/LoginOutCtrl">注销</a></div>
	    </c:if>
	    <div class="titleright">
	    	<a href="./powerjsp/person.jsp">
	    		<img class="ico" src="images/customer.png" width="15" height="14" />个人中心
	    	</a>
	    	<a href="${pageContext.request.contextPath }/CartShowCtrl">
	    		<img class="ico" src="images/shoppingcart.png" width="15" height="14" />购物车
	    	 <c:if test="${user.shopName != null }">
	    	<a href="SaleBack.jsp?shopName=${user.shopName}">
	    		<img class="ico" src="images/seller.png" width="17" height="16" />卖家中心
	    	</a>
	    	</c:if>
	    	<c:if test="${user.shopName == null && user.username != null}">
	    	<a href="FreeOpen.jsp">
	    		<img class="ico" src="images/seller.png" width="17" height="16" />卖家中心
	    	</a>
	    	</c:if>
	    	<c:if test="${user.username == null && user.shopName== null }">
	    	<a href="login.jsp">
	    		<img class="ico" src="images/seller.png" width="17" height="16" />卖家中心
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
   <div class="guidance" >
  	<div class="alltype">全部分类</div>
    <div class="homepage"><a href="./index.jsp">首页</a></div>
  </div>
   <div class="showall">
   	<div style="font-size:14px;margin-bottom:10px">&nbsp;<a href="./index.jsp">首页</a> › <a href="./search.jsp">搜索结果</a> › 商品详情</div>
 	<form action="./AddCartCtrl">
	    <div class="showbot">
             <div id="showbox">
                  <img src="${goods.imagePath }" width="400" height="400" /> 
             </div>
        </div>
       <div class="tb-property">
             <div class="tr-nobdr">
                  <h3> ${goods.goodsName }</h3>
             </div>
             <div class="txt">
                  <span class="nowprice">￥${goods.price }</span>
                  <div class="cumulative">
               		<span class="number ty1">累计售出<br /><em id="add_sell_num_363">${goods.sales }</em></span>
           	   </div>
   		 </div>
        	 <div class="txt-h">
             	 <span class="tex-o">类型：</span>
                 <span class="tex-o">${goods.type }</span>
        	 </div>
        	 <div class="gcIpt">
                 <span class="guT">数量</span>
                 <input id="min" name="" type="button" value="-" />  
                 <input id="quantity" name="quantity" type="text" value="1" readonly style="width:40px; text-align: center; color: #0F0F0F;"/>  
                 <input id="add" name="" type="button" value="+" />
                 <span class="Hgt">库存（<span id="inventory">${goods.inventory }</span>）</span>
       	    </div>
        	<div class="nobdr-btns">
                 <input id="addcart" name="" type="submit" class="addcart" value="加入购物车" onclick="return isAdd();">
       	  </div>
	  </div>
		<div class="extInfo">
         	<div class="seller-pop-box">
            	<span class="tr">商家名称：${goods.shopName }</span>
            	<span class="tr">官方认证</span>
            	<span class="tr">食品安全认证</span>
         	</div>
		</div>
    </form>
</div>                      
  </body>
</html>
