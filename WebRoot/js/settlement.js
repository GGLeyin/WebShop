function makesure(){
	var a=window.confirm("确定要取消吗?");
	if(a){
		window.location="../CartShowCtrl";
	}
}
function check(){
	var b=window.confirm("你确定要提交订单吗?");
	if(b){
		if($("#msg1").text()==""&&$("#msg2").text()==""){
			return true;
		}else{
			alert("格式不对");
			return false;
		}
	}else{
		return false;
	}
}
$(function(){
	var totalNum=0;
	$(".subtotal").each(function(){
		totalNum+=Number($(this).text());
	});
	$("#totalNum").text(totalNum);
	$("input[name='consignee']").change(function(){
		if(!$("input[name='consignee']").val().match(/^[\u4E00-\u9FA5]{1,6}$/)){
			$("#msg1").text("名字必须为四个以下汉字");
		}else{
			$("#msg1").text("");
		}
	});
	$("input[name='phone']").change(function(){
		if(!$("input[name='phone']").val().match(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/)){
			$("#msg2").text("手机必须为13位(13/15/18起)");
		}else{
			$("#msg2").text("");
		}
	});
});
