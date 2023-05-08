package sevlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mainDAO;
import vo.bshopJoinVO;

@WebServlet("/bshopJoinList")
public class bshopJoinList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bshopJoinList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		mainDAO dao = new mainDAO();
		ArrayList<bshopJoinVO> bshopList = dao.bshopJoinList();
		
		request.setAttribute("bshoplist", bshopList);
		request.getRequestDispatcher("/bshopJoinList.jsp").forward(request, response);
	}
}
