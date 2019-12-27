<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<script src="jquery-3.4.0.min.js"></script>
<script src="js/md5.js"></script>
<script type="text/javascript">
	function fun(){
		$("#pwd").val(md5(md5($("#pwd").val())+$("#time").val()));
	}
</script>
</head>
<body>
<form action="Login" method="post" onsubmit="return fun()">
	username:<input type="text" name="username" value="${cookie.username.value}"><br>
	password:<input type="password" id="pwd" name="password" value="${cookie.password.value}"><br>
	<input type="hidden" id="time" value="${time}">
	<input type="checkbox" value="yes" name="save" ${empty cookie.save.value?'':'checked'}>保存密码
	<% 
	/*
	hobby:<input type="checkbox" name="hobby" value="song">song
	<input type="checkbox" name="hobby" value="rap">rap
	<input type="checkbox" name="hobby" value="tiao">tiao<br>
	*/
	%>
	<input type="submit" value="登录">
</form>

<a href="Register.jsp">注册</a>
</body>
</html>