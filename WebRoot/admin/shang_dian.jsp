<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
     <title>商店管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" />
		<script Language="JavaScript" src="${pageContext.request.contextPath }/admin/js/del_add_shangdian.js"></script>
		<script Language="JavaScript" src="${pageContext.request.contextPath }/admin/js/del_shangdian2.js"></script>
		
		<style type="text/css">
			table{
				margin-top:10px;
			}
			
			.main p{
				margin-top:10px;
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
			  <li><span>商店管理</span></li>
			</ul>
		 </div>
		 
		 <!--右边内容-->
		 <div class="main">	
		 	<!--此处为模糊查询-->
		 		<form name="form1" action="${pageContext.request.contextPath }/AdminShopsAction?action=all" method="post">
					<p align="center">
						请输入商店名:<input type="text" name="name">
						<input type="submit" value="查询">
					</p>
				</form>			
				<!--此处为显示所有信息-->
				<table border="1px" align="center" width="600px" cellspacing="0px" bgcolor="#f0f0f0">
					<caption>商家店铺</caption>
					<tr bgcolor="#7fdbf9">
						<td>商店名</td>
						<td>描述</td>
						<td>创建时间</td>
						<td>用户名</td>
						<td>操作</td>
					</tr>
										
					<!--此处循环出数据库里的内容-->
					<c:forEach var="s" items="${shoplist}">
						<tr onMouseOver="this.style.backgroundColor='yellow'" onMouseOut="this.style.backgroundColor='' ">
							<td>${s.shopName}</td>
							<td>${s.description}</td>
							<td>${s.buildTime}</td>
							<td>${s.username}</td>
							<td>
								<a href="${pageContext.request.contextPath }/AdminShopsAction?action=updateUI&shopName=${s.shopName}" target="_self">修改</a>&nbsp;&nbsp;
								<a href="javascript:del_shangdian2('${s.shopName}')">删除</a>
							</td>
						</tr>
					</c:forEach>					
				</table>
				<!--新增-->
				<p align="center"><a href="${pageContext.request.contextPath }/AdminShopsAction?action=insertUI&shopName=${s.shopName}" target="_self" target="_self">新增</a></p>
				<!-- <p align="center"><a href="${pageContext.request.contextPath }/admin/tui_jian_add.jsp" target="_self">新增</a></p> -->
				<hr/>
					
				<p align="center">
			     当前${pageNo}页/总共${pageCount}页&nbsp;&nbsp;
			     	<a href="AdminShopsAction?action=all&pageNo=1">首页</a>&nbsp;&nbsp;
			     	<%--当前页大于一页的情况下 --%>
			     	<c:if test="${pageNo>1}">
			     		<a href="AdminShopsAction?action=all&pageNo=${pageNo-1 }">上一页</a>&nbsp;&nbsp;
			     	</c:if>
			     	<%-- 当前页小于总页数的情况下--%>
			     	<c:if test="${pageNo<pageCount}">
			     		<a href="AdminShopsAction?action=all&pageNo=${pageNo+1 }">下一页</a>&nbsp;&nbsp;
			     	</c:if>
			     	<a href="AdminShopsAction?action=all&pageNo=${pageCount}">末页</a>
			     	
			       跳转
			   <select id="pg" onchange="changePage(this.value)" >
			  		<c:forEach var="p" begin="1" end="${pageCount}">
			   			<option value="${p}">${p}</option>
			  		</c:forEach>
			   </select>    
			       页
			</p>
				
		 </div>
		</div>
	</body>

</html>
