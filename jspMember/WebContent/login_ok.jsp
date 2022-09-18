<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="member.*"%>
<!-- login_ok.jsp -->
<jsp:useBean id="mdao" class="member.MemberDAO"/>
<%
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String saveId = request.getParameter("saveId");
		//checkbox���� �Ѿ�� �����ʹ� üũ�� �Ǿ������� on, �ȵǾ� ������  null
		
		if (id == null || id.trim().equals("")){
			response.sendRedirect("index.jsp");
			return;
		}
		
		int res = mdao.loginCheck(id, passwd);
		String msg = null, url = "login.jsp";
		switch(res){
		case MemberDAO.OK :
			Cookie ck = new Cookie("saveId", id);
			if (saveId == null){
				ck.setMaxAge(0);
			}else {
				ck.setMaxAge(60*60*24);
			}
			response.addCookie(ck);
			MemberDTO dto = mdao.getMember(id);
			session.setAttribute("mbdto", dto);
			msg = dto.getName() + "���� �α��� �Ǿ����ϴ�.";
			url = "index.jsp";
			break;
		case MemberDAO.NOT_ID :
			msg = "���� ���̵� �Դϴ�. �ٽ� Ȯ���� ������";
			break;
		case MemberDAO.NOT_PWD :
			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���";
			break;
		case MemberDAO.ERROR :
			msg = "DB���� ���� �߻�!! �����ڿ��� �����ϼ���";
		}
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"
</script>







