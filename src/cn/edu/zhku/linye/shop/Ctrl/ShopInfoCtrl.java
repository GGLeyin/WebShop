package cn.edu.zhku.linye.shop.Ctrl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.linye.shop.Service.OpenService;
import cn.edu.zhku.linye.shop.Service.ShopInfoService;

public class ShopInfoCtrl extends HttpServlet {

	ShopInfoService sis = new ShopInfoService();
	OpenService os = new OpenService();
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
		
		HttpSession session = request.getSession();
		User user=  (User) session.getAttribute("user");
		String shopName = request.getParameter("shopName");
		String description = request.getParameter("description");
System.out.println(shopName+"shopname");
		try{	
			if(shopName==null)
				request.setAttribute("shop", sis.getShop(user.getUsername()));	
			else{
				request.setAttribute("shop", sis.getShop(shopName,description,user.getUsername()));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				session.setAttribute("user", os.getUser(user.getUsername()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ShopInfo.jsp");   //  “/”代表根目录
			rd.forward(request, response);
			
		}
	}

	
	public void init() throws ServletException {
		
	}

}
