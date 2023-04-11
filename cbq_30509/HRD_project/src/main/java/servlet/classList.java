package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;
import VO.memberVO;
import VO.teacherVO;

@WebServlet("/classList")
public class classList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public classList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao dao = new dao();
		ArrayList<teacherVO> tList = dao.getTeacherList();
		ArrayList<memberVO> mList = dao.getMemberList();
		
		request.setAttribute("teacherList", tList);
		request.setAttribute("memberList", mList);
		request.getRequestDispatcher("/teacher/insert.jsp").forward(request, response);
	}
}
