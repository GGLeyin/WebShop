<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品</title>
 
	<script type="text/javascript">
	//下面用于图片上传预览功能
	function imagePreview() {
	
		var docObj=document.getElementById("doc");
		var imgObjPreview=document.getElementById("preview");
		
		var pattern =/^.*\.(jpg|gif|png|bmp)$/i;      
	    if(!pattern.test(docObj.value)) 
	    { 
	     alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");  
	     docObj.focus(); 
	    } 
		if(docObj.files &&docObj.files[0]){
		//火狐下，直接设img属性
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '170px';
		imgObjPreview.style.height = '170px'; 
		//imgObjPreview.src = docObj.files[0].getAsDataURL();
		
		//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		}
	}

</script>
  </head>
  
  <body>
   	<h3>商品添加 / Add Goods</h3>
    <hr align="left" width="95%" color="#d0d0d0" size="1">
 
    <form action="servlet/GoodsAddCtrl"  method="post" enctype="multipart/form-data">
    <div align="center"> 
    <div id="localImag" >
		<img id="preview" src="images/btn.png" border="1" style="display: block; width: 170px; height: 170px;">
	</div>
	<input type="file" name="file" id="doc" style="width:70px;" onchange="javascript:imagePreview();"><br>
		
    <input type="text" name="goodsName" placeholder="商品名称"><br>
  	<select style="width:173px" name="type">
    	<option>请选择商品类型</option>
    	<option value="蛋糕">蛋糕</option>
    	<option value="零食">零食</option>
    	<option value="坚果">坚果</option>
    	<option value="饮料">饮料</option>
    	<option value="牛奶">牛奶</option>
    	<option value="熟食">熟食</option>
    	<option value="糖果">糖果</option>
    	<option value="水果">水果</option>
    </select><br>
    
    <input type="text" name="price" placeholder="价格"><br>
    <input type="text" name="inventory" placeholder="库存"><br> 
    </div>
    <div align="center"><input type="submit" value="添加商品"></div>
    </form> 
  </body>
</html>
