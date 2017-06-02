package cn.edu.zhku.jsj.huangxin.user.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.user.service.UserService;

public class AddressCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		UserService us=new UserService();
		String phone=request.getParameter("phone");
		String consignee=request.getParameter("consignee");
		String address=request.getParameter("address");
		
		try {
			us.updatePhone(user.getUsername(), phone);
			us.updateConsignee(user.getUsername(), consignee);
			us.updateAddress(user.getUsername(), address);
			response.getWriter().print("<script>alert('保存成功')</script>");
			response.setHeader("Refresh", "1;url=./powerjsp/address.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("<script>alert('系统出错，无法保存')</script>");
			response.setHeader("Refresh", "1;url=./powerjsp/address.jsp");
		}	
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
