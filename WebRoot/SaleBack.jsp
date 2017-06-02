<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>卖家中心</title>
</head>

<frameset rows="112,*" cols="*" framespacing="0" frameborder="no" border="0">
  <frame src="header.html" noresize="noresize">
  <frameset rows="*"  cols="205,*" framespacing="0" border="0">
    <frame src="sidebar.html" noresize="noresize">
    <frame src="servlet/ShopInfoCtrl" noresize="noresize" name="in">
  </frameset>
</frameset>
<body>
</body>
</html>
