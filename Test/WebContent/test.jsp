<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookie_test</title>
</head>
<body>
<%
	boolean flag = false;
	Cookie[]cookies=request.getCookies();
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("cn.pzhu.class.firt"))
				flag=true;
		}
		if(flag==false){
			out.print("欢迎第一次访问本网站");
			
			response.addCookie(new Cookie("cn.pzhu.class.firt","no"));
		
		}else{
			out.print("欢迎再次访问本网站");
		}
	}
%>

</body>
</html>