package mvcTest2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookShopServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=EUC-KR");
		req.setCharacterEncoding("EUC-KR");
		
		String cmd = req.getParameter("command");
		HttpSession session = req.getSession();
		//������ session���� ��������
		List<BookDTO> list = (List)session.getAttribute("cart");
		
		if(cmd.equals("CHK")) {
			
			Hashtable<String, BookDTO> ht = new Hashtable<>();
			for(BookDTO dto : list) {
				if(ht.containsKey(dto.getTitle())) {
					BookDTO dto2 = ht.get(dto.getTitle());
					dto2.setQty(dto2.getQty() + dto.getQty());
				}else {
					ht.put(dto.getTitle(), dto);
				}
			}
			
			req.setAttribute("result", ht);
			
			RequestDispatcher view = req.getRequestDispatcher("result.jsp");
			view.forward(req,resp);
			
		}else {
			if(cmd.equals("ADD")) {
				BookDTO dto = getBook(req);
				if (list == null) {
					list = new ArrayList<>();
				}
				list.add(dto);
				//��ٱ��Ͽ� dto�� �־��ش�
			}else if(cmd.equals("DEL")) {
				String idx = req.getParameter("idx");
				list.remove(Integer.parseInt(idx));
			}
			
			session.setAttribute("cart", list);
			
			RequestDispatcher view = req.getRequestDispatcher("bookShop.jsp");
			view.forward(req,resp);
		}
		
		/*
		PrintWriter pw = resp.getWriter();
		pw.println("������ : " + dto.getTitle());
		pw.println("���� : " + dto.getAuthor());
		pw.println("���� : " + dto.getPrice());
		pw.println("�ֹ����� : " + dto.getQty());
		pw.close();
		*/
	}
	
	protected BookDTO getBook(HttpServletRequest req)
						throws ServletException, IOException{
		BookDTO dto = new BookDTO();
		String data = req.getParameter("book");
		Scanner sc = new Scanner(data).useDelimiter("\\s*/\\s*");
		dto.setTitle(sc.next());
		dto.setAuthor(sc.next());
		dto.setPrice(sc.nextInt());
		dto.setQty(Integer.parseInt(req.getParameter("qty")));
		return dto;
	}

}
