package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ALLDAO;

/**
 * Servlet implementation class emp_insert
 */
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
		String emp_no, emp_name, dep_code, hire_date, job;
		ALLDAO dao = new ALLDAO();
		int salary;
		
		emp_no = request.getParameter("emp_no");
		emp_name = request.getParameter("emp_name");
		dep_code = request.getParameter("dep_code");
		hire_date = request.getParameter("hire_date");
		job = request.getParameter("job");
		salary = Integer.valueOf(request.getParameter("salary"));
		
		int n = dao.empInsert(emp_no, emp_name, dep_code, hire_date, job, salary);
		
		if(n>0) {
			int s = dao.workInsert(emp_no);
			if(s>0) {
				request.removeAttribute("/empList");
			}
		} else {
			request.removeAttribute("/emp_insert.jsp");
		}
	}

}
