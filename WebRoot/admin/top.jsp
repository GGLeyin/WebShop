<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>头部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
		<script>
			setInterval("date.innerHTML=new Date().toLocaleString()+\' 星期\'+\'日一二三四五六\'.charAt(new Date().getDay());",1000);
		</script>
	</head>
	<body>
		<!--头部-->
		 <div id="header">
			<div class="logo"><img src="${pageContext.request.contextPath }/admin/images/logo.jpg"></div>
			<div class="top_center">后台管理平台</div>
			<div class="top_rigth">
				<ul>
				 	<li>欢迎您！</li>
					<li>${username}</li>
					<li id="date"></li>
				</ul>
			</div>
			<div id="clear"></div>
		 </div>
	</body>
</html>
