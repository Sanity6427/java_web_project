<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="member.*"%>
<!-- login_ok.jsp -->
<jsp:useBean id="mdao" class="member.MemberDAO"/>
<%
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String saveId = request.getParameter("saveId");
		//checkbox에서 넘어온 데이터는 체크가 되어있으면 on, 안되어 있으면  null
		
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
			msg = dto.getName() + "님이 로그인 되었습니다.";
			url = "index.jsp";
			break;
		case MemberDAO.NOT_ID :
			msg = "없는 아이디 입니다. 다시 확인해 보세요";
			break;
		case MemberDAO.NOT_PWD :
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요";
			break;
		case MemberDAO.ERROR :
			msg = "DB서버 오류 발생!! 관리자에게 문의하세요";
		}
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"
</script>







