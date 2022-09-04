<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello, JSP!!</h2>
	<% for(int i = 0;i < 10; ++i) {%>
		<h3>Hello,JSP<%=i %></h3>
	<% } %>
</body>
</html>