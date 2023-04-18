package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllDAO;
import vo.TeacherVO;

@WebServlet("/teacherList")
public class teacherList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllDAO dao = new AllDAO();
		ArrayList<TeacherVO> TList = dao.teacherList();
		
		request.setAttribute("teacherList", TList);
		request.getRequestDispatcher("/teacherSelect.jsp").forward(request, response);
	}
}
