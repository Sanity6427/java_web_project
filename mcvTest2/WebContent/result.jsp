<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, mvcTest2.*" %>    
<!-- result.jsp -->
<%
		Hashtable<String, BookDTO> ht = 
							(Hashtable)request.getAttribute("result");
%>
<html>
<head>
	<title>결재내역서</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>도 서 결 재 내 역 서</h2>
		<hr color="green" width="300">
		<table border="1" width="600">
			<tr bgcolor="yellow">
				<th>도서명</th>
				<th>저자</th>
				<th>단가</th>
				<th>수량</th>
				<th>금액</th>
			</tr>
<%
		Enumeration<String> enu = ht.keys();
		int sum = 0;
		while(enu.hasMoreElements()){
			BookDTO dto = ht.get(enu.nextElement());%>
			<tr>
				<td align="center"><%=dto.getTitle()%></td>
				<td align="center"><%=dto.getAuthor()%></td>
				<td align="right"><%=dto.getPrice()%></td>
				<td align="center"><%=dto.getQty()%></td>
				<td align="right"><%=dto.getPrice()*dto.getQty()%></td>
			</tr>	
<%		sum += dto.getPrice() * dto.getQty();
		}%>		
			<tr>
				<td colspan="5" align="right">
					총 결재 금액 : <%=sum%>원
				</td>
			</tr>	
		</table>		
	</div>
</body>
</html>





