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
		msg = "�Խñ� ��� ����!! �Խñ� ����������� �̵��մϴ�.";
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