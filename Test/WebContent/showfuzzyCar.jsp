<%@page import="cn.pzhu.class1.Bean.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Car> list=(ArrayList<Car>)session.getAttribute("list");
	
	/*${list}*/
	%>
<table>
		<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>TYPE</th>
		<th>PRICE</th>
		</tr>
		<c:forEach items="${list}" var="temp" varStatus="x">
			<tr>
				<td>${temp.id}</td>
				<td>${temp.name}</td>
				<td>${temp.type}</td>
				<td><f:formatNumber value="${temp.price}" pattern=".00"/></td>
				<td><a href="ChangeCar.jsp?id=${temp.id}&name=${temp.name}&type=${temp.type}&price=${temp.price}">修改/删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>