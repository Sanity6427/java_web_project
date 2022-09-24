package mvcBoard;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentBoardCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String num = req.getParameter("num");
		BoardDAO dao = new BoardDAO();
		try {
			BoardDTO dto = dao.getBoard(Integer.parseInt(num),"content");
			req.setAttribute("getBoard", dto);
			return "content.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "getBoard 메소드 중 DB서버오류 발생!! 관리자에게 문의하세요");
			req.setAttribute("url", "index_board.do");
		}
		return "message.jsp";
	}

}
