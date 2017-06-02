package cn.edu.zhku.linye.shop.Ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.linye.shop.Service.GoodsService;

public class GoodsDeleCtrl extends HttpServlet {

	GoodsService gs = new GoodsService();
	
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
		String goodsID = request.getParameter("goodsID");
		
		try {
			gs.deleGoods(goodsID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = request.getRequestDispatcher("/servlet/GoodsCheckCtrl");   //  “/”代表根目录
			rd.forward(request, response);
		}
		
	}

}
