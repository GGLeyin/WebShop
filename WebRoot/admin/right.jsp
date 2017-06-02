<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>右侧</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" />
	<style type="text/css">
	   .main .text{
	        /*background-image:url(images/bg.png);*/
	        width:100%;
	        height:550px;
	        text-align:center;
	       /* border:1px solid red;*/
	   }
	   
	  .main .text{
	   		padding-top:180px;
	  }
	   
	   .main .text p{
	        font-size:32px;
	        margin-top:30px;
	        color:red;
	   }
	</style>
	</head>
	<body>
		<div class="m-right">
			<div class="right-nav">
			<ul>
			  <li><img src="${pageContext.request.contextPath }/admin/images/home.png"></li>
			  <li style="margin-left:5px;"><a href="${pageContext.request.contextPath }/admin/right.jsp">返回首页</a></li>
			  <li style="margin-left:25px;">您当前的位置：</li>
			  <li><span>主页面</span></li>
			</ul>
		 </div>
		 
		 <!--右边内容-->
		 <div class="main">
				<div class="text">
				    <p>欢迎进入<p>
				    <p>taobao后台管理平台</p>
				</div>
		 </div>
		</div>
		 
		
	</body>
</html>
