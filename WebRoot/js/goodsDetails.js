$(function(){
	$("#add").click(function(){
		if(Number($("#quantity").attr("value"))<Number($("#inventory").text())){
			$("#quantity").attr("value",Number($("#quantity").attr("value"))+1);
		}
	});
	$("#min").click(function(){
		if(Number($("#quantity").attr("value"))>1){
			$("#quantity").attr("value",Number($("#quantity").attr("value"))-1);
		}
	});
});