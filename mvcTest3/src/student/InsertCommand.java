package student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���̵�, �л���, �б޸��� �Է¹޾� DB�� �Ѱܼ� ������ ��Ű��
		//list �������� �̵��Ͽ� ��ü �л������ �����ش�
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String cname = req.getParameter("cname");
		StudentDAO dao = new StudentDAO();
		String msg = null, url = null;
		try {
			int res = dao.insertStudent(id, name, cname);
			if (res>0) {
				msg = "�л���ϼ���!! �л������������ �̵��մϴ�.";
				url = "student.do?command=list";
			}else {
				msg = "�л���Ͻ���!! �л������������ �̵��մϴ�.";
				url = "student.do?command=index";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			msg = "insert ���� DB���� ���� �߻�!! �����ڿ��� �����ϼ���";
			url = "student.do?command=index";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}

}
