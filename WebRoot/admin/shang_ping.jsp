<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
     <title>商品管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" />
		<script Language="JavaScript" src="${pageContext.request.contextPath }/admin/js/del_shangping.js"></script>
		<script Language="JavaScript" src="${pageContext.request.contextPath }/admin/js/del_shangping2.js"></script>
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
			  <li><span>商品管理</span></li>
			</ul>
		 </div>
		 
		 <!--右边内容-->
		 <div class="main">	
		 	<!--此处为模糊查询-->
		 		<form name="form1" action="${pageContext.request.contextPath }/AdminGoodsAction?action=all" method="post">
					<p align="center">
						请输入商品名:<input type="text" name="name">
						<input type="submit" value="查询">
					</p>
				</form>			
				<!--此处为显示所有信息-->
				<table border="1px" align="center" width="600px" cellspacing="0px" bgcolor="#f0f0f0">
					<caption>商品列表</caption>
					<tr bgcolor="#7fdbf9">
						<td>id</td>
						<td>商品名</td>
						<td>价格</td>
						<td>商店名</td>
						<td>货存</td>
						<td>销量</td>
						<td>图片展示</td>
						<td>类型</td>
						<td>操作</td>
					</tr>
										
					<!--此处循环出数据库里的内容-->
					<c:forEach var="t" items="${goodslist}">
						<tr onMouseOver="this.style.backgroundColor='yellow'" onMouseOut="this.style.backgroundColor='' ">
							<td>${t.goodsID}</td>
							<td>${t.goodsName}</td>
							<td>${t.price}</td>
							<td>${t.shopName}</td>
							<td>${t.inventory}</td>
							<td>${t.sales}</td>
							<td>${t.imagePath}</td>
							<td>${t.type}</td>
							<td>
								<a href="javascript:edit_shangping(${t.goodsID},'tuijian')" target="_self">修改</a>&nbsp;&nbsp;
								<a href="javascript:del_shangping(${t.goodsID},'tuijian')">删除</a>
							</td>
						</tr>
					</c:forEach>					
				</table>
				<!--新增-->
				
				<!-- <p align="center"><a href="${pageContext.request.contextPath }/admin/tui_jian_add.jsp" target="_self">新增</a></p> -->
				<hr/>
				
				
				<p align="center">
			     当前${pageNo}页/总共${pageCount}页&nbsp;&nbsp;
			     	<a href="AdminGoodsAction?action=all&pageNo=1">首页</a>&nbsp;&nbsp;
			     	<%--当前页大于一页的情况下 --%>
			     	<c:if test="${pageNo>1}">
			     		<a href="AdminGoodsAction?action=all&pageNo=${pageNo-1 }">上一页</a>&nbsp;&nbsp;
			     	</c:if>
			     	<%-- 当前页小于总页数的情况下--%>
			     	<c:if test="${pageNo<pageCount}">
			     		<a href="AdminGoodsAction?action=all&pageNo=${pageNo+1 }">下一页</a>&nbsp;&nbsp;
			     	</c:if>
			     	<a href="AdminGoodsAction?action=all&pageNo=${pageCount}">末页</a>
			     	
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
