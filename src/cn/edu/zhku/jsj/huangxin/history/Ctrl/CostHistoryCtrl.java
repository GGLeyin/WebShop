package cn.edu.zhku.jsj.huangxin.history.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.history.Service.HistoryService;

public class CostHistoryCtrl extends HttpServlet {

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
		String amount=(Integer)request.getAttribute("amount")+"";
		//System.out.println(amount);
		String cartID=(String) request.getAttribute("cartID");
		HistoryService hs=new HistoryService();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date=df.format(new Date());
		try {
			hs.addHistory(user.getUsername(), date, "ฯ๛ทั", amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(cartID);
		request.setAttribute("cartID", cartID);
		request.setAttribute("money", amount);
		request.getRequestDispatcher("./ReduceMoneyCtrl").forward(request, response);
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
