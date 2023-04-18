package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllDAO;
import vo.userVO;

@WebServlet("/userList")
public class userList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public userList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AllDAO dao = new AllDAO();
		
		ArrayList<userVO> list = dao.userList();
		
		request.setAttribute("userList", list);
		request.getRequestDispatcher("/userList.jsp").forward(request, response);
	}
}