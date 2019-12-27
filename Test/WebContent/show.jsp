<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
</head>
<body>

<h1>欢迎你，登陆成功</h1>
<h2>欢迎<%=session.getAttribute("name") %></h2>


<%request.setCharacterEncoding("utf-8");%>
你提交的姓名：<%=request.getParameter("username") %>
你提交的密码是：<%=request.getParameter("password") %>
你提交的爱好是：<%String[]hobby=request.getParameterValues("hobby");
	if(hobby==null||hobby.length<=0){
		out.print("null");
}
else
	for(int i=0;i<hobby.length;i++){
		out.print(hobby[i]);
	}%>
<br>
<a href="SelectAllCar">所有汽车信息</a><br>
<a href="ChangePwd.jsp">修改密码</a><br>
</body>
</html>