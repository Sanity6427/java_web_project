package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=EUC-KR");
		req.setCharacterEncoding("EUC-KR");
		PrintWriter pw = resp.getWriter();
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		pw.println("<h2>" + name + "님의 전화번호 : " + tel + "</h2>");
		pw.close();
	}

	

}
