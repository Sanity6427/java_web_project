<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- memberSsn.jsp -->
<html>
<head>
<title>ȸ����������</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>ȸ �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<form name="f" action="checkMember.jsp" method="post">
			<table border="1" witdh="500">
				<tr>
					<th>�̸�</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>�ֹι�ȣ</th>
					<td><input type="text" name="ssn1" maxlength="6"> - <input
						type="password" name="ssn2" maxlength="7"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="��ȸ">
						<input type="reset" value="���"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>