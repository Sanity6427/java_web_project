<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*,mvcBoard.*" %>    
<!-- list.jsp -->
<html>
<head>
	<title>�Խñ۸��</title>
</head>
<body>
	<div align="center">
		<b>�� �� ��</b>
		<table border="0" width="800">
			<tr bgcolor="yellow">
				<td align="right"><a href="writeForm_board.do">�۾���</a></td>
			</tr>
		</table>
		<table border="1" width="800">
			<tr bgcolor="green">
				<th>��ȣ</th>
				<th width="30%">����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>��ȸ��</th>
				<th>IP</th>
			</tr>
<%--		DB���� �ڷḦ ������ ��½�Ű�� --%>
<%		List<BoardDTO> list = (List)request.getAttribute("listBoard"); 
			if (list == null || list.size()==0){%>
			<tr>
				<td colspan="6">��ϵ� �Խñ��� �����ϴ�</td>
			</tr>
<%		}else {	
				for(BoardDTO dto : list){%>
			<tr>
				<td><%=dto.getNum()%></td>
				<td><a href="content_board.do?num=<%=dto.getNum()%>"><%=dto.getSubject()%></a></td>
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