<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="mdao" class="member.MemberDAO"/>
<jsp:useBean id="mdto" class="member.MemberDTO"/>
<jsp:setProperty name="mdto" property="*"/>

<%
	if (mdto.getId() == null || mdto.getId().trim().equals("") ||
			mdto.getPasswd() == null || mdto.getPasswd().trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
		}
	int res = mdao.insertMember(mdto);
	String msg, url;
	if(res > 0) {
		msg = "회원 가입 성공!! 메인 페이지로 이동합니다.";
		url = "index.jsp";
	}else {
		msg = "회원 가입 실패!! 메인 페이지로 이동합니다.";
		url = "index.jsp";
	}
%>
<script type ="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>"
</script>
