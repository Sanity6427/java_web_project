<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- top.jsp -->
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>ȸ������</title>
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
					�α����� ���ּ���
<%			}else { %>
					<%=mdto.getName()%>[<%=mdto.getId()%>]���� �α�����......
<%			} %>				
			</td>
		</tr>
	</table>
	<table border="1" width="700" height="500">
		<tr>
		<th>
<%		if (mdto==null){ %>		
			<a href="login.jsp">�α���</a>
<%		}else { %>
			<a href="logout.jsp">�α׾ƿ�</a>
<%		} %>			
		</th>
			<th><a href="javascript:checkMember()">ȸ������</a></th>
			<th><a href="memberAll.jsp">ȸ������</a></th>
			<th><a href="memberAll.jsp?mode=find">ȸ��ã��</a></th>
		</tr>
		<tr height="80%">
			<td colspan="4">
			
			
			
			
			
			