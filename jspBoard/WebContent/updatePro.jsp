<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- updatePro.jsp -->
<% 
	request.setCharacterEncoding("EUC-KR");
	
%>
<jsp:useBean id="bdao" class="mvcBoard.BoardDAO"/>
<jsp:useBean id="bdto" class="mvcBoard.BoardDTO"/>
<jsp:setProperty name="bdto" property="*"/>
<% 
	if(bdto.getWriter()==null || bdto.getWriter().trim().equals("")){
		response.sendRedirect("list.jsp");
		return;
	}

	int res = bdao.updateBoard(bdto);
	
	if (res>0){%>
	<script type="text/javascript">
		alert("�Խñ� ��������!! �Խñ� ����������� �̵��մϴ�.")
		location.href="list.jsp"
	</script>
<%	}else if (res<0){%>
	<script type="text/javascript">
		alert("��й�ȣ�� Ʋ�Ƚ��ϴ�!! �ٽ� �Է��� �ּ���.")
		location.href="updateForm.jsp?num=<%=bdto.getNum()%>"
	</script>
<%	}else {%>
	<script type="text/javascript">
		alert("�Խñ� ��������!! �Խñ� �󼼺��� �������� �̵��մϴ�.")
		location.href="content.jsp?num=<%=bdto.getNum()%>"
	</script>
<%	}%>

