$(function(){
	$("#recharge").click(function(){
		var money=prompt("请输入你要充值的金额","");
		if(money==null){
			return;
		}if(isNaN(money)){
			alert("请输入数字");
			return;
		}
		if(money<0 || money!=parseInt(money)){
			alert("请输入正整数");
			return;
		}else{
			window.location="../UpdateMoneyCtrl?money="+money;
		}
		
	});
});