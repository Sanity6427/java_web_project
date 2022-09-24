package mvcBoard;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProBoardCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		
		int num = Integer.parseInt(req.getParameter("num"));
		String passwd = req.getParameter("passwd");
		String msg = null, url = null;
		
		try {
			int res = dao.deleteBoard(num, passwd);
			if(res > 0) {
				msg = "게시글 삭제성공!! 게시글 목록페이지로 이동합니다.";
				url = "list_board.do";
			}else if(res < 0){
				msg = "비밀번호가 틀렸습니다!! 다시 입력해 주세요.";
				url = "deleteForm.jsp?num=" + num;
			}else {
				msg = "게시글 삭제실패!! 게시글 상세보기 페이지로 이동합니다.";
				url = "content.jsp?num=" + num;
			}
			
		} catch (SQLException e) {
			req.setAttribute("msg", "DeletePro 메소드 중 DB서버오류 발생!! 관리자에게 문의하세요");
			req.setAttribute("url", "index_board.do");
			e.printStackTrace();
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
		
	}

}
