<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<script src="jquery-3.4.0.min.js"></script>
<script src="js/md5.js"></script>
<script type="text/javascript">
$("document").ready(function(){
	$("#changepwd2").on('input',function(){
		if($("#changepwd2").val()==$("#changepwd1").val()){
		$("span").html("正确");
		}else{
			$("span").html("错误");
			}
		});
})
	function fun(){
		$("#oldpwd").val(md5(md5($("#oldpwd").val())+$("#time").val()));
	}
</script>
</head>
<body>
<form action="ChangPwd" method="post" onsubmit="return fun()">
	原密码：<input type="password" name="oldpwd" id="oldpwd"><br>
	<input type="hidden" id="time" value="${time}">
	修改密码：<input type="password" name="pwd" id="changepwd1"><br>
	确认密码：<input type="password" name="pwd2" id="changepwd2"><span></span><br>
	<input type="submit" value="修改">
</form>
<script type="text/javascript">

	
</script>
</body>
</html>