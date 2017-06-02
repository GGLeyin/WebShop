/**
 * @author admin
 */


function del_shangping(id,obj) {
	var flag = window.confirm("是否删除");			
	if(flag){
		if(obj=="tuijian"){
			location.href="AdminGoodsAction?action=delete&id="+id;
		}
	}
}



function add_shangping(type){
//	alert(type);
	if(type=="tuijian"){
		location.href="AdminGoodsAction?action=insertUI&biaotype=tuijian";
	}
	
	if(type=="goods"){
		location.href="AdminGoodsAction?action=insertUI&biaotype=goods";
	}
}