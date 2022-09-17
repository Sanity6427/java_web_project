<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- searchMember_ok.jsp -->
<jsp:useBean id="mdao" class="member.MemberDAO" />
<%
		request.setCharacterEncoding("EUC-KR");
		String name = request.getParameter("name");
		String ssn1 = request.getParameter("ssn1");
		String ssn2 = request.getParameter("ssn2");
		String id = request.getParameter("id");
		
		if (name==null || ssn1==null || ssn2==null || 
				name.trim().equals("") || ssn1.trim().equals("") || ssn2.trim().equals("")){
			response.sendRedirect("index.jsp");
			return;
		}
				
		String msg = mdao.searchMember(name, ssn1, ssn2, id);
		String url = "searchMember.jsp";
		if (msg == null){
			if (id==null){
				msg = "찾는 아이디가 없습니다. 다시 입력해 주세요";
			}else {
				msg = "해당하는 비밀번호가 존재하지 않습니다. 다시 입력해 주세요";
			}%>
		<script type="text/javascript">
			alert("<%=msg%>")
			location.href="<%=url%>"
		</script>		
<%	}else {%>
		<script type="text/javascript">
			alert("<%=msg%>")
			self.close()
		</script>
<%	} %>




