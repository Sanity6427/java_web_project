<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
		String num = request.getParameter("num");
		if (num == null || num.trim().equals("")){
			response.sendRedirect("list.jsp");
			return;
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ۻ���</title>
</head>
<body>
	<div align="center">
		<b>�ۻ���</b>
		<form name="f" action="deletePro.jsp" method="post">
			<input type="hidden" name="num" value="<%=num %>"/>
			<table border="1" width="300">
				<tr bgcolor="yellow">
					<th>��й�ȣ�� �Է��� �ּ���.</th>
				</tr>
				<tr>
					<td align="center">��й�ȣ : <input type="password" name="passwd">
					</td>
				</tr>
				<tr bgcolor="yellow">
					<td align="center"><input type="submit" value="�ۻ���"> 
					<input type="button" value="�۸��"
							onclick="window.location='list.jsp'"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>