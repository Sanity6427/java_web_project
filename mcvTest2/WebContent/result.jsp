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
	<title>���系����</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>�� �� �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<table border="1" width="600">
			<tr bgcolor="yellow">
				<th>������</th>
				<th>����</th>
				<th>�ܰ�</th>
				<th>����</th>
				<th>�ݾ�</th>
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
					�� ���� �ݾ� : <%=sum%>��
				</td>
			</tr>	
		</table>		
	</div>
</body>
</html>





