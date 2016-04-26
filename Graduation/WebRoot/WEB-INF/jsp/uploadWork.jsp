<%@ page language="java" import="java.util.*,com.endtcy.graduation.entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<link href="../css/style.css" rel="stylesheet" type="text/css">
	<link href="../style.css" rel="stylesheet" type="text/css" />
	<script src="../laydate/laydate.js"></script>
	<SCRIPT type="text/javascript" src="../js/jquery.js"></SCRIPT>
  </head>
  
  <body>
  
  <form action="uploadWork.do" method="post" enctype="multipart/form-data">
    <div class="formbody">
    <div class="formtitle"><span>上传作业</span><s:hidden name="wid"></s:hidden></div>
    <ul class="forminfo">
    <li><label>班 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级</label><input type="text" class="dfinput" readonly="readonly" value="${work.course.classes.name}"/></li>
    <li><label>课程名称</label><input type="text" class="dfinput" readonly="readonly" value="${work.course.name}"/></li>
    <li><label>作业名称</label><input type="text" class="dfinput" readonly="readonly" value="${work.name }"/></li>
    <li><label>作业文件</label><input name="uploadfile" type="file"></input></li>
    <li><label>作业说明</label><textarea name="describe" cols="" rows="" class="textinput"></textarea></li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认提交"/></li>

    </ul>
    </div>
</form>
  </body>
</html>
