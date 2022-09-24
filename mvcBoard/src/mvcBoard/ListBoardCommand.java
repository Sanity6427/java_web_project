package mvcBoard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListBoardCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		try {
			List<BoardDTO> list = dao.listBoard();
			req.setAttribute("listBoard", list);
			return "list.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", 
				"listBoard ���� DB���� ���� �߻�!! �����ڿ��� �����ϼ���");
			req.setAttribute("url" , 
					"index_board.do");
			return "message.jsp";
		}
	}

}
