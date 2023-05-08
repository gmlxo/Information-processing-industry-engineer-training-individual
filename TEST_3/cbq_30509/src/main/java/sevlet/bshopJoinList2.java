package sevlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mainDAO;
import vo.bshopJoinListVO2;

@WebServlet("/bshopJoinList2")
public class bshopJoinList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bshopJoinList2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		mainDAO dao = new mainDAO();
		
		ArrayList<bshopJoinListVO2> list2 = dao.bshopJoinList2();
		
		request.setAttribute("bshopJoinList2", list2);
		request.getRequestDispatcher("/bshopJoinList2.jsp").forward(request, response);
	}
}
