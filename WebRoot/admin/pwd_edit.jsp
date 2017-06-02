<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户修改密码页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" />
		<style type="text/css">
			.main .add{
				width:500px;
				height:200px;
				border:1px solid #cfd1d2;
				padding-top:20px;
				font-size:12px;
				text-align:center;
			}
			.main .add input{
				margin-top:10px;
				border:1px solid #c3c3c3;
                padding:1px 3px 6px 3px;
                border-radius:5px;
                margin-left:5px;
            }

				
				
			}
			.main .add p{
				margin-top:10px;
			}
			
			.main .add p .submit{
			   width:50px;
			}
			
			#pwd_errop,#pwd1_errop,#pwd2_errop{
				font-size:12px;
				color:red;
			}
		</style>
		
		<script type="text/javascript">
			/*创建一个根据id来定位到一个元素的公共的方法*/
			function $(id){
				return document.getElementById(id);
			}
			
			/*验证原密码非空*/
		    function checkpwd() {
				var pwd = $("pwd").value;
				var obj=${password};
				if(pwd == "" || pwd.length==0) {
					$("pwd_errop").innerHTML = "密码不能为空" ;
					return false ;
				}
				/**/else{
					if(pwd != obj){
						$("pwd_errop").innerHTML = "密码与原密码不同" ;
						return false ;
					}else{
					$("pwd_errop").innerHTML ="" ;
						return true;
					}
				}
				$("pwd_errop").innerHTML ="" ;
				return true ;
			}
			/*验证新密码*/
			function checknew_pwd1(){
				var new_pwd1 = $("new_pwd1").value ;
				var pwd = $("pwd").value;
				
				if(new_pwd1 =="" || new_pwd1.length==0) {
					$("pwd1_errop").innerHTML = "新密码不能为空" ;
					return false ;
				} else {
					if(new_pwd1.length <6) {
						$("pwd1_errop").innerHTML = "密码长度不能小于6";
						return false ;
					}else{
						if(new_pwd1==pwd){
							$("pwd1_errop").innerHTML = "新密码不能与原密码相同";
							return false ;
						}
					}
				}
				$("pwd1_errop").innerHTML ="" ;
				return true ;
			}
			
			/*确认新密码*/
			function checknew_pwd2(){
				var new_pwd1 = $("new_pwd1").value ;
				var new_pwd2 = $("new_pwd2").value ;
			
				if(new_pwd2 =="" || new_pwd2.length==0) {
					$("pwd2_errop").innerHTML = "请确认新密码" ;
					return false ;
				} else {
					if(new_pwd1!=new_pwd2) {
						$("pwd2_errop").innerHTML = "两次输入的密码不一样";
						return false ;
					}
				}
				$("pwd2_errop").innerHTML ="" ;
				return true ;
			}
			
			/*验证这个表单*/
			function checkform() {			
				return checkpwd()&&checknew_pwd1()&&checknew_pwd2();
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
			  <li><span>修改密码</span></li>
			</ul>
		 </div>
		 
		 <!--修改密码-->
		 <div class="main">
				<div class="add">
					<form method="post" action="${pageContext.request.contextPath }/AdminLoginAction?updateaction=update" onsubmit="return checkform();">
						<input type="hidden" value="${boss.id}" name="id"/>
						<!-- 隐藏获取员工类型 -->
						<input type="hidden" value="${action }" name="leixing"/>
						请输入原密码:<input type="password" name="pwd" id="pwd" onblur="checkpwd()">
						<span id="pwd_errop"></span><br/>															
				
						请输入新密码:<input type="password" name="new_pwd1" id="new_pwd1" onblur="checknew_pwd1()"><span id="pwd1_errop"></span><br/>	
				        &nbsp; &nbsp;
				  	         确认新密码:<input type="password" name="new_pwd2" id="new_pwd2" onblur="checknew_pwd2()"><span id="pwd2_errop"></span><br/>	
						
						<p><input type="submit" value="修改"></p>
				   </form>
				</div>
				
		 </div>
		</div>
	</body>

</html>
