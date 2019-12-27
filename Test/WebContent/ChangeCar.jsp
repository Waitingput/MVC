<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ChangeCar</title>
	<script type="text/javascript" src="jquery-3.4.0.min.js"></script>
	<script type="text/javascript">
		$("document").ready(function(){
			$("#id").val('<%=request.getParameter("id")%>');
			$("#name").val('<%=request.getParameter("name")%>');
			$("#type").val('<%=request.getParameter("type")%>');
			$("#price").val('<%=request.getParameter("price")%>');
		});
	</script>
</head>
<body>
	
<form action="ChangeCar">
	id:<input type="text" name="id" id="id"><br>
	name:<input type="text" name="name" id="name"><br>
	type:<input type="text" name="type" id="type"><br>
	price:<input type="text" name="price" id="price"><br>
	<input type="submit" value="修改">
	
</form>
	<a href="DeleteCar?id=<%=request.getParameter("id")%>">删除</a>
</body>
</html>