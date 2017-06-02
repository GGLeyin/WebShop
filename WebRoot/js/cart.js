$(function(){
	$("#deleteCart").click(function(){		//删除提示
		if(confirm("你确定要删除该商品")){
			return true;
		}else{
			return false;
		}
	});
	$("#allSelect").click(function(){		//全选
		if(this.checked){ 
		    $("input[name='cartID']").attr('checked', true);
		}else{ 
		    $("input[name='cartID']").attr('checked', false);
		} 
	});
	$("input[type='checkbox']").change(function(){	//统计已选商品数和其对应总价
		var i=0;
		var totalNum=0;
	    $("input[id='cartID']:checked").each(function(){
	    	i++;
	    	totalNum+=Number($(this).parent().siblings("#subtotal").text());
	    });
	    $("#selectedNum").text(i);
	    $("#totalNum").text(totalNum);
	});
	$("#alldelete").click(function(){				//删除所选
		var cartID =[];
		var i=0;
        $("input[name='cartID']:checked").each(function(){
        	cartID.push("cartID="+$(this).val()+"&"); 
        	i++;
        });
        if(i==0){
        	alert("你没有选择任何商品！");
        }else{
        	var cartIDnew=cartID.join("");
            var cartID=cartIDnew.substring(0,cartIDnew.length-1);
            var b=window.confirm("真的删除吗?");
        	if(b){
        		window.location="../DeleteCartCtrl?"+cartID;
        	} 
        }        
	});
	$("#settlement").click(function(){
		var i=0;
	    $("input[id='cartID']:checked").each(function(){
	    	i++;
	    });
	    if(i==0){
	    	alert("你没有选择任何商品！");
	    	return false;
	    }else{
	    	return ture;
	    }
	});
});
function changeQuantity(input,cartID,oldvalue){			//修改商品数量
		var quantity=input.value;
		if(isNaN(quantity)){
			alert("请输入数字");
			input.value=oldvalue;
			return;
		}
		if(quantity<0 || quantity!=parseInt(quantity)){
			alert("请输入正整数");
			input.value=oldvalue;
			return;
		}
		var rs=window.confirm("确定修改吗?");
		if(rs){
			window.location="../UpdateQuantityCtrl?cartID="+cartID+"&quantity="+quantity;
		} 
}