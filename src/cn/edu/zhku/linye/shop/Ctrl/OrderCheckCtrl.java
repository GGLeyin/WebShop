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

public class OrderCheckCtrl extends HttpServlet {

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
		
		String temp = request.getParameter("orderID"); //��null�󡰡�
		if(temp==null||temp.equals("")){
			order.setOrderID(0);
		}else{
			order.setOrderID(Integer.parseInt(temp));
		}
		
		if(request.getParameter("state")!=null){
			String state = new String(request.getParameter("state").getBytes("iso8859-1"),"utf-8");//��null��ȫ�����ӵ�ʱ��ҲΪNULL
			order.setState(state);
System.out.println("state:"+state);	
		}
		order.setShopName(shopName);  //��Ҫ�޸�ΪshopName
		
		
System.out.println("ID:"+temp);
	

	
		try{	
			request.setAttribute("list", os.getOrder(order));
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = request.getRequestDispatcher("/OrderCheck.jsp");   //  ��/�������Ŀ¼
			rd.forward(request, response);
			
		}
		
	}

}
