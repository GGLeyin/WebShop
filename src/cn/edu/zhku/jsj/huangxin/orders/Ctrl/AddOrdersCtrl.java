package cn.edu.zhku.jsj.huangxin.orders.Ctrl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.orders.Service.OrdersService;

public class AddOrdersCtrl extends HttpServlet {

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

		User user=(User) request.getSession().getAttribute("user");;
		List<Map<String, Object>> pendingCart=(List<Map<String, Object>>) request.getSession().getAttribute("pendingCart");
		String consignee=request.getParameter("consignee");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String cartID="";
		int amount=0;
		for(Map<String, Object> map:pendingCart){
			//System.out.println(map.get("subtotal"));
			amount+=Integer.parseInt((String)map.get("subtotal"));
			cartID+="cartID="+map.get("cartID")+"&";
		}
		//System.out.println(user.getMoney());
		if(amount>Integer.parseInt(user.getMoney())){
			response.getWriter().print("<script>alert('ÓÃ»§Óà¶î²»×ã£¡')</script>");
			response.setHeader("Refresh", "1;url=./powerjsp/settlement.jsp");
		}else{
			OrdersService os=new OrdersService();
			try {
					os.addOrders(pendingCart, consignee, phone, address);
				} catch (Exception e) {
					e.printStackTrace();
				}
			cartID=cartID.substring(0, cartID.length()-1);
			//System.out.println("ad"+cartID);
			request.setAttribute("cartID", cartID);
			request.setAttribute("amount", amount);
			request.getRequestDispatcher("./CostHistoryCtrl").forward(request, response);
		}
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
