<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" />
		<style type="text/css">
			table{
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
			  <li><span>用户管理</span></li>
			</ul>
		 </div>
		 
		 <!--右边内容-->
		 <div class="main">
		 <!--此处为模糊查询-->
		 		<form name="form1" action="${pageContext.request.contextPath }/AdminUsersAction?action=all" method="post">
					<p align="center">
						请输入要查找的用户名:<input type="text" name="name">
						<input type="submit" value="查询">
					</p>
				</form>	
				<!--此处为显示所有用户信息-->
				<table border="1px" align="center" width="600px" cellspacing="0px" bgcolor="#f0f0f0">
				    <caption>用户管理</caption>
					<tr bgcolor="#7fdbf9">
						<td>用户名</td>
						<td>密码</td>
						<td>金额</td>
						<td>收货人</td>
						<td>电话</td>
						<td>地址</td>
						<td>商店</td>
						<td>操作</td>
					</tr>
										
					<!--此处循环出数据库里的内容-->
					<c:forEach var="n" items="${userlist}">
						<tr onMouseOver="this.style.backgroundColor='yellow'" onMouseOut="this.style.backgroundColor='' ">
							<td>${n.username}</td>
							<td>${n.password}</td>
							<td>${n.money}</td>
							<td>${n.consignee}</td>
							<td>${n.phone}</td>
							<td>${n.address}</td>
							<td>${n.shopName}</td>
							<td>
								<a href="javascript:del_user('${n.username}')">删除</a>
							</td>
						</tr>
					</c:forEach>					
				</table>
				
			<p align="center">
			     当前${pageNo}页/总共${pageCount}页&nbsp;&nbsp;
			     	<a href="AdminUsersAction?action=all&pageNo=1">首页</a>&nbsp;&nbsp;
			     	<%--当前页大于一页的情况下 --%>
			     	<c:if test="${pageNo>1}">
			     		<a href="AdminUsersAction?action=all&pageNo=${pageNo-1 }">上一页</a>&nbsp;&nbsp;
			     	</c:if>
			     	<%-- 当前页小于总页数的情况下--%>
			     	<c:if test="${pageNo<pageCount}">
			     		<a href="AdminUsersAction?action=all&pageNo=${pageNo+1 }">下一页</a>&nbsp;&nbsp;
			     	</c:if>
			     	<a href="AdminUsersAction?action=all&pageNo=${pageCount}">末页</a>
			     	
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
<script type="text/javascript">
  	<%-- 实现跳转页数的改变 --%>
  	document.getElementById("pg").value=${pageNo};
  </script>
  	<script type="text/javascript">
			 function changePage(pageNo){
			 	location.href="AdminUsersAction?action=all&pageNo="+pageNo;
			 }
		</script>
		<script type="text/javascript"> 
			 function del_user(id) {
				var flag = window.confirm("是否删除");			
				
				if(flag){
					location.href="AdminUsersAction?action=delete&username="+id;
				}
			}
		</script>
</html>
