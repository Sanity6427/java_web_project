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
			alert("회원 삭제 성공!! 회원 보기 페이지로 이동합니다.")
			location.href="memberAll.jsp"
		</script>
<%	}else {%>
		<script type=text/javascript>
			alert("회원 삭제 실패!! 회원 보기 페이지로 이동합니다.")
			location.href="memberAll.jsp"
		</script>
<% }%>