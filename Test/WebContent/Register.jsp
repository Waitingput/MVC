<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script src="jquery-3.4.0.min.js"></script>
<script type="text/javascript">
	function fun(){
		if($("#username").val()==""){
			$("#note").html("用户名不能为空");
			return;
		}
		$.get("FindUserServlet",
			{username:$("#username").val()},
			function(msg){
				$("#note").html(msg);
			}	
		)
	}
	function reimg(){
		$.get("CreateImageServlet",function(){
					$("#img").attr("src","CreateImageServlet?"+new Date().getTime());
				});
	}
</script>
</head>
<body>
	<form action="Register" method="post">
	username:<input type="text" name="username" onchange="fun()" id="username"><span id="note"></span><br>
	password:<input type="password" name="password"><br>
	验证码:<input type="text" name="checkcode">
	<img alt="验证码" src="CreateImageServlet" onclick="reimg()" id="img" title="点击刷新验证码"><br>
	<input type="submit" value="注册">
	</form>
</body>
</html>