package student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("name");
		if(name==null){
			resp.sendRedirect("student.jsp");
		}
		
		StudentDAO dao = new StudentDAO();
		
		try {
			List<StudentDTO> find = dao.findStudent(name);
			req.setAttribute("listStudent", find);
			return "list.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", 
					"find 도중 DB서버 오류 발생!! 관리자에게 문의하세요");
				req.setAttribute("url" , 
							"student.do?command=index");
				return "message.jsp";
		}
	}

}
