<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- top.jsp -->
<html>
<head>
	<title>ȸ������</title>
	<script type="text/javascript">
		function checkMember(){
			window.open("memberSsn.jsp", "", 
							"width=640, height=400")
		}
	</script>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div align="center">
	<table border="1" width="700" height="500">
		<tr>
			<th><a href="login.jsp">�α���</a></th>
			<th><a href="javascript:checkMember()">ȸ������</a></th>
			<th><a href="memberAll.jsp">ȸ������</a></th>
			<th><a href="memberAll.jsp?mode=find">ȸ��ã��</a></th>
		</tr>
		<tr height="80%">
			<td colspan="4">