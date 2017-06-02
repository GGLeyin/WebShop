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


		//�趨��������ʽ
		request.setCharacterEncoding("utf-8");
		//�趨��������ʽ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String shopName =  ((User)session.getAttribute("user")).getShopName();

		Order order =new Order();
		
		String temp = request.getParameter("orderID"); 
		order.setOrderID(Integer.parseInt(temp));
System.out.println("temp:"+temp);
		
		order.setShopName(shopName);  //��Ҫ�޸�ΪshopName
		
		try{	
			request.setAttribute("list", os.getOrder(order));
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = request.getRequestDispatcher("/DetailOrder.jsp");   //  ��/�������Ŀ¼
			rd.forward(request, response);
		}
	}
}
