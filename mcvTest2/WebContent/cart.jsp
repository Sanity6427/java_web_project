<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.*,mvcTest2.*"%>
<!-- cart.jsp -->
<%
	List<BookDTO> list = (List)session.getAttribute("cart");
	if(list != null && list.size() != 0){
%>
<b>현재 주문한 도서 내역</b>
<table border="1">
	<tr bgcolor="yellow">
		<th>도서명</th>
		<th>저자</th>
		<th>가격</th>
		<th>수량</th>
		<th>삭제</th>
	</tr>
	<%
		for(int i=0; i<list.size(); ++i){
				BookDTO cart = list.get(i);%>
	<tr>
		<td><%=cart.getTitle()%></td>
		<td><%=cart.getAuthor()%></td>
		<td><%=cart.getPrice()%></td>
		<td><%=cart.getQty()%></td>
		<td>
			<form name="f" action="bookShop.do" method="post">
			<input type="hidden" name="command" value="DEL"/>
			<input type="hidden" name="idx" value="<%=i%>"/>
				<input type="submit" value="삭제">
			</form>
		</td>
	</tr>
	<%		}%>
	<tr>
		<td colspan="5" align="right">
			<form name="f" action="bookShop.do" method="post">
			<input type="hidden" name="command" value="CHK"/>
				<input type="submit" value="주문내역서 페이지로 이동">
			</form>
		</td>
	</tr>
</table>
<%	}%>