package cn.edu.zhku.jsj.haofeng.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.haofeng.bean.Admins;
import cn.edu.zhku.jsj.haofeng.service.AdminLoginService;
import cn.edu.zhku.jsj.haofeng.service.impl.AdminLoginServiceImpl;


public class AdminLoginAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//调用业务层
	private AdminLoginService adminLoginService=new AdminLoginServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//接受类型
		String loginAction = request.getParameter("action");
		String action = request.getParameter("Type");
		String updateaction=request.getParameter("updateaction");
		//介绍用户名
		String username=request.getParameter("Username");
		//接受密码
		String password=request.getParameter("Password");
		//定义session变量
		HttpSession session=request.getSession();
		//储存员工类型
		session.setAttribute("action", action);
	
			
	
		//查询管理员
		if("admins".equals(action)){
			Admins admins=adminLoginService.getAdmins(username,password);
			if(admins == null){
				request.setAttribute("baocuoxinxi", "登录失败，请重新输入！");
				request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			}else{
				session.setAttribute("username", username);
				session.setAttribute("password",password);
				session.setAttribute("boss", admins);
				request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
			}
		}
		
		//修改密码
		if("update".equals(updateaction)){
			int id=Integer.parseInt(request.getParameter("id"));
			String pwd=request.getParameter("new_pwd1");
			String leixing=request.getParameter("leixing");
			if("boss".equals(leixing)){
				int result =adminLoginService.updateB(pwd,id);
				if(result == 1){
					request.getRequestDispatcher("/admin/right.jsp").forward(request, response);
				}
			}
			if("admins".equals(leixing)){
				int result =adminLoginService.update(pwd,id);
				if(result == 1){
					request.getRequestDispatcher("/admin/right.jsp").forward(request, response);
				}
			}
			
			
		}
		
		if("exit".equals(loginAction)){
			session.removeAttribute("username");
			response.sendRedirect("./admin/login.jsp");
		}
	}

}
