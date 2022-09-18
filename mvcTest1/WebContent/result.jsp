<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>도움말보기</title>
</head>
<%
	List<String> list = (List)request.getAttribute("advice");
%>
<body>
	<h1 align="center">학과 선택에 따른 도움말 시스템</h1>
	<hr color="red">
	<%
		if(list == null || list.size()==0){
			out.println("죄송합니다. 도움말이 준비되지 못했습니다.");
		}else {
			for(String advice : list){
				out.println(advice + "<br>");
			}
		}
	%>
</body>
</html>