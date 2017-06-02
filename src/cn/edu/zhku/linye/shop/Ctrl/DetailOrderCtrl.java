package cn.edu.zhku.linye.shop.Ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.linye.shop.Order;
import cn.edu.zhku.linye.shop.Service.OrderService;

public class DetailOrderCtrl extends HttpServlet {

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
		
		HttpSession session = request.getSession();
		String shopName =  ((User)session.getAttribute("user")).getShopName();

		Order order =new Order();
		
		String temp = request.getParameter("orderID"); 
		order.setOrderID(Integer.parseInt(temp));
System.out.println("temp:"+temp);
		
		order.setShopName(shopName);  //需要修改为shopName
		
		try{	
			request.setAttribute("list", os.getOrder(order));
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = request.getRequestDispatcher("/DetailOrder.jsp");   //  “/”代表根目录
			rd.forward(request, response);
		}
	}
}
