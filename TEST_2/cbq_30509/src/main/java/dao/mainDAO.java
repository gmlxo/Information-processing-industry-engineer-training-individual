package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.jdbcUtil;
import vo.depListVO;
import vo.departmentVO;
import vo.joinListVO;

public class mainDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public int empInsert(String emp_no, String emp_name, String dept_code, String hire_date, String job, int salary) {
		int n = 0;
		sql = "insert into TBL_EMPLOYEE_202205__GMLXO values (?, ?, ?, ?, ?, ?)";
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_no);
			pstmt.setString(2, emp_name);
			pstmt.setString(3, dept_code);
			pstmt.setString(4, hire_date);
			pstmt.setString(5, job);
			pstmt.setInt(6, salary);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int workInsert(String emp_no) {
		int n = 0;
		sql = "insert into TBL_WORK_202205__GMLXO values (?, 0, 0, 0, 0)";
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_no);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public int update(String emp_no, int absence, int night, int holiday, int business_trip) {
		int n = 0;
		sql = "update tbl_work_202205__gmlxo set absence=?, night=?, holiday=?, business_trip=? where emp_no=?";
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, absence);
			pstmt.setInt(2, night);
			pstmt.setInt(3, holiday);
			pstmt.setInt(4, business_trip);
			pstmt.setString(5, emp_no);
			
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public ArrayList<joinListVO> joinList() {
		ArrayList<joinListVO> joinList = new ArrayList<>();
		joinListVO vo;
		sql = "select\r\n"
				+ "		e.emp_no,\r\n"
				+ "		e.emp_name,\r\n"
				+ "		to_char(to_date(e.hire_date, 'yyyymmdd'), 'yyyy\"-\"mm\"-\"dd') as hire_date,\r\n"
				+ "		d.dept_name,\r\n"
				+ "		e.job,\r\n"
				+ "		w.absence,\r\n"
				+ "		w.night,\r\n"
				+ "		w.holiday,\r\n"
				+ "		w.business_trip,\r\n"
				+ "		to_char(e.salary, '999,999,999') as salary \r\n"
				+ "from tbl_employee_202205__gmlxo e, tbl_work_202205__gmlxo w, tbl_department_202205__gmlxo d\r\n"
				+ "where e.emp_no = w.emp_no and e.dept_code = d.dept_code\r\n"
				+ "order by e.emp_no asc";
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new joinListVO();
				vo.setEmp_no(rs.getString("emp_no"));
				vo.setEmp_name(rs.getString("emp_name"));
				vo.setHire_date(rs.getString("hire_date"));
				vo.setDept_name(rs.getString("dept_name"));
				vo.setJob(rs.getString("job"));
				vo.setAbsence(rs.getInt("absence"));
				vo.setNight(rs.getInt("night"));
				vo.setHoliday(rs.getInt("holiday"));
				vo.setBusiness_trip(rs.getInt("business_trip"));
				vo.setSalary(rs.getString("salary"));
				
				joinList.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, pstmt, rs);
		}
		return joinList;
	}
	
	public ArrayList<departmentVO> depList(String emp_no) {
		ArrayList<departmentVO> depList = new ArrayList<>();
		departmentVO vo;
		sql = "select * from tbl_work_202205__gmlxo where emp_no=?";
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new departmentVO();
				
				vo.setEmp_no(rs.getString("emp_no"));
				vo.setAbsence(rs.getInt("absence"));
				vo.setNight(rs.getInt("night"));
				vo.setHoliday(rs.getInt("holiday"));
				vo.setBusiness_trip(rs.getInt("business_trip"));
				
				depList.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, pstmt, rs);
		}
		return depList;
	}
	
	public ArrayList<depListVO> depJoinList() {
		ArrayList<depListVO> depList = new ArrayList<>();
		depListVO vo;
		sql = "select \r\n"
				+ "		d.dept_code,\r\n"
				+ "		d.dept_name,\r\n"
				+ "		d.location,\r\n"
				+ "		count(e.dept_code) as sum,\r\n"
				+ "		to_char(SUM(e.salary), '999,999,999') as salary,\r\n"
				+ "		to_char(((SUM(w.absence * -1) + SUM(w.night * 2) + SUM(w.holiday * 4) + SUM(w.business_trip * 3))*10000), '999,999,999') as subang,\r\n"
				+ "		to_char(SUM(e.salary)+((SUM(w.absence * -1) + SUM(w.night * 2) + SUM(w.holiday * 4) + SUM(w.business_trip * 3))*10000), '999,999,999') as allSUM\r\n"
				+ "from TBL_DEPARTMENT_202205__GMLXO d, TBL_EMPLOYEE_202205__GMLXO e, tbl_work_202205__gmlxo w\r\n"
				+ "where d.dept_code = e.dept_code and e.emp_no = w.emp_no\r\n"
				+ "group by d.dept_code, d.dept_name, d.location\r\n"
				+ "order by d.dept_code asc";
		
		try {
			conn = jdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new depListVO();
				
				vo.setDept_code(rs.getString("dept_code"));
				vo.setDept_name(rs.getString("dept_name"));
				vo.setLocation(rs.getString("location"));
				vo.setSum(rs.getString("sum"));
				vo.setSalary(rs.getString("salary"));
				vo.setSubang(rs.getString("subang"));
				vo.setAllSUM(rs.getString("allSUM"));
				
				depList.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, pstmt, rs);
		}
		return depList;
	}
}
