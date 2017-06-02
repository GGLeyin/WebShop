package cn.edu.zhku.linye.shop.Ctrl;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.linye.shop.Shop;
import cn.edu.zhku.linye.shop.Service.OpenService;

public class OpenCtrl extends HttpServlet {
	
	OpenService os = new OpenService();

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
		String username =  ((User)session.getAttribute("user")).getUsername();
		
		String shopName = request.getParameter("shopName");
		String description = request.getParameter("description");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String buildTime = df.format(new Date());
		
		Shop shop = new Shop();
		shop.setShopName(shopName);
		shop.setDescription(description);
		shop.setBuildTime(buildTime);
		shop.setUsername(username);
		
		boolean result = false ;
	
		try{
			
			result = os.addShop(shop);
			
			if(result == true){
				response.getWriter().print("<script>alert('С���Ѵ����ɹ�')</script>");
				session.setAttribute("user", os.getUser(username));
				response.sendRedirect("../SaleBack.jsp");
			}
		}catch(Exception e){
			response.getWriter().print("<script>alert('С���Ѵ���')</script>");
			response.setHeader("Refresh", "0;url=../FreeOpen.jsp");
			
		}
		
	}

	
	public void init() throws ServletException {
	
	}

}
