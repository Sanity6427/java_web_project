package memo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemoListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		PrintWriter pw = resp.getWriter();
		
		MemoDAO dao = new MemoDAO();
		List<MemoDTO> list = dao.listMemo();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>�޸���</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div align='center'>");
		pw.println("<hr color='green' width='300'>");
		pw.println("<h2>���� �޸��� ���</h2>");
		pw.println("<hr color='green' width='300'>");
		pw.println("<table width='500' border='1'>");
		pw.println("<tr bgcolor=#e9e9e9>");
		pw.println("<th width=25%>�ۼ���</th>");
		pw.println("<th width=50%>�޸𳻿�</th>");
		pw.println("<th width=25%>�̸���</th>");
		pw.println("</tr>");
		if (list == null || list.size()==0) {
			pw.println("<tr>");
			pw.println("<td colspan='3'>");
			pw.println("��ϵ� �޸� �����ϴ�.");
			pw.println("</td>");
			pw.println("</tr>");
		}else {
			for(MemoDTO dto : list) {
				pw.println("<tr>");
				pw.println("<td>"+dto.getId()+"</td>");
				pw.println("<td>"+dto.getMemo()+"</td>");
				pw.println("<td>"+dto.getEmail()+"</td>");
				pw.println("</tr>");
			}
		}
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
	}
}







