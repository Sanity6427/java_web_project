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
	if(res > 0) {%>
	<script type ="text/javascript">
		alert("회원가입 성공!! 로그인을 해 주세요")
		self.close()
	</script>
<%}else {
	%>
	<script type ="text/javascript">
		alert("회원가입 실패!! 회원가입페이지로 이동합니다.")
		location.href="memberSsn.jsp"
	</script>
<%	}%>

