package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mainDAO;

@WebServlet("/emp_insert")
public class emp_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public emp_insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		mainDAO dao = new mainDAO();
		String emp_no, emp_name, dept_code, hire_date, job;
		int salary;
		
		emp_no = request.getParameter("emp_no");
		emp_name = request.getParameter("emp_name");
		dept_code = request.getParameter("dept_code");
		hire_date = request.getParameter("hire_date");
		job = request.getParameter("job");
		salary = Integer.valueOf(request.getParameter("salary"));
		
		int n = dao.empInsert(emp_no, emp_name, dept_code, hire_date, job, salary);
	
		if(n>0) {
			int s = dao.workInsert(emp_no);
			if(s>0)
				response.sendRedirect("/empList");
		} else
			response.sendRedirect("/emp_insert.jsp");
	}

}
