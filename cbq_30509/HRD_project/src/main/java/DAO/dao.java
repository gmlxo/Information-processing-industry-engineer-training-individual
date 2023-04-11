package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import VO.memberVO;
import VO.teacherVO;
import common.JDBCUtil;

public class dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	public ArrayList<teacherVO> getTeacherList() {
		ArrayList<teacherVO> list = new ArrayList<>();
		teacherVO vo;
		sql = "select teacher_code, class_name, teacher_name,\r\n"
				+ "	class_price, substr(teach_regist_date, 0, 4) yyyy,\r\n"
				+ "	substr(teach_regist_date, 5, 2) mm,\r\n"
				+ "	substr(teach_regist_date, 7, 2) dd\r\n"
				+ "from TBL_TEACHER_202201 order by teacher_code asc";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo = new teacherVO();
				vo.setTeacher_code(rs.getString("teacher_code"));
				vo.setClass_name(rs.getString("class_name"));
				vo.setTeacher_name(rs.getString("teacher_name"));
				vo.setClass_price(rs.getInt("class_price"));
				vo.setTeach_regist_date(rs.getString("yyyy")+ "년" + rs.getString("mm")+ "월" + rs.getString("dd")+ "일");
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public ArrayList<memberVO> getMemberList() {
		ArrayList<memberVO> list = new ArrayList<>();
		memberVO vo;
		sql = "select c_no, c_name from tbl_member_202201 order by c_no asc";
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo = new memberVO();
				vo.setC_no(rs.getString("c_no"));
				vo.setC_name(rs.getString("c_name"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
}
