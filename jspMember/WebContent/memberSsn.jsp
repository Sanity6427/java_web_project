<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- memberSsn.jsp -->
<html>
<head>
<title>회원가입유무</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>회 원 가 입 유 무</h2>
		<hr color="green" width="300">
		<form name="f" action="checkMember.jsp" method="post">
			<table border="1" witdh="500">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td><input type="text" name="ssn1" maxlength="6"> - <input
						type="password" name="ssn2" maxlength="7"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="조회">
						<input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>