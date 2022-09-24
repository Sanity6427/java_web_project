<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="bdao" class="mvcBoard.BoardDAO"/>
<jsp:useBean id="bdto" class="mvcBoard.BoardDTO"/>
<jsp:setProperty name="bdto" property="*"/>

<%
	
	if (bdto.getWriter() == null || bdto.getWriter().trim().equals("")){
	response.sendRedirect("writeForm.jsp");
	return;
	}
	bdto.setIp(request.getRemoteAddr());
	int res = bdao.insertBoard(bdto);
	String msg, url;
	if(res > 0) {
		msg = "게시글 등록 성공!! 게시글 목록페이지로 이동합니다.";
		url = "list.jsp";
	}else {
		msg = "";
		url = "writeForm.jsp";
	}
%>
<script type ="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>"
</script>