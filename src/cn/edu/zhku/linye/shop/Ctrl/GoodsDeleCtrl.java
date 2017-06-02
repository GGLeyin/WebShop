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

		//�趨��������ʽ
		request.setCharacterEncoding("utf-8");
		//�趨��������ʽ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String goodsID = request.getParameter("goodsID");
		
		try {
			gs.deleGoods(goodsID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = request.getRequestDispatcher("/servlet/GoodsCheckCtrl");   //  ��/�������Ŀ¼
			rd.forward(request, response);
		}
		
	}

}
