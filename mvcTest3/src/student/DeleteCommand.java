package student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		StudentDAO dao = new StudentDAO();
		String msg = null, url = null;
		try {
			int res = dao.deleteStudent(id);
			
			if (res>0) {
				msg = "�л���������!! �л������������ �̵��մϴ�.";
				url = "student.do?command=list";
			}else {
				msg = "�л���������!! �л������������ �̵��մϴ�.";
				url = "student.do?command=index";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "delete ���� DB���� ���� �߻�!! �����ڿ��� �����ϼ���";
			url = "student.do?command=index";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}

}