<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="mvcTest2.*"%>
<!-- order.jsp -->

<html>
<head>
<%
	List<BookDTO> list = (List)session.getAttribute("list");
	if(list != null && list.size() != 0){
%>
</head>
<body>
<h2>�� �� �� �� ��</h2>
<hr color="green" width="300">
<table border="0" width="100%">
	<tr>
		<th>������</th>
		<th>�۰�</th>
		<th>�ܰ�</th>
		<th>����</th>
		<th>�ݾ�</th>
		<th>���</th>
	</tr>
	
<%
		for(BookDTO dto : list){%>			
	<tr>
		<td><%=dto.getTitle()%></td>
		<td><%=dto.getAuthor()%></td>
		<td><%=dto.getPrice()%></td>
		<td><%=dto.getQty()%></td>
		<td><%=dto.getPrice() * dto.getQty()%></td>
		<td>���</td>
	</tr>
	<% } %>
	<% } %>
</table>
</body>
</html>