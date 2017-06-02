package cn.edu.zhku.jsj.huangxin.user.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.user.service.UserExistException;
import cn.edu.zhku.jsj.huangxin.user.service.UserService;

public class RegisterCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserService us=new UserService();
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		try {
			us.register(user);
			user=us.login(username, password);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("./index.jsp");
		} catch (UserExistException e) {
			e.printStackTrace();
			response.getWriter().print("<script>alert('用户已存在')</script>");
			response.setHeader("Refresh", "1;url=register.jsp");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
