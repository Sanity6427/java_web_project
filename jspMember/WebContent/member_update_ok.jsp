<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- update_ok.jsp -->

<%
	request.setCharacterEncoding("EUC-KR");
%>

<jsp:useBean id="mdao" class="member.MemberDAO"/>
<jsp:useBean id="mdto" class="member.MemberDTO"/>
<jsp:setProperty name="mdto" property="*"/>

<%
	if (mdto.getPasswd() == null || mdto.getPasswd().trim().equals("") ||
			mdto.getEmail() == null || mdto.getEmail().trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
		}
	int res = mdao.updateMember(mdto);
	String msg, url;
	if(res > 0) {%>
	<script type ="text/javascript">
		alert("회원 수정 성공!! 회원 보기 페이지로 이동합니다.")
		location.href="memberAll.jsp"
	</script>
<%}else {
	%>
	<script type ="text/javascript">
		alert("회원 수정 실패!! 회원 보기 페이지로 이동합니다.")
		location.href="memberAll.jsp"
	</script>
<%	}%>
