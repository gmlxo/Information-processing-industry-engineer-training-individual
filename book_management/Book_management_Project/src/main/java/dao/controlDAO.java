package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtil;
import vo.mem_vo;
import vo.mem_rent_vo;

public class controlDAO {
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	
	public int mem_update(int custno, String custname, char grade, String address) {
		int n = 0;
		
		try {
			sql = "update mem_tbl_book set custno=?, custname=?, grade=?, address=?";
			pstmt = conn.prepareStatement(sql);
			
			n = pstmt.executeUpdate();
			
			if(n>0) 
				System.out.println("update 성공");
			else 
				System.out.println("update 실패");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error");
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return n;
	}
	
	public ArrayList<mem_vo> select_mem() {
		ArrayList<mem_vo> memList = new ArrayList<>();
		mem_vo vo;
		
		try {
			sql = "select custno, custname, joindate, DECODE('a', ' VIP', 'b', '일반', 'c', '직원')grade, address from mem_tbl_book";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new mem_vo();
				
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setAddress(rs.getString("address"));
				
				memList.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return memList;
	}
	
	public ArrayList<mem_rent_vo> rent_select(int custno) {
		ArrayList<mem_rent_vo> rentList = new ArrayList<>();
		mem_rent_vo vo;
		String numSQL = "SELECT COUNT(*) n FROM rent_tbl_book WHERE custno = ?";
		ResultSet rs1 = null;
		
		try {
			sql = "select custno, custname from mem_tbl_book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo = new mem_rent_vo();
				pstmt = conn.prepareStatement(numSQL);
				rs1 = pstmt.executeQuery();
				
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setNum(rs1.getInt("n"));
				
				rentList.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error");
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
			try {
				rs1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rentList;
	}
}
