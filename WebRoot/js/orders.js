$(function(){
	$("#confirmOrders").click(function(){
		if(confirm("你确定要进行该操作")){
			return true;
		}else{
			return false;
		}
	});
	$("#deleteOrders").click(function(){
		if(confirm("你确定要删除该订单")){
			return true;
		}else{
			return false;
		}
	});
});