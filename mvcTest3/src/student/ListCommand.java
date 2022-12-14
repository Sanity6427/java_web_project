package student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		try {
			List<StudentDTO> list = dao.listStudent();
			req.setAttribute("listStudent", list);
			return "list.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", 
				"list 도중 DB서버 오류 발생!! 관리자에게 문의하세요");
			req.setAttribute("url" , 
						"student.do?command=index");
			return "message.jsp";
		}

} }
