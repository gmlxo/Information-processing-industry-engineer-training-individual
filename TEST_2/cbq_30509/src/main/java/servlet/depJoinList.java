package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mainDAO;
import vo.depListVO;

@WebServlet("/depJoinList")
public class depJoinList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public depJoinList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		mainDAO dao = new mainDAO();
		
		ArrayList<depListVO> depList = dao.depJoinList();
		
		request.setAttribute("joinList_det", depList);
		request.getRequestDispatcher("/depJoinList.jsp").forward(request, response);
	}
}
