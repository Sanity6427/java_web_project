<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
	<title>���� 2</title>
</head>
<body>
	<h1>���� �ֹ� ������</h1>
	<form method="post" action="bookShop.do">
		<input type="hidden" name="command" value="ADD"/>
		<b>���� ���� : </b>
		<select name="book">
			<option>�����/�������丮/15000
			<option>ȫ�浿��/���/25000
			<option>�˿͹�/�罺����/20000
			<option>���Ǻ���/����/30000
		</select>
		<b>���� : </b>
		<input type="text" name="qty" size="2" value="1">
		<input type="submit" value="�����ֹ�">
	</form>
	<hr color="red">
	<jsp:include page="cart.jsp"/>
</body>
</html>



