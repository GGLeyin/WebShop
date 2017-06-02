package cn.edu.zhku.jsj.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.haofeng.bean.Orders;
import cn.edu.zhku.jsj.haofeng.service.AdminOrdersService;
import cn.edu.zhku.jsj.haofeng.service.impl.AdminOrdersServiceImpl;


public class AdminOrdersAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//调用业务层
	private AdminOrdersService  adminOrdersService=new AdminOrdersServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action= request.getParameter("action");
		//查询全部
		if("all".equals(action)){
			String name = request.getParameter("name");
			List<Orders> orderslist=adminOrdersService.getAll(name);
			request.setAttribute("orderslist", orderslist);
			request.getRequestDispatcher("/admin/ding_dan.jsp").forward(request, response);
			
		}
		
		//进行修改操作
		/*if("update".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			int ifDispose=Integer.parseInt(request.getParameter("ifdispose"));
			int result =adminOrdersService.updateById(ifDispose,id);
			if(result==1){
				response.sendRedirect("AdminOrdersAction?action=all");
			}
			
		}*/
	}

}
