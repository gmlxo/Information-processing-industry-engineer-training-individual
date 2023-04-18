package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcUtil;
import servlet.teacherMoneyList;
import vo.MemberVO;
import vo.TeacherMoneyVO;
import vo.TeacherVO;
import vo.userVO;

public class AllDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public ArrayList<TeacherVO> teacherList() {
		ArrayList<TeacherVO> list = new ArrayList<>();
		TeacherVO vo;
		sql = "select \r\n"
				+ "	teacher_code, \r\n"
				+ "	class_name, \r\n"
				+ "	teacher_name, \r\n"
				+ "	class_price, \r\n"
				+ "	substr(teach_regist_date, 0, 4) yyyy, \r\n"
				+ "	substr(teach_regist_date, 5, 2) dd, \r\n"
				+ "	substr(teach_regist_date, 7, 2) mm\r\n"
				+ "from TBL_TEACHER_20221\r\n"
				+ "order by teacher_code asc";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new TeacherVO();
				
				vo.setTeacher_code(rs.getString("teacher_code"));
				vo.setClass_name(rs.getString("class_name"));
				vo.setTeacher_name(rs.getString("teacher_name"));
				vo.setClass_price(rs.getInt("class_price"));
				vo.setTeach_regist_date(
						rs.getString("yyyy") + "년" 
						+ rs.getString("dd") + "월"
						+ rs.getString("mm")+"일" );
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> list = new ArrayList<>();
		MemberVO vo;
		sql = "select * from tbl_member_202201 order by c_no asc";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new MemberVO();
				
				vo.setC_no(rs.getString("c_no"));
				vo.setC_name(rs.getString("c_name"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setRegist_date(rs.getString("regist_date"));
				vo.setC_type(rs.getString("c_type"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int classInsert(String regist_month, String c_no, String class_area, String tuition, int teacher_code) {
		int n = 0;
		sql = "insert into tbl_class_202201 values(?, ?, ?, ?, ?)";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, regist_month);
			pstmt.setString(2, c_no);
			pstmt.setString(3, class_area);
			pstmt.setInt(4, teacher_code);
			pstmt.setString(5, tuition);
			
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public ArrayList<userVO> userList() {
		ArrayList<userVO> list = new ArrayList<>();
		userVO vo;
		sql = "select \r\n"
				+ "	substr(c.regist_month, 0, 4) yyyy, \r\n"
				+ "	substr(c.regist_month, 5, 2) mm, \r\n"
				+ "	m.c_no,\r\n"
				+ "	m.c_name,\r\n"
				+ "	t.class_name,\r\n"
				+ "	t.teacher_name,\r\n"
				+ "	c.class_area,\r\n"
				+ "	c.tuition\r\n"
				+ "from tbl_member_202201 m, tbl_class_202201 c, TBL_TEACHER_20221 t \r\n"
				+ "where m.c_no = c.c_no and c.teacher_code = t.teacher_code";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new userVO();
				
				vo.setRegist_month(rs.getString("yyyy") + "년" + rs.getString("mm"));
				vo.setC_no(rs.getString("c_no"));
				vo.setC_name(rs.getString("c_name"));
				vo.setClass_name(rs.getString("class_name"));
				vo.setTeacher_name(rs.getString("teacher_name"));
				vo.setClass_area(rs.getString("class_area"));
				vo.setTuition(rs.getInt("tuition"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<TeacherMoneyVO> moneyList() {
		ArrayList<TeacherMoneyVO> list = new ArrayList<>();
		TeacherMoneyVO vo;
		sql = "select\r\n"
				+ "	t.teacher_code, \r\n"
				+ "	t.teacher_name, \r\n"
				+ "	t.class_name,\r\n"
				+ "	sum(c.tuition) tuition\r\n"
				+ "from TBL_TEACHER_20221 t, tbl_class_202201 c \r\n"
				+ "where c.teacher_code = t.teacher_code\r\n"
				+ "group by t.teacher_code, t.teacher_name, t.class_name\r\n"
				+ "order by t.teacher_code asc";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new TeacherMoneyVO();
				
				vo.setTeacher_code(rs.getString("teacher_code"));
				vo.setTeacher_name(rs.getString("teacher_name"));
				vo.setClass_name(rs.getString("class_name"));
				vo.setTuition(rs.getInt("tuition"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
}
