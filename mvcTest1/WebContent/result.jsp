<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>���򸻺���</title>
</head>
<%
	List<String> list = (List)request.getAttribute("advice");
%>
<body>
	<h1 align="center">�а� ���ÿ� ���� ���� �ý���</h1>
	<hr color="red">
	<%
		if(list == null || list.size()==0){
			out.println("�˼��մϴ�. ������ �غ���� ���߽��ϴ�.");
		}else {
			for(String advice : list){
				out.println(advice + "<br>");
			}
		}
	%>
</body>
</html>