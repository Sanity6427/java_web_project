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
				"listBoard ���� DB���� ���� �߻�!! �����ڿ��� �����ϼ���");
			req.setAttribute("url" , 
					"index_board.do");
			return "message.jsp";
		}
	}

}
