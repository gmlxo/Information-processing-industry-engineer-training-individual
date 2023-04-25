package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ALLDAO;
import vo.empListVO;


@WebServlet("/empList")
public class empList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public empList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ALLDAO dao = new ALLDAO();
		ArrayList<empListVO> eList = dao.empList();
		
		request.setAttribute("empList", eList);
		request.getRequestDispatcher("/empList.jsp").forward(request, response);;
	}
}
