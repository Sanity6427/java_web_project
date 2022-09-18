package memo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemoInsertServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		PrintWriter pw = resp.getWriter();
		
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String memo = req.getParameter("memo");
		
		MemoDAO dao = new MemoDAO();
		int res = dao.insertMemo(id, email, memo);
		if (res>0) {
			pw.println("<script type='text/javascript'>");
			pw.println("alert('메모 등록 성공!! 메모장페이지로 이동합니다.')");
			pw.println("location.href='memoList.do'");
			pw.println("</script>");
		}else {
			pw.println("<script type='text/javascript'>");
			pw.println("alert('메모 등록 실패!! 메모등록페이지로 이동합니다.')");
			pw.println("location.href='memo.html'");
			pw.println("</script>");
		}
	}
	
}









