<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*,mvcBoard.*" %>    
<!-- list.jsp -->
<jsp:useBean id="bdao" class="mvcBoard.BoardDAO" />
<html>
<head>
	<title>게시글목록</title>
</head>
<body>
	<div align="center">
		<b>글 목 록</b>
		<table border="0" width="800">
			<tr bgcolor="yellow">
				<td align="right"><a href="writeForm.jsp">글쓰기</a></td>
			</tr>
		</table>
		<table border="1" width="800">
			<tr bgcolor="green">
				<th>번호</th>
				<th width="30%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>IP</th>
			</tr>
<%--		DB에서 자료를 가져와 출력시키기 --%>
<%		List<BoardDTO> list = bdao.listBoard(); 
			if (list == null || list.size()==0){%>
			<tr>
				<td colspan="6">등록된 게시글이 없습니다</td>
			</tr>
<%		}else {	
				for(BoardDTO dto : list){%>
			<tr>
				<td><%=dto.getNum()%></td>
				<td><a href="content.jsp?num=<%=dto.getNum()%>"><%=dto.getSubject()%></a></td>
				<td><%=dto.getWriter()%></td>
				<td><%=dto.getReg_date()%></td>
				<td><%=dto.getReadcount()%></td>
				<td><%=dto.getIp()%></td>
			</tr>
<%			} 
			}%>						
		</table>
	</div>
</body>
</html>