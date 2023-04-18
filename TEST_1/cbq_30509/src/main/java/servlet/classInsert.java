package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllDAO;

@WebServlet("/classInsert")
public class classInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public classInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		AllDAO dao = new AllDAO();
		String regist_month, c_no, class_area, tuition, n = null;
		int teacher_code = 0;
		
		regist_month = request.getParameter("date");
		c_no = request.getParameter("memberNum");
		class_area = request.getParameter("add");
		teacher_code =Integer.valueOf(request.getParameter("price"));
		tuition = request.getParameter("className");
		
		switch (tuition) {
			case "초급반": n = "100"; break;
			case "중급반": n = "200"; break;
			case "고급반": n = "300"; break;
			case "심화반": n = "400"; break;
			default: n = "?"; break;
		}
		
		int num = dao.classInsert(regist_month, c_no, class_area, n, teacher_code);
		
		if(num>0)
			response.sendRedirect("/userList");
		else
			System.out.println("수강신청 실패");
	}

}
