package cn.edu.zhku.jsj.huangxin.user.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.user.service.UserService;

public class LoginCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserService service=new UserService();
		User user=service.login(username, password);;
		if(user!=null){
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return ;
		}
		request.setAttribute("msg", "用户名或密码错误");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
}
