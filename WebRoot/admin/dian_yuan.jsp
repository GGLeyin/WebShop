<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>管理员列表页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" />
		<script Language="JavaScript" src="${pageContext.request.contextPath }/admin/js/del_dianyuan.js"></script>
		<style type="text/css">
			table{
				margin-top:10px;
				margin-bottom:20px;
			}
		</style>
	</head>
	<body>
		<div class="m-right">
			<div class="right-nav">
			<ul>
			  <li><img src="${pageContext.request.contextPath }/admin/images/home.png"></li>
			  <li style="margin-left:5px;"><a href="${pageContext.request.contextPath }/admin/right.jsp">返回首页</a></li>
			  <li style="margin-left:5px;">您当前的位置：</li>
			  <li><span>管理员列表</span></li>
			</ul>
		 </div>
		 
		 <!--右边内容-->
		 <div class="main">
		 	<!--此处为模糊查询-->
				<form name="form1" action="${pageContext.request.contextPath }/AdminEmployeeAction?action=all" method="post">
					<p align="center">
						请输入姓名:<input type="text" name="name">
						<input type="submit" value="查询">
					</p>
				</form>
				
				<!--此处为显示所有信息-->
				<table border="1px" align="center" width="600px" cellspacing="0px" bgcolor="#f0f0f0" >
					<tr bgcolor="#7fdbf9">
						<td>id</td>
						<td>姓名</td>
						<td>密码</td>
						<td>年龄</td>
						<td>性别</td>
						<td>地址</td>
						<td>电话</td>
						<td>操作</td>
					</tr>
										
					<!--此处循环出数据库里的内容-->
					<c:forEach var="n" items="${adminslist}">
						<tr onMouseOver="this.style.backgroundColor='yellow'" onMouseOut="this.style.backgroundColor='' ">
							<td>${n.id}</td>
							<td>${n.adminName}</td>
							<td>${n.adminPwd}</td>
							<td>${n.adminAge}</td>
							<td>${n.adminGender}</td>
							<td>${n.adminAddress}</td>
							<td>${n.adminPhone}</td>
							<td>
								<a href="${pageContext.request.contextPath }/AdminEmployeeAction?action=updateUI&id=${n.id}">修改</a>&nbsp;&nbsp;
								<a href="javascript:del_dianyuan(${n.id})">删除</a>
							</td>
						</tr>
					</c:forEach>					
				</table>
				<!--新增-->
				<p align="center"><a href="${pageContext.request.contextPath }/AdminEmployeeAction?action=insertUI" target="_self">新增</a></p>
		 </div>
		</div>
		 
		
	</body>

</html>
