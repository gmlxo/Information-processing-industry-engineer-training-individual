package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.controlDAO;
import vo.mem_vo;

@WebServlet("/memberSelect")
public class memberSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public memberSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controlDAO dao = new controlDAO();
		ArrayList<mem_vo> list = dao.select_mem();
		
		request.setAttribute("member", list);
		request.getRequestDispatcher("/book/mem_select.jsp").forward(request, response);
	}

}
