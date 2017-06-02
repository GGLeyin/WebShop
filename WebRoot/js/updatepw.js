$(function(){
   			$("#password").click(function(){
   				$("#message").text("");
   			});
   			$("#passwordnew").click(function(){
   				$("#message").text("");
   			});
   			$("#passwordnew2").click(function(){
   				$("#message").text("");
   			});
   		});
function check(){
	var password=$("#password").val();
	var passwordnew=$("#passwordnew").val();
	var passwordnew2=$("#passwordnew2").val();
	if(isNull(password) || isNull(passwordnew) || isNull(passwordnew2)){
		$("#message").text("请确保信息填写完整");
		return false;
	}else if(!(passwordnew === passwordnew2)){
		$("#message").text("两次的密码不一致");
		return false;
	}else{
		return true;
	}
	
}
function isNull(data){ 
	if(data == "" || data == undefined || data == null){
		return true;
	}else{
		return false;
	}
}