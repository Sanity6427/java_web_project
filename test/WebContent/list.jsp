<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, student.*" %>    
<!-- list.jsp -->
<jsp:useBean id="stdao" class="student.StudentDAO"/>
<html>
<head>
	<title>�л����</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>�� �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>���̵�</th>
				<th>�л���</th>
				<th>�б޸�</th>
			</tr>
<%	
		List<StudentDTO> list = stdao.listStudent();
	/*		Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "web09";
			String pass = "web09";
			Connection con = DriverManager.getConnection
														(url, user, pass);
			String sql = "select * from student";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String cname = rs.getString("cname");*/
				
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