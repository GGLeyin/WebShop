/**
 * @author admin
 */
function test(id){
	var flag = window.confirm("是否删除");
}

function add_shangdian(){
//	alert(type);
	
		location.href="AdminShopsAction?action=insertUI&biaotype=shops";
}

function del_dianyuan(idi){
	var flag = window.confirm("是否删除");
	if(flag){
		location.href='AdminShopsAction?action=delete&&shopName='+idi ;
	}
}