package cn.edu.zhku.jsj.haofeng.filter;//外层包名

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionFilter implements Filter//不带扩展名的文件名
{

	/**
	 * Constructor of the object.
	 */
	public PermissionFilter() {
		super();
	}
	
	private String login;
	private String images;


	// Handle the passed-in FilterConfig
	//需要初始化我在web。xml设定的初始化参数
	public void init(FilterConfig filterConfig) throws ServletException {
		this.login = filterConfig.getInitParameter("login");
		this.images = filterConfig.getInitParameter("images");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain)

	{
		try {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			HttpSession session = request.getSession();
			
			//这里放行名为login的jsp
			if (request.getServletPath().equals(images)) {
				filterChain.doFilter(request,response);
				return;
			}
			if (request.getServletPath().equals(login)||request.getServletPath().equals(images)) {
				filterChain.doFilter(request,response);
				return;
			}
			// 这里放到达目的地前(进入)处理代码
			String username = (String)session.getAttribute("username");
			if(username==null||"".equals(username)){
				response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			}
			filterChain.doFilter(request, response);

			// 这里放到达目的地(离开)的处理代码

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		// Just puts "destroy" string in log
		// Put your code here
	}

}

