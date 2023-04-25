package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.departmentVO;
import vo.empListVO;
import vo.emploteeVO;

public class ALLDAO {
	
	PreparedStatement pstmt;
	Connection conn;
	ResultSet rs;
	String sql;
	
	public ArrayList<departmentVO> depList() {
		ArrayList<departmentVO> dList = new ArrayList<>();
		departmentVO dvo;
		sql = "select * from tbl_department_202205";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dvo = new departmentVO();
				
				dvo.setDept_code(rs.getString("dept_code"));
				dvo.setDept_name(rs.getString("dept_name"));
				dvo.setLocation(rs.getString("location"));
				
				dList.add(dvo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return dList;
	}
	
	public ArrayList<empListVO> empList() {
		ArrayList<empListVO> empList = new ArrayList<>();
		empListVO voList;
		sql = "select e.emp_no,\r\n"
				+ "	   e.emp_name,\r\n"
				+ "	   substr(hire_date, 0, 4) YYYY,\r\n"
				+ "	   substr(hire_date, 5, 2) MM,\r\n"
				+ "	   substr(hire_date, 7, 2) DD,\r\n"
				+ "	   e.hire_date,\r\n"
				+ "	   d.dept_name,\r\n"
				+ "	   e.job,\r\n"
				+ "	   w.absence,\r\n"
				+ "	   w.night,\r\n"
				+ "	   w.holiday,\r\n"
				+ "	   w.business_trip,\r\n"
				+ "	   to_char(e.salary, '999,999,999') salary\r\n"
				+ "from tbl_emplotee_202205 e, \r\n"
				+ "	tbl_work_202205 w, \r\n"
				+ "	tbl_department_202205 d \r\n"
				+ "where e.emp_no = w.emp_no and e.dept_code = d.dept_code\r\n"
				+ "order by e.emp_no asc";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				voList = new empListVO();
				
				voList.setEmp_no(rs.getString("emp_no"));
				voList.setEmp_name(rs.getString("emp_name"));
				voList.setHire_date(rs.getString("hire_date"));
				voList.setDept_name(rs.getString("dept_name"));
				voList.setJob(rs.getString("job"));
				voList.setAbsence(rs.getString("absence"));
				voList.setHoliday(rs.getInt("holiday"));
				voList.setBusiness_trip(rs.getInt("business_trip"));
				voList.setSalary(rs.getString("salary"));
				
				empList.add(voList);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return empList;
	}
	
	public int empInsert(String emp_no, String emp_name, String dept_code, String hire_date, String job, int salary) {
		int n = 0;
		sql = "insert into TBL_EMPLOTEE_202205 values (?, ?, ?, ?, ?, ?)";
		
		try {
			 conn = JdbcUtil.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, emp_no);
			 pstmt.setString(2, emp_name);
			 pstmt.setString(3, dept_code);
			 pstmt.setString(4, hire_date);
			 pstmt.setString(5, job); 
			 pstmt.setInt(6, salary);
			 
			 n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int workInsert(String emp_no) {
		int n = 0;
		sql = "insert into tbl_work_202205 values (?, 0, 0, 0, 0)";
		try {
			 conn = JdbcUtil.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, emp_no);
			 
			 n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
}
