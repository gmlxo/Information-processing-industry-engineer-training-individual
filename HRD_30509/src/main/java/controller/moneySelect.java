package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.vo;

@WebServlet("/moneySelect")
public class moneySelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public moneySelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		ArrayList<vo> moneyList = dao.moneySelect();
		
		request.setAttribute("moneyList", moneyList);
		request.getRequestDispatcher("/moneySelect.jsp").forward(request, response);
	}

}
