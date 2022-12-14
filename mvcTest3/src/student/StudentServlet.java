package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
						HttpServletResponse resp) 
							throws ServletException, IOException {
		req.setCharacterEncoding("EUc-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		
		String cmd = req.getParameter("command");
		
		StudentFactory factory = StudentFactory.getInstance();
		CommandIf cmdIf = factory.createCommand(cmd);
		String nextPage = (String)cmdIf.processCommand(req, resp);
		RequestDispatcher view = 
						req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	
}
}









