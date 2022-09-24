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
		//아이디, 학생명, 학급명을 입력받아 DB에 넘겨서 저장을 시키고
		//list 페이지로 이동하여 전체 학생명단을 보여준다
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String cname = req.getParameter("cname");
		StudentDAO dao = new StudentDAO();
		String msg = null, url = null;
		try {
			int res = dao.insertStudent(id, name, cname);
			if (res>0) {
				msg = "학생등록성공!! 학생목록페이지로 이동합니다.";
				url = "student.do?command=list";
			}else {
				msg = "학생등록실패!! 학생등록페이지로 이동합니다.";
				url = "student.do?command=index";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			msg = "insert 도중 DB서버 오류 발생!! 관리자에게 문의하세요";
			url = "student.do?command=index";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url",  url);
		return "message.jsp";
	}

}
