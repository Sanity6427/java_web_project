<%@page import="java.util.*, student.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="stdao" class="student.StudentDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�л� ã��</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>�� �� ã ��</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>���̵�</th>
				<th>�л���</th>
				<th>�б޸�</th>
			</tr>
<%		
		request.setCharacterEncoding("EUC-KR");
		String name = request.getParameter("name");
		if(name==null){
			response.sendRedirect("student.jsp");
		}
		List<StudentDTO> list = stdao.findStudent(name);
			for(StudentDTO dto : list){
%>
			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getCname()%></td>
			</tr>				
<% } %>
		</table>
	</div>

</body>
</html>