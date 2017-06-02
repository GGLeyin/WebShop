<%@ page language="java" import="java.util.*,cn.edu.zhku.linye.shop.Goods" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品查询</title>

  </head>
  
  	<style type="text/css">
  		th{width:100px;}
  	</style>
	  	
  <body>
  <h3>商品查询/ Check Goods</h3>
    <hr align="left" width="95%" color="#d0d0d0" size="1">
    
  	<form  method="post" action="servlet/GoodsCheckCtrl">
  
   		<table align="center"  border="1" cellspacing="0" >
		<tr height="50">
			<th align="right"  colspan="10" >
			商品名称：<input type="text" name="goodsName" /><input type="submit" value="查询"  />
			</th>
		</tr>
		
		<tr style="background:#ccc" align="center" >
			<th>商品图片</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>类型</th>
			<th>价格(元)</th>
			<th>库存</th>
			<th>销量</th>
			<th colspan="6">操作</th>
		</tr>
		<%
			request.setCharacterEncoding("utf-8");
			List<Goods> list =(List<Goods>)request.getAttribute("list");
			if(list==null||list.size()<1){
				out.print("<tr><td align='center' colspan='10'>没有该商品信息，请添加！</td></tr>");
			}else{
				for(Goods goods:list){
					pageContext.setAttribute("goods",goods);
		 %>
		
		<tr  align="center">
			<td><img src="${goods.imagePath}" width="100px" height="100px"></td>
			<td>${goods.goodsID }</td>
			<td>${goods.goodsName }</td>
			<td>${goods.type }</td>
			<td>￥${goods.price*1.0 }</td>
			<td>${goods.inventory}</td>
			<td>${goods.sales}</td>
			<td colspan="4" >
			<a href="servlet/GoodsEditCtrl?goodsID=${goods.goodsID}" >修改</a>
			<a href="javascript:if(confirm('是否删除该商品信息？')) location.href='servlet/GoodsDeleCtrl?goodsID=${goods.goodsID}'" >删除</a>
			</td>
		</tr>
		<%
		    	}
		    }
		 %>
		</table>
   	</form>
  </body>
</html>
