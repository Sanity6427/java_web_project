<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- deletePro.jsp -->
<jsp:useBean id="bdao" class="mvcBoard.BoardDAO" />
<%
		String num = request.getParameter("num");
		String passwd = request.getParameter("passwd");
		if (num == null || num.trim().equals("")){
			response.sendRedirect("list.jsp");
			return;
		}
		if (passwd==null || passwd.trim().equals("")){%>
			<script type="text/javascript">
				alert("��й�ȣ�� �Է��� �ּ���!!")
				location.href="deleteForm.jsp?num=<%=num%>"
			</script>		
<%		return;
		}
		
		int res = bdao.deleteBoard(Integer.parseInt(num), passwd);
		if (res>0){%>
			<script type="text/javascript">
				alert("�Խñ� ��������!! �Խñ� ����������� �̵��մϴ�.")
				location.href="list.jsp"
			</script>
<%	}else if (res<0){%>
			<script type="text/javascript">
				alert("��й�ȣ�� Ʋ�Ƚ��ϴ�!! �ٽ� �Է��� �ּ���.")
				location.href="deleteForm.jsp?num=<%=num%>"
			</script>
<%	}else {%>
			<script type="text/javascript">
				alert("�Խñ� ��������!! �Խñ� �󼼺��� �������� �̵��մϴ�.")
				location.href="content.jsp?num=<%=num%>"
			</script>
<%	}%>





