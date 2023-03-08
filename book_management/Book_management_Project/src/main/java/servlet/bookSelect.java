package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.controlDAO;
import vo.book_rent_vo;
import vo.mem_rent_vo;

@WebServlet("/bookSelect")
public class bookSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public bookSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controlDAO dao = new controlDAO();
		ArrayList<mem_rent_vo> memList = dao.mem_rent_select();
		ArrayList<book_rent_vo> list = dao.book_rent_select();
		
		request.setAttribute("memList", memList);
		request.setAttribute("bookList", list);
		request.getRequestDispatcher("/book/book_select.jsp").forward(request, response);
	}

}
