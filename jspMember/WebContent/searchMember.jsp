<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- searchMember.jsp -->
<%
	String mode = request.getParameter("mode");
%>
<html>
<head>
<%	if (mode.equals("id")){ %>
		<title>���̵�ã��</title>
<%	}else { %>
		<title>��й�ȣã��</title>
<%	} %>		
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
<%	if (mode.equals("id")){ %>
		<h2>�� �� �� ã ��</h2>
<%	}else { %>
		<h2>�� �� �� ȣ ã ��</h2>
<%	} %>		
		<hr color="green" width="300">
		<form name="f" action="searchMember_ok.jsp" method="post">
			<table border="0" width="500" class="outline">
				<tr>
					<th>�̸�</th>
					<td><input type="text" name="name" class="box"></td>
				</tr>
				<tr>
					<th>�ֹι�ȣ</th>
					<td><input type="text" name="ssn1" maxlength="6" class="box"> -
					<input type="password" name="ssn2" maxlength="7" class="box"></td>
				</tr>	
<%		if (mode.equals("pw")){ %>
				<tr>
					<th>���̵�</th>
					<td><input type="text" name="id" class="box"></td>
				</tr>
<%		} %>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="��ȸ">
						<input type="reset" value="���">
					</td>
				</tr>
			</table>
		</form>	
	</div>
</body>
</html>