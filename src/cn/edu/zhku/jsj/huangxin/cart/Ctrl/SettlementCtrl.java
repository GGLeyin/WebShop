package cn.edu.zhku.jsj.huangxin.cart.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SettlementCtrl extends HttpServlet {

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
		List<Map<String, Object>> cart=(List<Map<String, Object>>) request.getSession().getAttribute("cart");
		List<Map<String, Object>> pendingCart=new ArrayList<Map<String, Object>>();
		int[] cartIDnew = new int[cartID.length];
		for(int i=0;i<cartID.length;i++){
			cartIDnew[i]=Integer.parseInt(cartID[i]);
		}
		for(int j=0;j<cartIDnew.length;j++){
			for(Map<String, Object> m:cart){
				if((Integer)m.get("cartID")==cartIDnew[j]){
					pendingCart.add(m);
				}
			}
		}
		request.getSession().setAttribute("pendingCart",pendingCart);
		response.sendRedirect("./powerjsp/settlement.jsp");
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
