package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mainDAO;

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		mainDAO dao = new mainDAO();
		
		String emp_no;
		int absence, night, holiday, business_trip;
		
		emp_no = request.getParameter("emp_no");
		absence = Integer.valueOf(request.getParameter("absence"));
		night = Integer.valueOf(request.getParameter("night"));
		holiday = Integer.valueOf(request.getParameter("holiday"));
		business_trip = Integer.valueOf(request.getParameter("business_trip"));
		
		int n = dao.update(emp_no, absence, night, holiday, business_trip);
		
		if(n>0)
			response.sendRedirect("/empList");
	}

}
