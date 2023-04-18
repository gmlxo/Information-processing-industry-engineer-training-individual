package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllDAO;
import vo.MemberVO;
import vo.TeacherVO;

@WebServlet("/insertSelect")
public class insertSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public insertSelect() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AllDAO dao = new AllDAO();
		ArrayList<TeacherVO> tList = dao.teacherList();
		ArrayList<MemberVO> mList = dao.memberList();
		
		request.setAttribute("insertT", tList);
		request.setAttribute("insertM", mList);
		
		request.getRequestDispatcher("/insert.jsp").forward(request, response);
	}
}
