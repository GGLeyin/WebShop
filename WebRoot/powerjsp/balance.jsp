<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>帐号余额</title>
    <link href="../style/person.css" rel="stylesheet" type="text/css" />
    <script src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/balance.js"> </script> 

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
               <form id="form1" name="form1" method="post" action="${pageContext.request.contextPath }/NameOSalesCtrl">
	    <input name="goodsNameInput" type="text" class="searchtext" required="required"/>
               <input name="" type="submit" class="searchbutton" value="搜索" />
               </form>
	  	</div>
  	</div>
 <div class="guidance" >
  	<div class="alltype">全部分类</div>
    <div class="homepage"><a href="../index.jsp">首页</a></div>
  </div>
  <div class="sidebar">
  		<h3>个人中心</h3>
  		<ul>
        	<li>
            	<p>个人资料</p>
            	<ul>
                	<li><a href="./person.jsp">个人信息</a></li>
                    <li><a href="./updatepw.jsp">密码修改</a></li>
                    <li><a href="./address.jsp">地址管理</a></li>
                </ul>
            </li>
            <li>
            	<p>我的订单</p>
            	<ul>
                	<li><a href="${pageContext.request.contextPath }/OrdersCtrl?state=待发货">待发货</a></li>
                    <li><a href="${pageContext.request.contextPath }/OrdersCtrl?state=待收货">已发货</a></li>
                    <li><a href="${pageContext.request.contextPath }/OrdersCtrl?state=已收货">已收货</a></li>
                </ul>
            </li>
            <li>
            	<p>我的资产</p>
            	<ul>
                	<li><a href="./balance.jsp">账户余额</a></li>
                    <li><a href="${pageContext.request.contextPath }/GetHistoryCtrl">账单明细</a></li>
                </ul>
            </li>         
        </ul>
  </div>
  <div class="main">
  	<h4>账户余额 / Account balance</h4>
  	<div class="balance">
    <h2>我的可用余额</h2>
    <h1>${user.money }.0</h1>
    <div><a id="recharge" href="#">充值</a></div>
    </div>    
  </div>
  </body>
</html>
