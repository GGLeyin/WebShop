package cn.edu.zhku.jsj.huangxin.goods.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.goods.Service.GoodsService;

public class TypeOSalesCtrl extends HttpServlet {

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

		String goodsType=request.getParameter("type");
		String page=request.getParameter("page");
		GoodsService gs=new GoodsService();
		PageBean pb=null;
		int curPage=1;
		if(page!=null&&page.length()>0){
			curPage=Integer.parseInt(page);
		}if(goodsType!=null&&goodsType.length()>0){
			goodsType=new String(goodsType.getBytes("iso8859-1"),"utf-8");
			//System.out.println(goodsType);
			pb=gs.getByTypeOSales(curPage, goodsType);
		}else{
			System.out.println("ÏµÍ³ÓÐÎó");
		}
		request.getSession().setAttribute("goodslist", pb);
		request.setAttribute("goodsName",null);
		request.setAttribute("goodsType",goodsType);
		request.setAttribute("option","sales");
		request.getRequestDispatcher("./search.jsp").forward(request, response);
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
