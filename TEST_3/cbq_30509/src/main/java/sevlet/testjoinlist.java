package sevlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mainDAO;
import vo.testJoinVO;

@WebServlet("/testjoinlist")
public class testjoinlist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public testjoinlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		mainDAO dao = new mainDAO();
		ArrayList<testJoinVO> list = dao.testJoinList();
		
		request.setAttribute("testjoin", list);
		request.getRequestDispatcher("/testjoinlist.jsp").forward(request, response);
	}


}
