package cn.edu.zhku.jsj.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.haofeng.bean.Admins;
import cn.edu.zhku.jsj.haofeng.service.AdminEmployeeService;
import cn.edu.zhku.jsj.haofeng.service.impl.AdminEmployeeServiceImpl;


public class AdminEmployeeAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//调用业务层
	private AdminEmployeeService adminEmployeeService =new AdminEmployeeServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action=request.getParameter("action");
		//查询全部
		if("all".equals(action)){
			//接受姓名
			String name=request.getParameter("name");
			List<Admins> adminslist=adminEmployeeService.getAll(name);
			request.setAttribute("adminslist", adminslist);
			//重定向
			request.getRequestDispatcher("/admin/dian_yuan.jsp").forward(request, response);
		}
		
		//跳转到新增页面
		if("insertUI".equals(action)){
			request.getRequestDispatcher("/admin/dian_yuan_add.jsp").forward(request, response);
		}
		
		//进行新增操作
		if("insert".equals(action)){
			String name=request.getParameter("name");
			String pwd=request.getParameter("pwd");
			int age=Integer.parseInt(request.getParameter("age"));
			String gender=request.getParameter("sex");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			int result =adminEmployeeService.insert(name,pwd,age,gender,address,phone);	
			if(result == 1){
				response.sendRedirect("AdminEmployeeAction?action=all");
			}
		}
		
		//跳转到修改页面
		if("updateUI".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			//根据id获取对象
			Admins admin=adminEmployeeService.getById(id);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("/admin/dian_yuan_edit.jsp").forward(request, response);
		}
		
		//进行修改操作
		if("update".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String gender=request.getParameter("sex");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			int result =adminEmployeeService.update(name,age,gender,address,phone,id);
			if(result == 1){
				response.sendRedirect("AdminEmployeeAction?action=all");
			}
		}
				
		//进行删除操作
		if("delete".equals(action)){
			int id=Integer.parseInt(request.getParameter("id"));
			int result=adminEmployeeService.deleteById(id);
			if(result == 1){
				HttpSession session=request.getSession();
				session.setAttribute("uesrname","");
				response.sendRedirect("AdminEmployeeAction?action=all");
			}
		}
	}

}
