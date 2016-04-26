$().ready(function(){
			$("#submit").click(function(){
				$.post("verifyPsw.do",{password:$("#password").val()},function(data){
					//如果服务器返回“OK”则添加新的内容
					if(data=="ok"){
						$("#msg").text("");
						var $element1=$("<li><label>新&nbsp; 密&nbsp; 码</label><input id='psw1' name='newpsw1' type='password' class='dfinput' /><i id='msg1'>密码长度不超过20个字符</i></li>");
						var $element2=$("<li><label>确认密码</label><input id='psw2' name='newpsw2' type='password' class='dfinput' /><i id='msg2'></i></li>");
						var $submit=$("<li><label>&nbsp;</label><input type='submit' class='btn' value='确认提交' /></li>");
						$("form").attr("action","updatepsw.do");
						$("#subli").remove();
						$(".forminfo").append($element1);
						$(".forminfo").append($element2);
						$(".forminfo").append($submit);
						//当确认密码框值改变时触发判断函数，两次密码不对则输入框变成红色
							$("#psw2").bind("input propertychange",function(e){
								if($("#psw1").val()!=$("#psw2").val()){
									$("#psw2").attr("style","background: red none repeat scroll 0% 0%;");
								}else{
									$("#psw2").attr("style","");
								}
							});
						
					}else{//否则输出错误提示
						$("#msg").text(data);
					}
				},"text");
			});
		});
function cansubmit(){
	if($("#psw2").val()==null || $("#psw2").val()==""){
		$("#msg2").text("密码不能为空！");
		return false;
	}
	if($("#psw1").val()!=$("#psw2").val())
		return false;
	else
		return true;
}