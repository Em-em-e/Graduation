package com.endtcy.graduation.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
/**
 * 继承该类的action可以直接获取session对象
 * @author Administrator
 *
 */
public class BaseAction implements SessionAware{
	private static final long serialVersionUID = 1L;

	//全局Session对象
	protected Map<String,Object> session;
	
	//获取请求和响应参数
	 ActionContext context = ActionContext.getContext();
	    protected HttpServletRequest request = (HttpServletRequest) context
	            .get(StrutsStatics.HTTP_REQUEST);
	    protected HttpServletResponse response = (HttpServletResponse) context
	            .get(StrutsStatics.HTTP_RESPONSE);
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
