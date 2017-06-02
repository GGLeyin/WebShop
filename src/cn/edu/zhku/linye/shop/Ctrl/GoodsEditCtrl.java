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


import cn.edu.zhku.linye.shop.Goods;
import cn.edu.zhku.linye.shop.Service.GoodsService;



public class GoodsEditCtrl extends HttpServlet {

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
			Goods goods = new Goods();
			String imagePath = null;
			
			if(!ServletFileUpload.isMultipartContent(request)){
				int goodsID = Integer.parseInt(request.getParameter("goodsID"));
				goods.setGoodsID(goodsID);
				try {
					request.setAttribute("list", gs.getGoods(goods));				
					RequestDispatcher rd = request.getRequestDispatcher("/GoodsEdit.jsp");   //  “/”代表根目录
					rd.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
			
				try{
					DiskFileItemFactory factory = new DiskFileItemFactory();
					factory.setSizeThreshold(4096); //4KB
					ServletFileUpload upload = new ServletFileUpload(factory);
					upload.setFileSizeMax(4194304); //4MB
					String uploadPath = this.getServletContext().getRealPath("/upload");
					
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
							}else if("inventory".equals(item.getFieldName())){
								 String inventory = item.getString("UTF-8");
								 goods.setInventory(inventory);
							}else if("goodsID".equals(item.getFieldName())){
							int goodsID = Integer.parseInt(item.getString("UTF-8"));
System.out.println(goodsID);
								goods.setGoodsID(goodsID);
							}else{
								imagePath = item.getString("UTF-8");
							}
						}else{
							String uuid = UUID.randomUUID().toString().replace("-", ""); 
							String filename = item.getName();
System.out.println("f:"+filename);				
							if(!filename.equals("")){
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
					             
					        }else{
					        	goods.setImagePath(imagePath);
					        }
						}
					}
		
					boolean result = false ;
					String msg = null;
					result = gs.eidtGoods(goods);	
					if(result == true){
						msg = "商品修改成功";
					}else{
						msg = "商品修改失败";	
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
}

