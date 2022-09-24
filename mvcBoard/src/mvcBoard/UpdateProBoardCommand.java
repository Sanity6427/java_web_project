package mvcBoard;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProBoardCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		
		
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		dto.setSubject(req.getParameter("subject"));
		dto.setEmail(req.getParameter("email"));
		dto.setContent(req.getParameter("content"));
		dto.setPasswd(req.getParameter("passwd"));
		String msg = null, url = null;
		
		try {
			int res = dao.updateBoard(dto);
			
			if (res > 0) {
				msg = "게시글 수정성공!! 게시글 목록페이지로 이동합니다.";
				url = "list_board.do";
			}else if (res < 0) {
				msg = "비밀번호가 틀렸습니다!! 다시 입력해 주세요.";
				url = "updateForm_board.do?num=" + dto.getNum();
			}else {
				msg = "게시글 수정 실패!! 게시글 상세보기 페이지로 이동합니다.";
				url = "content_board.do?num=" + dto.getNum();
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
