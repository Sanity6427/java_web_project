package mvcBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		
		String uri = req.getRequestURI();
		String upPath = req.getContextPath();
		
		String cmd = uri.substring(upPath.length());
		
		//Factory pattern�� Command ��üȭ�� �̿��� �������
		//�Խ��� �۸���� �ϼ������ּ���
		BoardFactory factory = BoardFactory.getInstance();
		CommandIf cmdIf = factory.createCommand(cmd);
		String nextPage = (String)cmdIf.processCommand(req, resp);
		
		RequestDispatcher view = 
				req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
		
	}


}
