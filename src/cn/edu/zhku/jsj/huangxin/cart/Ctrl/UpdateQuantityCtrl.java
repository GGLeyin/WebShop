package cn.edu.zhku.jsj.huangxin.cart.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.cart.Service.CartService;

public class UpdateQuantityCtrl extends HttpServlet {

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
		
		CartService cs=new CartService();
		int cartID=Integer.parseInt(request.getParameter("cartID"));;
		String quantity=request.getParameter("quantity");
		List<Map<String,Object>> cart=(List<Map<String,Object>>) request.getSession().getAttribute("cart");
		Map<String, Object> map=null;
		for(Map<String, Object> m:cart){
			if((Integer)m.get("cartID")==cartID){
				map=m;
			}
		}
		if(Integer.parseInt(quantity)>Integer.parseInt((String)(map.get("inventory")))){
			response.getWriter().print("<script>alert('ÉÌÆ·¿â´æ²»×ã£¡')</script>");
			response.setHeader("Refresh", "1;url=./CartShowCtrl");
		}else{
			try {
				cs.updateQuentity((String)map.get("username"),(Integer)map.get("goodsID"), quantity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("./CartShowCtrl");
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
