$(function(){
   			$("#shopName").click(function(){
   				$("#message").text("");
   			});
   			$("#description").click(function(){
   				$("#message").text("");
   			});
   			
   		});
function check2(){
	var username=$("#shopName").val();
	var password=$("#description").val();
	if(isNull(username) || isNull(password)){
		$("#message").text("请确保信息填写完整");
		return false;
	}
		return true;
}
function isNull(data){ 
	if(data == "" || data == undefined || data == null){
		return true;
	}else{
		return false;
	}
}
