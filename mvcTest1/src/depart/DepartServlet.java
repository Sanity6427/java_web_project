package depart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepartServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=EUC-KR");
		req.setCharacterEncoding("EUC-KR");
		
		String depart = req.getParameter("depart");
		
		DepartExpert de = new DepartExpert();
		List<String> list = de.getAdivce(depart);
		
		req.setAttribute("advice", list);
		
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		//result.jsp로 내부적으로 이동을 시키는 명령
		// 
		view.forward(req, resp);
	}

}
