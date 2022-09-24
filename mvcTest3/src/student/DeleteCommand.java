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
				msg = "학생삭제성공!! 학생목록페이지로 이동합니다.";
				url = "student.do?command=list";
			}else {
				msg = "학생삭제실패!! 학생등록페이지로 이동합니다.";
				url = "student.do?command=index";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "delete 도중 DB서버 오류 발생!! 관리자에게 문의하세요";
			url = "student.do?command=index";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}

}
