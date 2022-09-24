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
		alert("게시글 수정성공!! 게시글 목록페이지로 이동합니다.")
		location.href="list.jsp"
	</script>
<%	}else if (res<0){%>
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다!! 다시 입력해 주세요.")
		location.href="updateForm.jsp?num=<%=bdto.getNum()%>"
	</script>
<%	}else {%>
	<script type="text/javascript">
		alert("게시글 수정실패!! 게시글 상세보기 페이지로 이동합니다.")
		location.href="content.jsp?num=<%=bdto.getNum()%>"
	</script>
<%	}%>

