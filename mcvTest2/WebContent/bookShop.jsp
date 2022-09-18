<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
	<title>예제 2</title>
</head>
<body>
	<h1>도서 주문 페이지</h1>
	<form method="post" action="bookShop.do">
		<input type="hidden" name="command" value="ADD"/>
		<b>도서 선택 : </b>
		<select name="book">
			<option>어린왕자/생떽쥐페리/15000
			<option>홍길동전/허균/25000
			<option>죄와벌/톨스토이/20000
			<option>동의보감/허준/30000
		</select>
		<b>수량 : </b>
		<input type="text" name="qty" size="2" value="1">
		<input type="submit" value="도서주문">
	</form>
	<hr color="red">
	<jsp:include page="cart.jsp"/>
</body>
</html>



