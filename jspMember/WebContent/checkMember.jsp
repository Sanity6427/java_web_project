<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<jsp:useBean id="mdao" class="member.MemberDAO"/>

<%
	request.setCharacterEncoding("EUC-KR");
	String name = request.getParameter("name");
	String ssn1 = request.getParameter("ssn1");
	String ssn2 = request.getParameter("ssn2");
	
	if (name==null || name.trim().equals("") ||
			ssn1==null || ssn1.trim().equals("") ||
			ssn2==null || ssn2.trim().equals("")) {%>
		<script type="text/javascript">
			alert("�̸�, �ֹι�ȣ�� ��� �Է��� �ּ���!!")
			history.back()
		</script>
<%		return;

	}
	int res = mdao.checkMember(name, ssn1, ssn2);
	if(res==1) {%>
		<script type="text/javascript">
			alert("�̹� ȸ���̽ʴϴ�. �α����� ���ּ���!!")
			self.close()
		</script>
		
<%	}else{%>
		<form name="f" action="member.jsp" method="post">
			<input type="hidden" name="name" value="<%=name %>"/>
			<input type="hidden" name="ssn1" value="<%=ssn1 %>"/>
			<input type="hidden" name="ssn2" value="<%=ssn2 %>"/>
		</form>
		<script type="text/javascript">
			alert("ȸ�� ������������ �̵��մϴ�.")
			document.f.submit()
		</script>
	<%}%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>