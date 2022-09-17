<%@page import="member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- memberAll.jsp -->
<jsp:useBean id="mdao" class="member.MemberDAO"/>
<%@ include file="top.jsp"%>
<table border="0" width="100%" class="outline">
	<tr>
		<th class="m3">번호</th>
		<th class="m3">이름</th>
		<th class="m3">아이디</th>
		<th class="m3">이메일</th>
		<th class="m3">전화번호</th>
		<th class="m3">가입일</th>
		<th class="m3">수정|삭제</th>
	</tr>
	<%-- 여기에 dao에서 전체회원을 받아와 구현하기 --%>
	<%		List<MemberDTO> list = mdao.listMember(); 
			if (list == null || list.size()==0){%>
			<tr>
				<td colspan="7">등록된 회원이 없습니다.</td>
			</tr>
<%		}else {	
				for(MemberDTO dto : list){%>
			<tr class="m3">
				<td><%=dto.getNo()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getEmail()%></td>
				<td><%=dto.getAllHp()%></td>
				<td><%=dto.getJoindate()%></td>
				<td>
				<a href="member_update.jsp?no=<%=dto.getNo()%>">수정</a>|
					<a href="member_delete.jsp?no=<%=dto.getNo()%>">삭제</a>
				</td>
			</tr>
<%			} 
			}%>	
</table>

<%@ include file="bottom.jsp"%>