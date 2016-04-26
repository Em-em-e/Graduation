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


/**
 * 用户session过滤器, 判断用户是否登录, 见web.xml中配置
 */
public class SessionFilter implements Filter {
	
	/**
	 * 不包含的url
	 */
	protected String[] excludes = null;

	/**
	 * 过滤系统请求，如果用户未登录, 则转至登录页面
	 */
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		//设置请求参数编码
		request.setCharacterEncoding("UTF-8");
		//获取请求url
		String url = request.getServletPath();
		String contextPath = request.getContextPath();
		
		System.out.println(url);
		
		//是否需要验证用户, 过滤
		boolean isDoFilter = true;
		for (int i = 0; i < excludes.length; i++) {
			if (url.startsWith(excludes[i])) {
				isDoFilter = false;
				break;
			}
		}
		if (isDoFilter) {
			//要过滤url
			Object value = session.getAttribute("user");
			if (value == null) {
				//session中用户信息空, 进入登录页面
				response.sendRedirect(contextPath + "/login.jsp");
			}
		}
		chain.doFilter(request, response);
	}
	/**
	 * 过滤器销毁
	 */
	public void destroy() {
		this.excludes = null;
	}
	/**
	 * 初始化
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取不过滤的urls
		String urls = filterConfig.getInitParameter("excludes");
		this.excludes = urls.split(",");
	}
}
