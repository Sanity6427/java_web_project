<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <jsp:useBean id="stdao" class="student.StudentDAO"/>

	<% 
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	
	int res = stdao.deleteStudent(id);
	
	/* Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "web09";
	String pass = "web09";
	Connection con = DriverManager.getConnection
													(url, user, pass);
	String sql = "delete from student where id = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, id);
	
	int res = ps.executeUpdate();
	*/
	
	
	
	if (res>0){		%>
		<script type="text/javascript">
			alert("�л���������!! �л������������ �̵��մϴ�.")
			location.href="list.jsp"
		</script>
<%	}else { %>
		<script type="text/javascript">
			alert("�л���������!! ������������ �̵��մϴ�.")
			location.href="student.jsp"
		</script>	
<%	} %>
	
	


</body>
</html>