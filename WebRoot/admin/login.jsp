<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<style type="text/css">
		#dakuang{
			width:619px;
			height:397px;
			background-image: url(images/login/login.jpg);
			margin:0 auto;		
		}
		
		#dakuang .login{
			width:300px;
			height:180px;
			/*border:1px solid red;*/
			float:left;
			margin-top:170px;
			margin-left:170px;			
		}
		
		#dakuang .login table tr .STYLE1{
			color:red;
			font-size: 12px;
		}
		
		#dakuang .login table tr .STYLE2{
		    color: #528311; 
			font-size: 12px;
		}
		
		#dakuang .login .text1{
			width:120px;
			height:18px;
			color: #42870a;
		}
	</style>	
  
   <script language="JavaScript">

        function mycheck() {
            if (isNull(form1.Type.value)) {
                alert("请选择身份！");
                return false;
            }
            if (isNull(form1.Username.value)) {
                alert("请输入用户名！");
                return false;
            }
            if (isNull(form1.Password.value)) {
                alert("请输入密码！");
                return false;
            }

        }

        function isNull(str) {
            if (str == "") return true;
            var regu = "^[ ]+$";
            var re = new RegExp(regu);
            return re.test(str);
        }

	</script>
</head>
<body>


<center>
	<div id="dakuang">
		<div class="login">
			<form name="form1" action="${pageContext.request.contextPath }/AdminLoginAction?action=Type " method="post" onSubmit="return mycheck()">
			<table width="350px" border="0" cellspacing="0" cellpadding="0">
	          	
		         <!-- 下拉列表 -->
		         <tr>
		             <td height="30" align="right" class="STYLE2">身 &nbsp;&nbsp;份：</td>
		             <td align="left">
			             <select name="Type" id="Type">
			               <option value="">请选择</option>
			               <option value="admins">管理员</option>
                <!-- 老板 boss   店员admins -->
	            	   </select>
		              </td>
		          </tr>
		          <!-- 用户名  name="Username" id="Username"-->
		           <tr>
		             <td width="37%" height="30" align="right" class="STYLE2">用户名：</td>
		             <td align="left">
		              	<input type="text" name="Username" id="Username" class="text1" />
		             </td>
		            </tr>
		                
		           <!-- 密码 name="Password" id="Password"  -->
		           <tr>
		              <td height="30" align="right" class="STYLE2">密 &nbsp;&nbsp;码：</td>
		              <td align="left">
		                <input type="password" name="Password" id="Password" class="text1" />
		              </td>
		            </tr>
		            <tr>
		               <td height="30" colspan="2" align="center">			             
			                 <input type="submit" name="button" id="button" value="登录">
		                </td>
		            </tr>
					
					<!-- 报错信息 -->
	             <tr>
		            <td height="30" colspan="2" align="center" class="STYLE1">
		                <span>
		                   ${baocuoxinxi}
		                </span>
		             </td>
		         </tr>
	         </table>
		</form>
	    <div>
	</div>




</body>

</html>
