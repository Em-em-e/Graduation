<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录作业管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
<script language="javascript">
	if (window != top)
		top.location.href = location.href;
</script>
</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  

<div class="logintop">    
    <span>欢迎登录作业管理界面平台</span>
    <ul>

    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">

        <span class="systemlogo"></span>
<div class="loginbox_">
        <div class="loginbox">
    
    <form action="index.do" method="post">
    	<div style="margin-left: 450px;margin-top: 60px;color: red">&nbsp;${errorMsg} </div>
    <ul>
        <br/>
    <li><input name="username" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
    <li><input name="password" type="password" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
        <li style="margin-bottom: 10px;">登陆角色：<select name="role">
            <option value ="1">学生</option>
            <option value ="2">教师</option>
            <option value="3">管理员</option>

        </select></li>
        <li><input name="code" type="text" class="yanzhengma" value="验证码" onclick="JavaScript:this.value=''"/>
            <img src="verifyCode.do" class="yanzhengma_code" onclick="this.src='verifyCode.do?a='+Math.random(100);">
        </li>
    <li><input name="" type="submit" class="loginbtn" value="登录"   />
    <label><input name="remenberPsw" type="checkbox" value="ok" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label><label><a href="#">学生注册</a></label></li>
    </ul>
    </form>
    
    </div></div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  2016  <a href="http://endtcy.github.io">endtcy.github.io</a>  湖北文理学院 数学与计算机科学学院</div>
<script language="javascript" >
$().ready(function(){
    		$.post("getCookie.do",function(data){
    			var s=data.split(",");
    			if(s[0]!=="null"){
    				$(".loginuser").attr("value",s[0]);
    			}
    			if(s[1]!=="null"){
    				$(".loginpwd").attr("value",s[1]);
    			}
    		},"text");
    	});
    </script>
</body>
</html>

