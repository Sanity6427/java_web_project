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
				msg = "�Խñ� ��������!! �Խñ� ����������� �̵��մϴ�.";
				url = "list_board.do";
			}else if (res < 0) {
				msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�!! �ٽ� �Է��� �ּ���.";
				url = "updateForm_board.do?num=" + dto.getNum();
			}else {
				msg = "�Խñ� ���� ����!! �Խñ� �󼼺��� �������� �̵��մϴ�.";
				url = "content_board.do?num=" + dto.getNum();
			}
		} catch (SQLException e) {
			req.setAttribute("msg", "DeletePro �޼ҵ� �� DB�������� �߻�!! �����ڿ��� �����ϼ���");
			req.setAttribute("url", "index_board.do");
			e.printStackTrace();
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
