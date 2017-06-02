<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>地址管理</title>
    <link href="../css/person.css" rel="stylesheet" type="text/css" />
    <script src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/address.js"></script>

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
                    <li><a href="${pageContext.request.contextPath }/OrdersCtrl?state=已发货">已发货</a></li>
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
	<h4>地址管理 / Address list</h4>
    <div class="content">
    <form action="${pageContext.request.contextPath }/AddressCtrl" method="post">
    	<table width="100%" height="300px">
          <tr>
            <td width="12%">收货人</td>
            <td width="70%"><input name="consignee" type="text" class="passwordinput" maxlength="24" value="${user.consignee }" required/></td>
            <td id="msg1" style="color:red;font-size: 15px"></td>
          </tr>
          <tr>
            <td>手机号码</td>
            <td><input name="phone" type="text" class="passwordinput" maxlength="24" value="${user.phone }"  required/></td>
            <td id="msg2" style="color:red;font-size: 15px"></td>
          </tr>
          <tr>
            <td>收货地址</td>
            <td><input name="address" type="text" class="passwordinput" value="${user.address }"  required/></td>
          </tr>
          <tr>
            <td colspan="2" height="36.4%"><input name="" type="submit" class="submitbutton" value="保存" onclick="return check();"/></td>
          </tr>
        </table>
    </form>
    </div>
  </div>
  </body>
</html>
