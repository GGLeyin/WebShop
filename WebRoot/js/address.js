function check(){
	if($("#msg1").text()==""&&$("#msg2").text()==""){
		return true;
	}else{
		alert("格式不对");
		return false;
	}
}
$(function(){
	$("input[name='consignee']").change(function(){
		if(!$("input[name='consignee']").val().match(/^[\u4E00-\u9FA5]{1,6}$/)){
			$("#msg1").text("名字格式不对");
		}else{
			$("#msg1").text("");
		}
	});
	$("input[name='phone']").change(function(){
		if(!$("input[name='phone']").val().match(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/)){
			$("#msg2").text("手机号码格式不对");
		}else{
			$("#msg2").text("");
		}
	});
});