<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../style.css" rel="stylesheet" type="text/css" />
	<script src="../laydate/laydate.js"></script>
	<SCRIPT type="text/javascript" src="../js/jquery.js"></SCRIPT>
	<script src="../js/form.js"></script>
</head>

<body>
<form action="addWork.do" method="post" enctype="multipart/form-data">
    <div class="formbody">
    <div class="formtitle"><span>发布作业</span></div>
    <ul class="forminfo">
    <li><label>课 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程</label>
    班级：
    <select name="classid" id="class">
    	<option value="">请选择</option>
    	<s:iterator value="classes" var="cl">
    		<option value="${cl.id }"><s:property value="name"/></option>
    	</s:iterator>
    </select>
    课程：
    <select name="courseid" id="course">
    	<option value="">请选择</option>
    </select>
    </li>
    <li><label>作业名称</label><input name="workName" type="text" class="dfinput" /><i>名称不能超过50个字符</i></li>
 	<li><label>截止时间</label><input name="lasttime" placeholder="请输入日期" class="laydate-icon" onclick="laydate()"></li>
    <li><label>附 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件</label><input name="uploadfile" type="file"></input></li>
    <li><label>作业要求</label><textarea name="describe" cols="" rows="" class="textinput"></textarea></li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认提交"/></li>

    </ul>
    </div>
</form>
</body>
</html>
