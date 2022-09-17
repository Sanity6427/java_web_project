<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="member.*"%>
<!-- member_update.jsp -->
<jsp:useBean id="mdao" class="member.MemberDAO"/>
<%
		String no = request.getParameter("no");
		if (no==null || no.trim().equals("")){
			response.sendRedirect("index.jsp");
			return;
		}
		MemberDTO dto = mdao.getMember(Integer.parseInt(no));
%>
<%@ include file="top.jsp"%>
	<script type="text/javascript">
		function check(){
			if (f.passwd.value==""){
				alert("비밀번호를 입력해 주세요!!")
				f.passwd.focus()
				return
			}
			document.f.submit()
		}
	</script>
<div align="center">
	<form name="f" method="post" action="member_update_ok.jsp">
		<input type="hidden" name="no" value="<%=dto.getNo()%>"/>
		<table width="600" align="center" class="outline">
			<tr>
				<td colspan="2" align=center class="m2">회원수정</td>
			</tr>
			<tr>
				<td width="150" class="m3">이름</td>
				<td class="m3">
					<input type="text" name="name" class="box"
					value="<%=dto.getName()%>" readOnly>
				</td>
			</tr>
			<tr>
				<td width="150" class="m3">아이디</td>
				<td class="m3">
					<input type="text" name="id" class="box"
					value="<%=dto.getId()%>" readOnly>
				</td>
 				</tr>
 				<tr>
				<td width="150" class="m3">비밀번호</td>
				<td class="m3">
					<input type="password" name="passwd" class="box"
					value="<%=dto.getPasswd()%>">
				</td>
			</tr>
			<tr>
				<td width="150" class="m3">주민번호</td>
				<td class="m3">
					<input type="text" name="ssn1" class="box"
					value="<%=dto.getSsn1()%>" readOnly> -
				<input type="password" name="ssn2" class="box"
					value="<%=dto.getSsn2()%>" readOnly>
					</td>
			</tr>
			<tr>
				<td width="150" class="m3">이메일</td>
				<td class="m3">
					<input type="text" name="email" class="box"
					value="<%=dto.getEmail()%>">
				</td>
			</tr>
			<tr>
				<td width="150" class="m3">연락처</td>
				<td class="m3">
					<input type="text" name="hp1" class="box"
					maxlength="3" size="3" value="<%=dto.getHp1()%>"> -
					<input type="text" name="hp2" class="box"
					maxlength="4" size="4" value="<%=dto.getHp2()%>"> -
					<input type="text" name="hp3" class="box"
					maxlength="4" size="4" value="<%=dto.getHp3()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="javascript:check()">[전송]</a>
					<a href="#">[취소]</a>
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>