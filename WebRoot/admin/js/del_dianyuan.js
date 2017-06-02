/**
 * @author admin
 */

function del_shangdiand(idi){
	
	var flag = window.confirm("是否删除");
	if(flag){
		location.href='AdminEmployeeAction?action=delete&&id='+idi ;
	}
}
function del_dianyuan(idi){
	
	var flag = window.confirm("是否删除");
	if(flag){
		location.href='AdminEmployeeAction?action=delete&&id='+idi ;
	}
}

