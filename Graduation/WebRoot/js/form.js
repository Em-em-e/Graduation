$().ready(function(){
		//当班级select改变时，获取班级下的课程信息
		$("#class").change(function(){
			$("#course option[value!='']").remove();
			$.post("ajaxcourses.do",{classid:$(this).val()},function(data){
				var course=eval(data);
				for ( var i=0;i<course.length;i=i+1) {
					var id=course[i].id;
					var name=course[i].name;
					
					var $optionElement=$("<option value='"+id+"'>"+name+"</option>");
					$("#course").append($optionElement);
				}
			},"json");
		});
	}
);