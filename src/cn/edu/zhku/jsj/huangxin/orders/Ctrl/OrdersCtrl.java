package cn.edu.zhku.jsj.huangxin.orders.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.orders.Service.OrdersService;

public class OrdersCtrl extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user=(User) request.getSession().getAttribute("user");
		String state=request.getParameter("state");
		if(state==""||state==null){
			state=(String) request.getAttribute("state");
		}
		String page=request.getParameter("page");
		if(state.equals(new String(state.getBytes("iso8859-1"), "iso8859-1"))){
			state=new String(state.getBytes("iso8859-1"),"utf-8");
		}
		int curPage=1;
		if(page!=null&&page.length()>0){
			curPage=Integer.parseInt(page);
		}
		OrdersService os=new OrdersService();
		PageBean pb=os.getOrdersByUser(curPage,user.getUsername(),state);
		request.getSession().setAttribute("pageBean", pb);
		response.sendRedirect("powerjsp/orders.jsp");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
