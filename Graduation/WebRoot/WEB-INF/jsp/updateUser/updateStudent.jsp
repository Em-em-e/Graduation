<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
	<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="style.css" rel="stylesheet" type="text/css" />
	<script src="laydate/laydate.js"></script>
	<SCRIPT type="text/javascript" src="js/jquery.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="js/updateStudent.js"></SCRIPT>
</head>

<body>
    <div class="formbody">
    <div class="formtitle"><span>修改密码</span></div>
    
    <form action="" method="post" onsubmit="return cansubmit()">
    <ul class="forminfo">
    <li><label>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
   		 <input  type="text" class="dfinput" readonly="readonly" value="${stu.name }"/>
    </li>
    <li><label>用 &nbsp;户&nbsp; 名</label>
   		 <input  type="text" class="dfinput" readonly="readonly" value="${stu.username }"/>
    </li>
    <li><label>原始密码</label>
   		 <input  type="password" class="dfinput" id="password"/><i id="msg">请先验证旧密码</i>
    </li>
    <li id="subli"><label>&nbsp;</label><input type="button" class="btn" value="确认提交" id="submit"/></li>

    </ul>
    </form>
    </div>
</body>
</html>
