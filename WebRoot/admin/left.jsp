<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>左侧</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
		<script type="text/javascript">
        function exit() {
            if(window.confirm("您确定要退出吗？")) {
               window.top.location.href = "${pageContext.request.contextPath }/AdminLoginAction?action=exit";
            }
        }       
    </script>
	</head>
	<body>
	
		<div class="left_menu">
	    	
       			
       			  
       			
	   			<h1>选项</h1>
		        
		        <div><a href="${pageContext.request.contextPath }/AdminEmployeeAction?action=all" target="rightframe"><b>管理员列表</b></a></div>     
		        
				
		        <div><a href="${pageContext.request.contextPath }/AdminShopsAction?action=all" target="rightframe"><b>店铺管理</b></a></div> 
				
		        <div><a href="${pageContext.request.contextPath }/AdminGoodsAction?action=all" target="rightframe"><b>商品管理</b></a></div>         
		        
				 
		        <div><a href="${pageContext.request.contextPath }/AdminOrdersAction?action=all" target="rightframe"><b>订单管理</b></a></div>       
		        
				
				
		        <div><a href="${pageContext.request.contextPath }/AdminUsersAction?action=all" target="rightframe"><b>用户管理</b></a></div>   
		        
				
				
				 
		          <div><a href="${pageContext.request.contextPath }/admin/pwd_edit.jsp" target="rightframe"><b>修改密码</b></a></div>          
		        
				
				
				 
		          <div><a href="#"  onclick="exit();"><b>退出系统</b></a></div>      
		        
     		
	  	</div>
	
</body>

</html>
