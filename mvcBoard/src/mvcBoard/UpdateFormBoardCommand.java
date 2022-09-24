package mvcBoard;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormBoardCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String num = req.getParameter("num");
		BoardDAO dao = new BoardDAO();
		try {
			BoardDTO dto = dao.getBoard
					(Integer.parseInt(num), "update");
			req.setAttribute("updateBoard", dto);
			return "updateForm.jsp";
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", 
				"listBoard 도중 DB서버 오류 발생!! 관리자에게 문의하세요");
			req.setAttribute("url" , 
					"index_board.do");
			return "message.jsp";
		}
	}

}
