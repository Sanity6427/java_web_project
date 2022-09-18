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
<h2>주 문 내 역 서</h2>
<hr color="green" width="300">
<table border="0" width="100%">
	<tr>
		<th>도서명</th>
		<th>작가</th>
		<th>단가</th>
		<th>수량</th>
		<th>금액</th>
		<th>비고</th>
	</tr>
	
<%
		for(BookDTO dto : list){%>			
	<tr>
		<td><%=dto.getTitle()%></td>
		<td><%=dto.getAuthor()%></td>
		<td><%=dto.getPrice()%></td>
		<td><%=dto.getQty()%></td>
		<td><%=dto.getPrice() * dto.getQty()%></td>
		<td>비고</td>
	</tr>
	<% } %>
	<% } %>
</table>
</body>
</html>