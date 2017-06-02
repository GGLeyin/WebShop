function edit_shangping(id,type){
	//alert(id+":::"+type);
	if(type=="tuijian"){
		location.href="AdminGoodsAction?action=updateUI&id="+id;
	}

}