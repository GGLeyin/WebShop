function add_shangdian(){
//	alert(type);
	
		location.href="AdminShopsAction?action=insertUI&biaotype=shops";
}


function del_shangdian2(idi){
	var flag = window.confirm("是否删除");
	if(flag){
		location.href='AdminShopsAction?action=delete&&shopName='+idi ;
	}
}