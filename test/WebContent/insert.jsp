<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- insert.jsp -->
<jsp:useBean id="stdao" class="student.StudentDAO" />
<%
		request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="stdto" class="student.StudentDTO"/>
<jsp:setProperty name="stdto" property="*"/>

<%
		//String id = request.getParameter("id");
		//String name = request.getParameter("name");
		//String cname = request.getParameter("cname");
		
		//if (id==null || name==null || cname==null || 
		//		id.trim().equals("") || name.trim().equals("") 
		//								|| cname.trim().equals("")){
		if (stdto.getId() == null || stdto.getId().trim().equals("") ||
			stdto.getName() == null || stdto.getName().trim().equals("") ||
			stdto.getCname() == null || stdto.getCname().trim().equals("")){%>
			<script type="text/javascript">
				alert("���̵�, �̸�, �б޸��� ��� �Է��� �ּ���!!")
				history.back()
			</script>		
<%		return;
		}
		int res = stdao.insertStudent(stdto.getId(), stdto.getName(), stdto.getCname());
/*		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web09";
		String pass = "web09";
		Connection con = DriverManager.getConnection
														(url, user, pass);
		String sql = "insert into student values(?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, cname);
		int res = ps.executeUpdate();*/
		if (res>0){		%>
			<script type="text/javascript">
				alert("�л���ϼ���!! �л������������ �̵��մϴ�.")
				location.href="list.jsp"
			</script>
<%	}else { %>
			<script type="text/javascript">
				alert("�л���Ͻ���!! �л������������� �̵��մϴ�.")
				location.href="student.jsp"
			</script>	
<%	} %>		








