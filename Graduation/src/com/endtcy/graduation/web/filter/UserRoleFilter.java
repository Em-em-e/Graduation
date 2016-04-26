package com.endtcy.graduation.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.endtcy.graduation.entity.Manager;
import com.endtcy.graduation.entity.Student;
import com.endtcy.graduation.entity.Teacher;

/**
 * 用户权限过滤器 用于限制非法访问，不同角色的用户只能访问对应的action
 * 需要在web.xml里面userRoleFilter中配置各个角色允许访问的action
 * 
 * @author Administrator
 * 
 */
public class UserRoleFilter implements Filter {
	// 配置文件中获取到的Student允许访问的url
	private String[] stu = null;
	// 配置文件中获取到的Teacher允许访问的url
	private String[] tea = null;
	// 配置文件中获取到的Manager允许访问的url
	private String[] manage = null;
	/**
	 * 不包含的url
	 */
	protected String[] excludes = null;

	public void destroy() {
		this.stu = null;
		this.tea = null;
		this.manage = null;
		this.excludes=null;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		// 获取请求url
		String url = request.getServletPath();
		String contextPath = request.getContextPath();


		boolean isDoFilter = true;
		for (int i = 0; i < excludes.length; i++) {
			if (url.startsWith(excludes[i])) {
				isDoFilter = false;
				break;
			}
		}
		if (isDoFilter) {
			Object user = session.getAttribute("user");
			// 学生action权限验证
			if (user instanceof Student) {
				boolean flag = true;
				for (int i = 0; i < stu.length; i++) {
					if (url.startsWith(stu[i])) {
						flag = false;
						break;
					}
				}
				if (flag)
					response.sendRedirect(contextPath + "/error.html");
			}
			// 教师action权限验证
			if (user instanceof Teacher) {
				boolean flag = true;
				for (int i = 0; i < tea.length; i++) {
					if (url.startsWith(tea[i])) {
						flag = false;
						break;
					}
				}
				if (flag)
					response.sendRedirect(contextPath + "/error.html");
			}
			if (user instanceof Manager) {
				boolean flag = true;
				for (int i = 0; i < manage.length; i++) {
					if (url.startsWith(manage[i])) {
						flag = false;
						break;
					}
				}
				if (flag)
					response.sendRedirect(contextPath + "/error.html");
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		String Urls = arg0.getInitParameter("stu");
		this.stu = Urls.split(",");
		Urls = arg0.getInitParameter("tea");
		this.tea = Urls.split(",");
		Urls = arg0.getInitParameter("manage");
		this.manage = Urls.split(",");
		//获取不过滤的urls
		Urls = arg0.getInitParameter("excludes");
		this.excludes = Urls.split(",");
	}

}
