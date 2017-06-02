<%@ page language="java" import="java.util.*,cn.edu.zhku.linye.shop.Goods" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	//下面用于图片上传预览功能
	function imagePreview() {
		var docObj=document.getElementById("doc");
		var imgObjPreview=document.getElementById("preview");
		
		var pattern =/^.*\.(jpg|gif|png|bmp)$/i;      
	    if(!pattern.test(docObj.value)) { 
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
 	<%
		request.setCharacterEncoding("utf-8");
		List<Goods> list =(List<Goods>)request.getAttribute("list");
		if(list==null||list.size()<1){
			out.print("<tr><td align='center' colspan='10'>没有该商品信息，请添加！</td></tr>");
		}else{
			for(Goods goods:list){
	 %>
  	 <h2 align="center">商品修改</h2>
  
    <form action="servlet/GoodsEditCtrl"  method="post" enctype="multipart/form-data">
    	 <input type="hidden" name="goodsID" value="<%= goods.getGoodsID()%>"><br>
    	 <input type="hidden" name="imagePath" value="<%= goods.getImagePath()%>"><br>
    	<div align="center"> 
   		 <div id="localImag" >
			<img id="preview" src="<%=goods.getImagePath()%>" border="1" style="display: block; width: 170px; height: 170px;">
		</div>
		<input type="file"  name="file" id="doc" style="width:70px;" onchange="javascript:imagePreview();"><br>
    
	    <div align="center"> 
	  商品名称：<input type="text" name="goodsName" value="<%=goods.getGoodsName() %>" ><br>
	  商品类型：<select style="width:173px" name="type">
	    	<option><%=goods.getType() %></option>
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
	    
	   商品价格：<input type="text" name="price" value="<%=goods.getPrice() %>"><br>
	   商品库存：<input type="text" name="inventory" value="<%=goods.getInventory() %>"><br> 
	   
	    </div>
   		<div align="center"><input type="submit" value="确定修改"></div>

    </form> 
    <%
		    	}
		    }
		 %>
  </body>
</html>
