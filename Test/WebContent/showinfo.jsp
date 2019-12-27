<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
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
<title>所有汽车信息</title>
</head>
<body>
	<%
	ArrayList<Car> list=(ArrayList<Car>)session.getAttribute("list");
	
	/*${list}*/
	%>
	<form action="SelectAllCar">
		<input type="submit" value="显示所有信息" name="AllCar">
	</form>	
	
	<form action="CarFindId">
		<input type="submit" value="Id查询">
		<input type="text" name="id">
	</form>
	<form action="FuzzyCar">
		<input type="submit" value="模糊查询" name="FuzzyCar">
		<input type="text" name="str">
	</form>
	<a href="AddCar.jsp">添加汽车</a>
	<table>
		<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>TYPE</th>
		<th>PRICE</th>
		<th>change/delete</th>
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
		<tr>
			<td colspan="4" align="center">${bar}</td>
		</tr>
		<tr><td colspan="4" align="center">
			每页显示条数：
			<form action="SelectAllCar" method="get">
				<input type="text" name="num" value="${empty num?10:num}">
				<input type="submit" value="确定">
			</form>
		</td></tr>
		<% 
		/*
		if(list!=null){
		for(int i=0;i<list.size();i++){
			out.print("<tr>");
			out.print("<td>"+list.get(i).getId()+"</td>");
			out.print("<td>"+list.get(i).getName()+"</td>");
			out.print("<td>"+list.get(i).getType()+"</td>");
			out.print("<td>"+list.get(i).getPrice()+"</td>");
			}
		}
		*/
		%>
	</table>
</body>
</html>