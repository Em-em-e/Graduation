<%@ page language="java" import="java.util.*,com.endtcy.graduation.entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	Object user=session.getAttribute("user");
	String url="";
	if(user instanceof Teacher){
		url="teacher/teacherMain";
	}
	if(user instanceof Student){
		url="student/student";
	}
 %>
<html>
  <head>
  	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript">
		
	</script>
  </head>
  
  <body>
	<h1>密码修改成功！！请记住新密码。</h1><a href="<%=url%>.do">返回主页</a>
  </body>
</html>
