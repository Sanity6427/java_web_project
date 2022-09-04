<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>구구단</title>
</head>
<body>
	<div align="center">
		<table border="1" width="800">

			<tr>
				<%
					for (int i = 2; i < 10; i++) {
				%>
				<th><%=i%></th>
				<%
					}
				%>
			</tr>
			<%
				for (int k = 1; k < 10; k++) {
			%>
			<tr>
				<%
					for (int j = 2; j < 10; j++) {
				%>

				<td align="center"><%=j%> X <%=k%> = <%=k * j%></td>
				<%
					}
				}
				%>

			</tr>

		</table>
	</div>
</body>
</html>