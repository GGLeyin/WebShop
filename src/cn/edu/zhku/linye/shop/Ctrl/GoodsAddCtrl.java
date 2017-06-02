package cn.edu.zhku.linye.shop.Ctrl;

import java.io.*;

import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.linye.shop.Goods;
import cn.edu.zhku.linye.shop.Service.GoodsService;



public class GoodsAddCtrl extends HttpServlet {

	GoodsService gs = new GoodsService();


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String shopName =  ((User)session.getAttribute("user")).getShopName();
System.out.println(shopName);
		Goods goods = new Goods();
		goods.setShopName(shopName);
		try{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(4194304);
			String uploadPath = this.getServletContext().getRealPath("/upload");
			File f = new File(uploadPath);
			if(!f.exists())
				f.mkdirs();
			List<FileItem> items = upload.parseRequest(request);
			
			for (int i = 0; i < items.size(); i++){
				FileItem item = items.get(i); 
				if(item.isFormField()){
					 if("goodsName".equals(item.getFieldName())){
						 String goodsName = item.getString("UTF-8");
						 goods.setGoodsName(goodsName);
					 }else if("type".equals(item.getFieldName())){
						 String type = item.getString("UTF-8");
						 goods.setType(type);
					}else if("price".equals(item.getFieldName())){
						 String price = item.getString("UTF-8");
						 goods.setPrice(price);
					}else {
						 String inventory = item.getString("UTF-8");
						 goods.setInventory(inventory);
					}
				}else{
				String uuid = UUID.randomUUID().toString().replace("-", ""); 
				String filename = item.getName();
				
				File toFile = new File(uploadPath+"/"+filename);
			
				
				int pot=toFile.getName().lastIndexOf(".");  
	            String ext="";
	              if(pot!=-1){  
	                  ext=toFile.getName().substring(pot);  
	              }else{  
	                  ext="";  
	              }  
	              String newName=uuid+ext;  
	              toFile=new File(toFile.getParent(),newName);
	              item.write(toFile);
	              goods.setImagePath("upload/"+newName);  
	             
	            }
			}

			boolean result = false ;
			String msg = null;
			result = gs.addGoods(goods);	
			if(result == true){
				msg = "商品添加成功";
			}else{
				msg = "商品添加失败";	
			}
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = request.getRequestDispatcher("/servlet/GoodsCheckCtrl");   //  “/”代表根目录
			rd.forward(request, response);
		}
		
	}
}

