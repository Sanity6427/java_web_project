<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- delete.jsp -->
<%
	String no = request.getParameter("no");
	
	if(no == null || no.trim().equals("")){
		response.sendRedirect("memberAll.jsp");
		return;
	}
%>
<jsp:useBean id="mdao" class="member.MemberDAO"/>

<% int res = mdao.deleteMember(Integer.parseInt(no));

	if(res > 0) {%>
		<script type=text/javascript>
			alert("ȸ�� ���� ����!! ȸ�� ���� �������� �̵��մϴ�.")
			location.href="memberAll.jsp"
		</script>
<%	}else {%>
		<script type=text/javascript>
			alert("ȸ�� ���� ����!! ȸ�� ���� �������� �̵��մϴ�.")
			location.href="memberAll.jsp"
		</script>
<% }%>