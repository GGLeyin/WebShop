package cn.edu.zhku.jsj.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.haofeng.bean.User_list;
import cn.edu.zhku.jsj.haofeng.service.AdminUsersService;
import cn.edu.zhku.jsj.haofeng.service.impl.AdminUsersServiceImpl;


public class AdminUsersAction extends HttpServlet {

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
		private AdminUsersService adminUsersService =new AdminUsersServiceImpl();
		
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		
		//查询所有用户
		if("all".equals(action)){
			//获取所有的值
			int pageNo=1;
			pageNo=request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo"));
			//总行数
			int rowCount=adminUsersService.RowCount();
	    	//	int pageCount=rowCount%pageSize==0?rowCount/pageSize:rowCount/pageSize+1;
			int pageCount=(rowCount+pageSize-1)/pageSize;
			String name = request.getParameter("name");
			List<User_list> userlist=adminUsersService.getAll(name,pageSize,pageNo);
			//将获取的值保存在request范围内
			request.setAttribute("userlist", userlist);
			//将当前页保存在request范围内
			request.setAttribute("pageNo", pageNo);
			//将总页数保存在request范围内
			request.setAttribute("pageCount", pageCount);
			//跳转到显示页面
			request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
		}
		
		//删除
		if("delete".equals(action)){
			String name=request.getParameter("username");
			System.out.println(name);
			int result =adminUsersService.delete(name);
			if(result == 1){
				response.sendRedirect("AdminUsersAction?action=all");
			}
		}
		
		
	}

}
