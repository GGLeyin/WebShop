package cn.edu.zhku.jsj.haofeng.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.haofeng.bean.Goods;
import cn.edu.zhku.jsj.haofeng.service.AdminGoodsService;
import cn.edu.zhku.jsj.haofeng.service.impl.AdminGoodsServiceImpl;


public class AdminGoodsAction extends HttpServlet {
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
 	private AdminGoodsService adminGoodsService=new AdminGoodsServiceImpl();
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
//			List<Tuijian> tuijianlist=adminGoodsService.getAll(name);
//			request.setAttribute("tuijianlist", tuijianlist);
			
			//获取所有的值
			int pageNo=1;
			pageNo=request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo"));
			//总行数
			int rowCount=adminGoodsService.RowCount();
	    	//	int pageCount=rowCount%pageSize==0?rowCount/pageSize:rowCount/pageSize+1;
			int pageCount=(rowCount+pageSize-1)/pageSize;
			List<Goods> goodslist=adminGoodsService.getAll(pageSize,pageNo);
			
			//将获取的值保存在request范围内
			request.setAttribute("goodslist", goodslist);
			//将当前页保存在request范围内
			request.setAttribute("pageNo", pageNo);
			//将总页数保存在request范围内
			request.setAttribute("pageCount", pageCount);
			//跳转到显示页面
			request.getRequestDispatcher("/admin/shang_ping.jsp").forward(request, response);
		}
		
		//跳转到新增页面
		if("insertUI".equals(action)){
			request.getRequestDispatcher("/admin/shang_ping_add.jsp").forward(request, response);
		}
		
		//jinxing xinzeng caozuo 
		if("insert".equals(action)){
			
			String goodsName=request.getParameter("goodsName");
			String price=request.getParameter("price");
			String shopName=request.getParameter("shopName");
			String inventory=request.getParameter("inventory");
			String sales=request.getParameter("sales");
			String imagePath=request.getParameter("imagePath");
			String type=request.getParameter("type");
			
			int result =adminGoodsService.insert(goodsName,price,shopName,inventory,
					sales,imagePath,type);
			if(result == 1){
				response.sendRedirect("AdminGoodsAction?action=all");
			}
		}
		
		//跳转到修改页面
		if("updateUI".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			//根据id   判断类型
			
				Goods good = adminGoodsService.getGoodsId(id);
				//类型
				request.setAttribute("leixin", good);
				
			request.getRequestDispatcher("/admin/shang_ping_edit.jsp").forward(request,response);
		}
		
		//进行修改操作
		if("update".equals(action)){

			
			String goodsName=request.getParameter("goodsName");
			String price=request.getParameter("price");
			String shopName=request.getParameter("shopName");
			String inventory=request.getParameter("inventory");
			String sales=request.getParameter("sales");
			String imagePath=request.getParameter("imagePath");
			String type=request.getParameter("type");
			int goodsID= Integer.parseInt(request.getParameter("goodsID"));
			int result =adminGoodsService.update(goodsName,price,shopName,inventory,
					sales,imagePath,type,goodsID);
			if(result == 1){
				response.sendRedirect("AdminGoodsAction?action=all");
			}
		}
		
		//进行删除操作
		if("delete".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			int result=adminGoodsService.deleteById(id);
			if(result == 1){
				response.sendRedirect("AdminGoodsAction?action=all");
			}
		}
		
	}

}
