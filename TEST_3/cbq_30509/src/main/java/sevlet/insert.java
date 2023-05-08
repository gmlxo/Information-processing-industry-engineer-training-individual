package sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mainDAO;

@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		mainDAO dao = new mainDAO();
		
		String telno, visitdate, vissittime, shopno;
		
		telno = request.getParameter("telno");
		visitdate = request.getParameter("visitdate");
		vissittime = request.getParameter("vissittime");
		shopno = request.getParameter("shopno");
		
		int n = dao.insertVISIT(telno, visitdate, vissittime, shopno);
		
		if(n>0)
			response.sendRedirect("/index.jsp");
		else 
			response.sendRedirect("/insert.jsp");
	}
}
