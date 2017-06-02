package cn.edu.zhku.linye.shop.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.linye.shop.Service.OrderService;

public class OrderEditCtrl extends HttpServlet {

	OrderService os = new OrderService();
	
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
		String orderID = request.getParameter("orderID");
		
		try {
				os.editOrder(orderID);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			response.sendRedirect("OrderCheckCtrl");   // 相对于此文件的路径
			
		}
	}

}
