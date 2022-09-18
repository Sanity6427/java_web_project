<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- top.jsp -->
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>회원관리</title>
	<script type="text/javascript">
		function checkMember(){
			window.open("memberSsn.jsp", "", 
									"width=640, height=400")
		}
	</script>
</head>
<%
		MemberDTO mdto = (MemberDTO)session.getAttribute("mbdto");
%>
<body>
	<div align="center">
	<table border="0" width="700">
		<tr>
			<td align="right">
<%			if (mdto == null) {%>
					로그인을 해주세요
<%			}else { %>
					<%=mdto.getName()%>[<%=mdto.getId()%>]님이 로그인중......
<%			} %>				
			</td>
		</tr>
	</table>
	<table border="1" width="700" height="500">
		<tr>
		<th>
<%		if (mdto==null){ %>		
			<a href="login.jsp">로그인</a>
<%		}else { %>
			<a href="logout.jsp">로그아웃</a>
<%		} %>			
		</th>
			<th><a href="javascript:checkMember()">회원가입</a></th>
			<th><a href="memberAll.jsp">회원보기</a></th>
			<th><a href="memberAll.jsp?mode=find">회원찾기</a></th>
		</tr>
		<tr height="80%">
			<td colspan="4">
			
			
			
			
			
			