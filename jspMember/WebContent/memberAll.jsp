<%@page import="member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- memberAll.jsp -->
<jsp:useBean id="mdao" class="member.MemberDAO"/>
<%@ include file="top.jsp"%>
<table border="0" width="100%" class="outline">
	<tr>
		<th class="m3">��ȣ</th>
		<th class="m3">�̸�</th>
		<th class="m3">���̵�</th>
		<th class="m3">�̸���</th>
		<th class="m3">��ȭ��ȣ</th>
		<th class="m3">������</th>
		<th class="m3">����|����</th>
	</tr>
	<%-- ���⿡ dao���� ��üȸ���� �޾ƿ� �����ϱ� --%>
	<%		List<MemberDTO> list = mdao.listMember(); 
			if (list == null || list.size()==0){%>
			<tr>
				<td colspan="7">��ϵ� ȸ���� �����ϴ�.</td>
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
				<a href="member_update.jsp?no=<%=dto.getNo()%>">����</a>|
					<a href="member_delete.jsp?no=<%=dto.getNo()%>">����</a>
				</td>
			</tr>
<%			} 
			}%>	
</table>

<%@ include file="bottom.jsp"%>