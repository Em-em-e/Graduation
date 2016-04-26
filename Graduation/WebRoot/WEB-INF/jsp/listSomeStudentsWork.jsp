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
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>
<body>
    <div class="formbody">
    
    <div id="usual1" class="usual"> 
    
    <div style="height: 20px;"></div>
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">未完成作业</a></li> 
    <li><a href="#tab2">已完成作业</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    <ul class="seachform">
    
    <li><label>综合查询</label><input name="" type="text" class="scinput" /></li>
    <li><label>指派</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>重点客户</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>客户状态</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>
    
    </ul>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
        <th>作业名称</th>
        <th>所属课程</th>
        <th>发布时间</th>
        <th>截止上交时间</th>
        <th>是否审核</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
			<s:iterator value="unfinishWork" status="s">    
		        <tr>
		        <td><input name="" type="checkbox" value="" /></td>
		        <td><s:property value="#s.getCount()"/></td>
		        <td>${name}</td>
		        <td>${course.name}</td>
		        <td>${firsttime}</td>
		        <td>${lasttime}</td>
		        <td>已审核</td>
		        <td><a href="uploadWorkForm.do?wid=${id }" class="tablelink">上传作业</a>  <a href="#" class="tablelink">查看详情</a></td>
		        </tr> 
		    </s:iterator>    
        </tbody>
    </table>
    
    </div> 
    
    
  	<div id="tab2" class="tabson">
    <ul class="seachform">
    
    <li><label>综合查询</label><input name="" type="text" class="scinput" /></li>
    <li><label>指派</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>重点客户</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>客户状态</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>
    
    </ul>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
        <th>作业名称</th>
        <th>所属课程</th>
        <th>发布时间</th>
        <th>截止上交时间</th>
        <th>是否审核</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
			<s:iterator value="finishedWork" status="s">    
		        <tr>
		        <td><input name="" type="checkbox" value="" /></td>
		        <td><s:property value="#s.getCount()"/></td>
		        <td>${name}</td>
		        <td>${course.name}</td>
		        <td>${firsttime}</td>
		        <td>${lasttime}</td>
		        <td>已审核</td>
		        <td>
		        	<%	Date now=new Date();
		        		Date lasttime=(Date)request.getAttribute("lasttime");
		        	 %>
		        	 <%if(lasttime.after(now)){%>
		        		<a href="uploadWorkForm.do?wid=${id }" class="tablelink">修改</a>  
		        		<%} %>
		        	<a href="#" class="tablelink">查看详情</a></td>
		        </tr> 
		    </s:iterator>    
        </tbody>
    </table>
    
   
  
    
    </div>  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>


</body>

</html>
