package com.endtcy.graduation.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import com.endtcy.graduation.base.BaseAction;
import com.endtcy.graduation.entity.Manager;
import com.endtcy.graduation.entity.Student;
import com.endtcy.graduation.entity.Teacher;
import com.endtcy.graduation.service.LoginService;
import com.endtcy.graduation.util.DesUtils;

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	/**登陆用户名*/
	private String username;
	/**登陆密码*/
	private String password;
	/**用户输入的验证码*/
	private String code;
	/**登陆角色*/
	private int role;
	/**错误提示信息*/
	private String errorMsg;
	/**是否记住密码*/
	private String remenberPsw;

	@Resource
	private LoginService loginService;
	
	/**
	 * 通过ajax获取解密后的cookie数据
	 * @throws IOException 
	 */
	public void findCookie() throws IOException{
		String uName=null;
		String psw=null;
		try {
			DesUtils des = new DesUtils("lalala");
			Cookie[] co = request.getCookies();
			if (co != null)
				for (int i = 0; i < co.length; i++) {
					if (co[i].getName().equals("username")) {
						uName = des.decrypt(co[i].getValue());
					}
					if (co[i].getName().equals("password")) {
						des=new DesUtils("lololo");
						psw = des.decrypt(co[i].getValue());
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			PrintWriter out=response.getWriter();
			out.write(uName+","+psw);
	}

	/**用户登陆action*/
	public String login() throws IOException {
		String validateCode = (String) session.get("validateCode");
		if (validateCode == null || validateCode == "") {
			return "fail";
		}
		if (!validateCode.equalsIgnoreCase(code)) {
			errorMsg = "验证码错误！！";
			return "fail";
		}
		//查询用户信息
		Object st =  loginService.findByUnameAndPsw(username, password, role);
		if (st != null) {
			//将用户信息转换后存在Session中，避免之后的用户角色判断出错
			if(role==1)st=(Student)st;
			if(role==2)st=(Teacher)st;
			if(role==3)st=(Manager)st;
			session.put("user", st);
			/**将用户名密码加密后存在客户端cookie上*/
			if (remenberPsw != null){
				if (remenberPsw.equals("ok")) {
					String uName=null;
					String psw=null;
					try {
						DesUtils des = new DesUtils("lalala");
						uName = des.encrypt(username);
						des=new DesUtils("lololo");
						psw = des.encrypt(password);
						System.out.println("加密后："+uName+"  "+psw);
					} catch (Exception e) {
						e.printStackTrace();
					}
					Cookie uNameCookie = new Cookie("username", uName);
					Cookie pwdCookie = new Cookie("password", psw);
					uNameCookie.setPath(request.getContextPath());
					pwdCookie.setPath(request.getContextPath());
					pwdCookie.setMaxAge(10000000);
					uNameCookie.setMaxAge(10000000);
					response.addCookie(uNameCookie);
					response.addCookie(pwdCookie);
				}
			}else{//删除cookie
				Cookie u=new Cookie("username","");
				Cookie p=new Cookie("password","");
				u.setPath(request.getContextPath());p.setPath(request.getContextPath());
				u.setMaxAge(0);p.setMaxAge(0);
				response.addCookie(u);response.addCookie(p);
			}
			/**跳转页面控制*/
			if(role==1){
				return "student";
			}else if(role==2){
				return "teacher";
			}else 
				return "manager";
			
		} else {
			errorMsg = "用户名或密码错误！";
			return "fail";
		}
	}
	/**
	 * 退出登录action
	 * @return
	 * @throws IOException 
	 */
	public void loginOut() throws IOException{
		session.remove("user");
		System.out.println(session.get("user"));
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getRemenberPsw() {
		return remenberPsw;
	}

	public void setRemenberPsw(String remenberPsw) {
		this.remenberPsw = remenberPsw;
	}

	

	

	
}
