$(function(){
   			$("#username").click(function(){
   				$("#message").text("");
   			});
   			$("#password").click(function(){
   				$("#message").text("");
   			});
   			$("#password2").click(function(){
   				$("#message").text("");
   			});
   		});

function check(){
	var username=$("#username").val();
	var password=$("#password").val();
	var password2=$("#password2").val();
	if(isNull(username) || isNull(password) || isNull(password2)){
		$("#message").text("请确保信息填写完整");
		return false;
	}else if(!(password === password2)){
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
