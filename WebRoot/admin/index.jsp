<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>taobao后台管理平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	</head>
	<frameset rows="80px,*" rameborder="no" border="1" framespacing="0">
    <!--头部-->
    <frame src="${pageContext.request.contextPath }/admin/top.jsp" name="topframe" scrolling="no" noresize="noresize" frameborder="0"/>
    <!--主体部分-->
    <frameset cols="300px,*">
    	<!--主体左边-->
        <frame src="${pageContext.request.contextPath }/admin/left.jsp" name="leftframe" scrolling="no" noresize="noresize" frameborder="0"/>
		<!--主体右边-->
        <frame src="${pageContext.request.contextPath }/admin/right.jsp" name="rightframe" scrolling="yes" noresize="noresize" frameborder="0"/>
    </frameset> 
</frameset>
</html>
