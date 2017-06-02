<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品修改页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" />
		<style type="text/css">
			.main .add{
				width:500px;
				height:400px;
				/*border:1px solid #cfd1d2;*/
				padding-top:20px;
			}
			.main .add table tr td{
			    text-align:left;
			}
			
			.main .add table tr .letter{
			     text-align:right;
			}
			
			.main .add input{
				margin-top:10px;
				border:1px solid #c3c3c3;
                padding:1px 3px 6px 3px;
                border-radius:5px;
                margin-left:5px;
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
			  <li><span>修改商品</span></li>
			</ul>
		 </div>
		 
		 <!--修改前台商品-->
		 <div class="main">
				<div class="add">
					<form method="post" name="form1" action="${pageContext.request.contextPath }/AdminShopsAction?action=update"  onSubmit="return myCheck()">
						<table>
							<tr>
								<td clss="letter">商店名:</td>
								<td><input type="text" name="shopName" value="${leixin.shopName}"></td>
							</tr>
							
							<tr>
								<td clss="letter">描述:</td>
								<td><input type="text" name="description" value="${leixin.description}"></td>
							</tr>
							
							<tr>
								<td clss="letter">创建时间:</td>
								<td><input type="text"  name="buildTime" value="${leixin.buildTime}"></td>
							</tr>
							
							<tr>
								<td clss="letter">用户名:</td>
								<td><input type="text" name="username" value="${leixin.username}"></td>
							</tr>
							
							
						</table>
						<p align="center"><input type="submit" value="修改"></p>
				</form>
				</div>
				
		 </div>
		</div>
	</body>
	<script type="text/javascript">
		 function myCheck(){
         	for(var i=0;i<document.form1.elements.length-1;i++){
          		if(document.form1.elements[i].value==""){
           			alert("当前表单不能有空项");
           			document.form1.elements[i].focus();
           			return false;
          		}
        	 }
        			 return true;      
      		}
		</script>
</html>

