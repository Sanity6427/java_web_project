package mvcBoard;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteProBoardCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setContent(req.getParameter("content")); 
		dto.setIp(req.getRemoteAddr());

		String msg = null, url = null;
		
		try {
			int res = dao.insertBoard(dto);
			if(res > 0) {
				msg = "게시글 등록 성공!! 게시글 목록페이지로 이동합니다.";
				url = "list_board.do";
			}else {
				msg = "게시글 등록 실패!! 게시글 등록페이지로 이동합니다.";
				url = "writeForm_board.do";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "insert 메소드 중 DB서버오류 발생!! 관리자에게 문의하세요.";
			url = "index_board.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}

}
