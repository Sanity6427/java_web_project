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
				msg = "�Խñ� ��������!! �Խñ� ����������� �̵��մϴ�.";
				url = "list_board.do";
			}else if(res < 0){
				msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�!! �ٽ� �Է��� �ּ���.";
				url = "deleteForm.jsp?num=" + num;
			}else {
				msg = "�Խñ� ��������!! �Խñ� �󼼺��� �������� �̵��մϴ�.";
				url = "content.jsp?num=" + num;
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
