package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

@WebServlet("/memberInsert")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO vo = new MemberVO();
		vo.setCustno(Integer.parseInt(request.getParameter("custno")));
		vo.setCustname(request.getParameter("custname"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("addr"));
		vo.setJoindate(Date.valueOf(request.getParameter("joindate")));
		vo.setGrade(request.getParameter("grade"));
		vo.setCity(request.getParameter("city"));
		
		MemberDAO dao = new MemberDAO();
		int result = dao.memberInsert(vo);
		
		if(result>0) {
			response.sendRedirect("/memberSelect");
		}else {
			response.sendRedirect("/memberInsert.jsp?custno=?"+vo.getCustno());
		}
	}
}
