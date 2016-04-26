<%@ page language="java" import="java.util.*,com.endtcy.graduation.entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js/select-ui.min.js"></script>
<script type="text/javascript" src="../editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
<script type="text/javascript">
$(document).ready(function(e) {

	$(".select3").uedSelect({
		width : 152
	});
});
</script>
</head>
<body class="sarchbody">
    <div class="formbody">
    <div id="usual1" class="usual"> 
    <ul class="seachform1">
    
    <li><label>项目名称</label><input name="" type="text" class="scinput1" /></li>
    <li><label>学校名称</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>项目状态</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>    

    
    </ul>
    
    <ul class="seachform2">
    
    <li><label>项目编号</label><input name="" type="text" class="scinput1" /></li>
    <li><label>项目类型</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>项目领域</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    </ul>
    
    <ul class="seachform1">
    <li class="sarchbtn"><label>&nbsp;</label>
    	<input name="" type="button" class="scbtn" value="查询"/>   
    	<input name="" type="button" class="scbtn1" value="更多条件"/>   
    	<input name="" type="button" class="scbtn2" value="导出"/>
    </li>  
    </ul>
    
    <script language="javascript">
	$(document).ready(function() 
{ 
    $(".scbtn1").click(function() 
    {      
        if( $(".seachform2").hasClass("hideclass") ) 
        { 
            $(".seachform2").removeClass("hideClass"); 
        } 
        else 
        { 
            $(".seachform2").addClass("hideClass"); 
        }    
    }); 
}); 
</script>
    <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 
});
</script>
    
    <div class="formtitle"><span>学生作业列表</span></div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
        <th>学生姓名</th>
        <th>学号</th>
        <th>上交时间</th>
        <th>作业描述</th>
        <th>是否审核</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        
      <s:iterator value="studentworks" var="sw" status="s">
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td><s:property value="#s.getCount()"/></td>
        <td>${student.name}</td>
        <td>${student.studentid}</td>
        <td>${uploadtime}</td>
        <td>${describe}</td>
        <td>已审核</td>
        <td><a href="" class="tablelink">查看</a>     <a href="#" class="tablelink"> 删除</a></td>
        </tr> 
       </s:iterator>
        
        
    
        </tbody>
    </table>
     <ul class="seachform1">
    <li class="sarchbtn">
    	<input  type="button" class="scbtn2" value="返回" onclick="javascript:history.go(-1);"></input> 
    </li>  
    </ul>
	</div> 
   </div>
</body>

</html>
