<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>店员修改页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" />
		<style type="text/css">
			.main .add{
				width:400px;
				height:300px;
				border:1px solid #cfd1d2;
				padding-top:50px;
				text-align:center;
			}
			.main .add input{
				margin-top:10px;
				border:1px solid #c3c3c3;
                padding:1px 3px 6px 3px;
                border-radius:5px;
                margin-left:5px;
			}
		</style>
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
	</head>
	<body>
		<div class="m-right">
			<div class="right-nav">
			<ul>
			  <li><img src="${pageContext.request.contextPath }/admin/images/home.png"></li>
			  <li style="margin-left:5px;"><a href="${pageContext.request.contextPath }/admin/right.jsp">返回首页</a></li>
			  <li style="margin-left:5px;">您当前的位置：</li>
			  <li><span>修改店员资料</span></li>
			</ul>
		 </div>
		 
		 <!--修改店员资料-->
		 <div class="main">
				<div class="add">
					<form method="post" name="form1" action="${pageContext.request.contextPath }/AdminEmployeeAction?action=update" name="form1" onSubmit="return myCheck()">
						<input type="hidden" name="id" value="${admin.id}">
									
						姓名:<input type="text" name="name" value="${admin.adminName}"><br/>																
				
						年龄:<input type="text" name="age" value="${admin.adminAge}"><br/>
					<c:if test="${admin.adminGender=='男'}">
						性别:<input type="radio" value="男" name="sex" checked="checked">男&nbsp;
						<input type="radio" value="女" name="sex">女<br/>
			     	</c:if>
			     	<c:if test="${admin.adminGender=='女'}">
						性别:<input type="radio" value="男" name="sex">男&nbsp;
						<input type="radio" value="女" name="sex" checked="checked">女<br/>
			     	</c:if>
			     	
				                    地址:<input type="text" name="address" value="${admin.adminAddress}"><br/>
						
						电话:<input type="text" name="phone" value="${admin.adminPhone}"><br/>
						
						<p align="center"><input type="submit" value="修改"></p>
				</form>
				</div>
				
		 </div>
		</div>
	</body>

</html>
