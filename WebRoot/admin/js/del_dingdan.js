function sendGoods(){
	var flag = window.confirm("是否确认已发货？一旦确认不可更改！");
	if(flag){
		document.getElementById("btn").value="已发货";
		document.getElementById('btn').disabled = true;
	}
}