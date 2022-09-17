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
			mode = "all";//ȸ��ã���϶��� find�� �ǰ� ��������ο��� �� all
		}
		if (mode.equals("all")){%>
		<hr color="green" width="300">
		<h2>ȸ �� �� �� �� ��</h2>
		<hr color="green" width="300">
<%	}else { %>
		<hr color="green" width="300">
		<h2>ȸ �� ã ��</h2>
		<form name="f" method="post">
			<select name="search">
				<option value="id">���̵�</option>
				<option value="name">�̸�</option>
			</select>
			<input type="text" name="searchString">
			<input type="submit" value="ã��">
		</form>
		<jsp:setProperty property="*" name="mdao"/>
		<hr color="green" width="300">
<%	} %>		
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
	<!-- ���⿡ dao���� ��üȸ���� �޾ƿ� �����ϱ� -->
	<%	
	List<MemberDTO> list = null;
	if (mode.equals("all")) list = mdao.listMember();
	else list = mdao.findMember(); 
	if (list == null || list.size()==0){%>
	<tr>
		<td colspan="7">��ϵ� ȸ���� �����ϴ�.</td>		
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
			<a href="member_update.jsp?no=<%=dto.getNo()%>">����</a> |
			<a href="member_delete.jsp?no=<%=dto.getNo()%>">����</a></td>
	</tr>
<%		}
	}%>	
</table>
</div>
<%@ include file="bottom.jsp"%>