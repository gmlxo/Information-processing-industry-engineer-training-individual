package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllDAO;
import vo.TeacherMoneyVO;

@WebServlet("/teacherMoneyList")
public class teacherMoneyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public teacherMoneyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AllDAO dao = new AllDAO();
		
		ArrayList<TeacherMoneyVO> moneyList = dao.moneyList();
		request.setAttribute("moneyList", moneyList);
		request.getRequestDispatcher("/moneyList.jsp").forward(request, response);
	}
}
