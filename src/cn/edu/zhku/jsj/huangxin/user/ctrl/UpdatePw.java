package cn.edu.zhku.jsj.huangxin.user.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.user.service.UserService;

public class UpdatePw extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user=(User) request.getSession().getAttribute("user");
		String password=request.getParameter("password");
		String passwordnew=request.getParameter("passwordnew");
		UserService us=new UserService();		
		if(!password.equals(user.getPassword())){
			response.getWriter().print("<script>alert('输入的密码有误！')</script>");
			response.setHeader("Refresh", "1;url=./powerjsp/updatepw.jsp");
		}else{
			try {
				us.updatepw(user.getUsername(),passwordnew);
				user.setPassword(passwordnew);
				request.getSession().setAttribute("user", user);
				response.getWriter().print("<script>alert('修改成功')</script>");
				response.setHeader("Refresh", "1;url=./powerjsp/updatepw.jsp");
			} catch (Exception e) {	
				e.printStackTrace();
				response.getWriter().print("<script>alert('系统出错')</script>");
				response.setHeader("Refresh", "1;url=./powerjsp/updatepw.jsp");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
