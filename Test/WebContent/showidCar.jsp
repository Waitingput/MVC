<%@page import="cn.pzhu.class1.Bean.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>showIdCar</title>
</head>
<body>
	<% Car car=(Car)session.getAttribute("car");%>
	<table>
		<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>TYPE</th>
		<th>PRICE</th>
		</tr>
		<tr>
			<td><%=car.getId() %></td>
			<td><%=car.getName() %></td>
			<td><%=car.getType() %></td>
			<td><%=car.getPrice() %></td>
		</tr>
	</table>
</body>
</html>