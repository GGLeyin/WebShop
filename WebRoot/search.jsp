<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>搜索结果</title>  
    <script src="./js/jquery.js"></script>
    <script type="text/javascript" src="js/main.js"> </script> 
    <link href="style/search.css" rel="stylesheet" type="text/css" />

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
	    	</a>
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
  <div class="content">
    <div><h3>&nbsp;共搜索到${goodslist.totalRows }条相关商品信息</h3></div>
    <c:if test="${goodslist.totalRows>0 }">
    <div style="font-size:14px">&nbsp;<a href="./index.jsp">首页</a> › 搜索结果</div>
    <div class="sort">
    <c:if test="${goodsName!=null&&goodsName!='' }">
        <div><a href="${pageContext.request.contextPath }/NameOSalesCtrl?goodsNameInput=${goodsName }&page=1">销量排序</a></div>
        <div><a href="${pageContext.request.contextPath }/NameOPriceCtrl?goodsNameInput=${goodsName }&page=1">价格优先</a></div>
    </c:if>
    <c:if test="${goodsType!=null&&goodsType!='' }">
        <div><a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=${goodsType }&page=1">销量排序</a></div>
        <div><a href="${pageContext.request.contextPath }/TypeOPriceCtrl?type=${goodsType }&page=1">价格优先</a></div>
    </c:if>
    </div>
    <div class="goods">
  	<ul class="goodsarea">
  		<c:forEach items="${goodslist.data}" var="map">
  		<li>
          <div>
                <a href="${pageContext.request.contextPath }/GoodsDetailsCtrl?goodsID=${map.get('goodsID')}"><img src="${map.get('imagePath') }" /></a>										
            	<p class="goodsname">【${map.get("shopName")}】${map.get("goodsName") }</p>
              	<div class="price">
                  <b>¥</b>
                  <strong>${map.get("price") }</strong>
              	</div>
              	<div class="sales">
                   	 销量<span>${map.get("sales") }</span>
             	</div>
          </div>
        </li>
  		</c:forEach>
    </ul>
    </div>
    <div class="page" >
   		<c:if test="${goodsName!=null&&goodsName!='' }">
	   		<c:if test="${option.equals('price') }">
	   		<c:choose>
	  			<c:when test="${goodslist.curPage==1 }">首页 上一页</c:when>
	  			<c:otherwise>
		  			<a href="${pageContext.request.contextPath }/NameOPriceCtrl?goodsNameInput=${goodsName }&page=1">首页</a>
		  			<a href="${pageContext.request.contextPath }/NameOPriceCtrl?goodsNameInput=${goodsName }&page=${goodslist.curPage-1}">上一页</a>
	  			</c:otherwise>
	  		</c:choose>
	  		<c:choose>
		  		<c:when test="${goodslist.curPage==goodslist.totalPages }">下一页  尾页</c:when>
		  		<c:otherwise>
		  			<a href="${pageContext.request.contextPath }/NameOPriceCtrl?goodsNameInput=${goodsName }&page=${goodslist.curPage+1}">下一页</a>
		  			<a href="${pageContext.request.contextPath }/NameOPriceCtrl?goodsNameInput=${goodsName }&page=${goodslist.totalPages}">尾页</a>
		  		</c:otherwise>
	  		</c:choose>
	  		</c:if>
	  		<c:if test="${option.equals('sales') }">
	   		<c:choose>
	  			<c:when test="${goodslist.curPage==1 }">首页 上一页</c:when>
	  			<c:otherwise>
		  			<a href="${pageContext.request.contextPath }/NameOSalesCtrl?goodsNameInput=${goodsName }&page=1">首页</a>
		  			<a href="${pageContext.request.contextPath }/NameOSalesCtrl?goodsNameInput=${goodsName }&page=${goodslist.curPage-1}">上一页</a>
	  			</c:otherwise>
	  		</c:choose>
	  		<c:choose>
		  		<c:when test="${goodslist.curPage==goodslist.totalPages }">下一页  尾页</c:when>
		  		<c:otherwise>
		  			<a href="${pageContext.request.contextPath }/NameOSalesCtrl?goodsNameInput=${goodsName }&page=${goodslist.curPage+1}">下一页</a>
		  			<a href="${pageContext.request.contextPath }/NameOSalesCtrl?goodsNameInput=${goodsName }&page=${goodslist.totalPages}">尾页</a>
		  		</c:otherwise>
	  		</c:choose>
	  		</c:if>
   		</c:if>
  		<c:if test="${goodsType!=null&&goodsType!='' }">
  		<c:if test="${option.equals('sales') }">
  			<c:choose>
  			<c:when test="${goodslist.curPage==1 }">首页 上一页</c:when>
  			<c:otherwise>
	  			<a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=${goodsType }&page=1">首页</a>
	  			<a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=${goodsType }&page=${goodslist.curPage-1}">上一页</a>
  			</c:otherwise>
  			</c:choose>
  			<c:choose>
	  		<c:when test="${goodslist.curPage==goodslist.totalPages }">下一页  尾页</c:when>
	  		<c:otherwise>
	  			<a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=${goodsType }&page=${goodslist.curPage+1}">下一页</a>
	  			<a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=${goodsType }&page=${goodslist.totalPages}">尾页</a>
	  		</c:otherwise>
  			</c:choose>
  		</c:if>
  		<c:if test="${option.equals('price') }">
  			<c:choose>
  			<c:when test="${goodslist.curPage==1 }">首页 上一页</c:when>
  			<c:otherwise>
	  			<a href="${pageContext.request.contextPath }/TypeOPriceCtrl?type=${goodsType }&page=1">首页</a>
	  			<a href="${pageContext.request.contextPath }/TypeOPriceCtrl?type=${goodsType }&page=${goodslist.curPage-1}">上一页</a>
  			</c:otherwise>
  			</c:choose>
  			<c:choose>
	  		<c:when test="${goodslist.curPage==goodslist.totalPages }">下一页  尾页</c:when>
	  		<c:otherwise>
	  			<a href="${pageContext.request.contextPath }/TypeOPriceCtrl?type=${goodsType }&page=${goodslist.curPage+1}">下一页</a>
	  			<a href="${pageContext.request.contextPath }/TypeOPriceCtrl?type=${goodsType }&page=${goodslist.totalPages}">尾页</a>
	  		</c:otherwise>
  			</c:choose>
  		</c:if>
  		</c:if>
	</div>
    </c:if>
</div>
  </body>
</html>
