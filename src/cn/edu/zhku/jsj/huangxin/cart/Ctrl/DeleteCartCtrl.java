package cn.edu.zhku.jsj.huangxin.cart.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.cart.Service.CartService;

public class DeleteCartCtrl extends HttpServlet {

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

		String[] cartID=request.getParameterValues("cartID");
		int[] cartIDnew = new int[cartID.length];
		for(int i=0;i<cartID.length;i++){
			cartIDnew[i]=Integer.parseInt(cartID[i]);
		}
		CartService cs=new CartService();
		try {
			for(int i=0;i<cartIDnew.length;i++){
				cs.deleteCartItem(cartIDnew[i]);
			}
			response.sendRedirect("./CartShowCtrl");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("<script>alert('É¾³ý³ö´í')</script>");
			response.setHeader("Refresh", "1;url=./CartShowCtrl");
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
