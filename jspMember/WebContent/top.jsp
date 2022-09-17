<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- top.jsp -->
<html>
<head>
	<title>회원관리</title>
	<script type="text/javascript">
		function checkMember(){
			window.open("memberSsn.jsp", "", 
							"width=640, height=400")
		}
	</script>
</head>
<body>
	<div align="center">
	<table border="1" width="700" height="500">
		<tr>
			<th>로그인</th>
			<th><a href="javascript:checkMember()">회원가입</a></th>
			<th>회원보기</th>
			<th>회원찾기</th>
		</tr>
		<tr height="80%">
			<td colspan="4">