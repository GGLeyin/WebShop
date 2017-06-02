package cn.edu.zhku.jsj.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.zhku.jsj.haofeng.bean.Shops;
import cn.edu.zhku.jsj.haofeng.service.AdminShopsService;
import cn.edu.zhku.jsj.haofeng.service.impl.AdminShopsServiceImpl;


public class AdminShopsAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			//定义pageSize每页的显示信息的条数
			private int pageSize=0;
			@Override
			public void init() throws ServletException {
				//定义init方法
				pageSize=Integer.parseInt(this.getInitParameter("pageSize"));
			}
		//调用业务层
	 	private AdminShopsService adminShopsService=new AdminShopsServiceImpl();
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doPost(request, response);
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			String action= request.getParameter("action");
			//查询所有
			if("all".equals(action)){
				String name = request.getParameter("name");
				List<Shops> shoplist=adminShopsService.getAll(name);
				request.setAttribute("shoplist", shoplist);
				
				//获取所有的值
				int pageNo=1;
				pageNo=request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo"));
				//总行数
				int rowCount=adminShopsService.RowCount();
		    	//	int pageCount=rowCount%pageSize==0?rowCount/pageSize:rowCount/pageSize+1;
				int pageCount=(rowCount+pageSize-1)/pageSize;
				List<Shops> goodslist=adminShopsService.getAll(pageSize,pageNo);
				
				//将获取的值保存在request范围内
				request.setAttribute("goodslist", goodslist);
				//将当前页保存在request范围内
				request.setAttribute("pageNo", pageNo);
				//将总页数保存在request范围内
				request.setAttribute("pageCount", pageCount);
				//跳转到显示页面
				request.getRequestDispatcher("/admin/shang_dian.jsp").forward(request, response);
			}
			
			//跳转到新增页面
			if("insertUI".equals(action)){
				String biaotype=request.getParameter("biaotype");
				request.setAttribute("biaotype", biaotype);
				request.getRequestDispatcher("/admin/shang_dian_add.jsp").forward(request, response);
			}
			
			//jinxing xinzeng caozuo 
			if("insert".equals(action)){
				
				
				String shopName = request.getParameter("shopName");
				String description = request.getParameter("description");
				String buildTime = request.getParameter("buildTime");
				String username = request.getParameter("username");
				
				int result =adminShopsService.insert(shopName, description, buildTime, username);
				if(result == 1){
					response.sendRedirect("AdminShopsAction?action=all");
				}
			}
			
			//跳转到修改页面
			if("updateUI".equals(action)){
				String shopName=request.getParameter("shopName");
				String biaotype=request.getParameter("biaotype");
				//根据id   判断类型
					Shops shop=adminShopsService.getShopName(shopName);
					//类型
					request.setAttribute("biaotype", biaotype);
					request.setAttribute("leixin", shop);
					
				request.getRequestDispatcher("/admin/shang_dian_edit.jsp").forward(request,response);
			}
			
			//进行修改操作
			if("update".equals(action)){
				
				String shopName = request.getParameter("shopName");
				String description = request.getParameter("description");
				String buildTime = request.getParameter("buildTime");
				String username = request.getParameter("username");
				int result =adminShopsService.update(shopName, description, buildTime, username);
				if(result == 1){
					response.sendRedirect("AdminShopsAction?action=all");
				}
			}
			
			//进行删除操作
			if("delete".equals(action)){
				String shopName=request.getParameter("shopName");
				int result=adminShopsService.deleteByShopName(shopName);
				if(result == 1){
					response.sendRedirect("AdminShopsAction?action=all");
				}
			}
			
		}

}
