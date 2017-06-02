<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页</title>
    <script src="./js/jquery.js"></script>
    <script type="text/javascript" src="js/main.js"> </script> 
    <link href="style/main.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  <div class="top">
	  <div>
	  	<c:if test="${user.username==null }">
	  		<div class="titleleft"><a href="login.jsp">亲，请登录</a><a href="register.jsp">免费注册</a><a href="admin/login.jsp" target="_blank">管理员入口</a></div>
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
  <div class="sidebar">
  		<ul>
            <li><a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=蛋糕">蛋糕</a></li>
            <li><a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=零食">零食</a></li>
            <li><a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=坚果">坚果</a></li>
            <li><a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=饮料">饮料</a></li>
            <li><a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=牛奶">牛奶</a></li>
            <li><a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=熟食">熟食</a></li>
  			<li><a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=糖果">糖果</a></li>
            <li><a href="${pageContext.request.contextPath }/TypeOSalesCtrl?type=水果">水果</a></li>
		</ul>
	</div>
	<div class="content">
        <div class="wrap">
                <ul class="pic" id="pic">
                    <li><a href="#"><img src="images/0.jpg" width="100%" height="400px" /></a></li>
                    <li><a href="#"><img src="images/1.jpg" width="100%" height="400px" /></a></li>
                    <li><a href="#"><img src="images/2.jpg" width="100%" height="400px" /></a></li>
                    <li><a href="#"><img src="images/3.jpg" width="100%" height="400px" /></a></li>
                </ul>
                <div class="next" id="next"><a href="#">></a></div>
        </div>	
	</div>
	<div class="information">
    <img src="images/man.png" width="85" height="80" />
    <c:if test="${user.username!=null }">
	    <div class="username">${user.username }</div>
	    <marquee>欢迎你的光临</marquee>
    </c:if>
    <c:if test="${user.username==null }">
    	<div class="username">请先登录！</div>
    </c:if>
    </div>
  </body>
</html>
