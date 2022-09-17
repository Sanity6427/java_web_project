<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, member.*" %>    
<!-- memberAll.jsp -->
<%@ include file="top.jsp"%>
<jsp:useBean id="mdao" class="member.MemberDAO" />
<div align="center">
<%	
		request.setCharacterEncoding("EUC-KR");
		String mode = request.getParameter("mode");
		if (mode == null){
			mode = "all";//회원찾기일때만 find가 되고 나머지경로에선 다 all
		}
		if (mode.equals("all")){%>
		<hr color="green" width="300">
		<h2>회 원 목 록 보 기</h2>
		<hr color="green" width="300">
<%	}else { %>
		<hr color="green" width="300">
		<h2>회 원 찾 기</h2>
		<form name="f" method="post">
			<select name="search">
				<option value="id">아이디</option>
				<option value="name">이름</option>
			</select>
			<input type="text" name="searchString">
			<input type="submit" value="찾기">
		</form>
		<jsp:setProperty property="*" name="mdao"/>
		<hr color="green" width="300">
<%	} %>		
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
	<!-- 여기에 dao에서 전체회원을 받아와 구현하기 -->
	<%	
	List<MemberDTO> list = null;
	if (mode.equals("all")) list = mdao.listMember();
	else list = mdao.findMember(); 
	if (list == null || list.size()==0){%>
	<tr>
		<td colspan="7">등록된 회원이 없습니다.</td>		
	</tr>
<%} else {
		for(MemberDTO dto : list){%>			
	<tr>
		<td><%=dto.getNo()%></td>
		<td><%=dto.getName()%></td>
		<td><%=dto.getId()%></td>
		<td><%=dto.getEmail()%></td>
		<td><%=dto.getAllHp()%></td>
		<td><%=dto.getJoindate()%></td>
		<td>
			<a href="member_update.jsp?no=<%=dto.getNo()%>">수정</a> |
			<a href="member_delete.jsp?no=<%=dto.getNo()%>">삭제</a></td>
	</tr>
<%		}
	}%>	
</table>
</div>
<%@ include file="bottom.jsp"%>