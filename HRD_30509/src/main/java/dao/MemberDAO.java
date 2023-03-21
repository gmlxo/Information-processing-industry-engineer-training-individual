package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCUtil;
import vo.MemberVO;
import vo.vo;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<MemberVO> memberSelect() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		conn = JDBCUtil.getConnection();
		String sql = "select custno, custname, phone, address, joindate, \r\n"
				+ "decode(grade, 'A', 'VIP', 'B', '일반', 'C', '직원') grade,\r\n"
				+ "decode(city, '01', '서울', '10', '인천', '20', '성남', '30', '대전', '40', '광주', '60', '부산') city\r\n"
				+ "from member_tbl_02 order by custno";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}

		return list;
	}

	public ArrayList<vo> moneySelect() {
		ArrayList<vo> list = new ArrayList<vo>();
		conn = JDBCUtil.getConnection();
		String sql = "select a.custno, a.custname, decode(a.grade, 'A', 'VIP', 'B', '일반', 'C','직원') grade, SUM(price) price\r\n"
				+ "from member_tbl_02 a, money_tbl_02 b\r\n"
				+ "where a.custno=b.custno\r\n"
				+ "group by a.custno, a.custname, a.grade\r\n"
				+ "order by price desc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				vo vo = new vo();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setGrade(rs.getString("grade"));
				vo.setPrice(rs.getInt("price"));	
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		return list;
	}

	public int getMaxNo() {
		int n = 0;

		conn = JDBCUtil.getConnection();
		String sql = "select max(custno)+1 n from member_tbl_02";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				n = rs.getInt("n");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}

		return n;
	}

	public int memberInsert(MemberVO vo) {
		int result = 0;

		conn = JDBCUtil.getConnection();
		String sql = "insert into member_tbl_02 values(?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getCustno());
			ps.setString(2, vo.getCustname());
			ps.setString(3, vo.getPhone());
			ps.setString(4, vo.getAddress());
			ps.setDate(5, vo.getJoindate());
			ps.setString(6, vo.getGrade());
			ps.setString(7, vo.getCity());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps);
		}
		return result;
	}

	public MemberVO getMemberSelect(int custno) {
		MemberVO vo = new MemberVO();

		conn = JDBCUtil.getConnection();
		String sql = "select custno, custname, phone, address, joindate, grade, city  from member_tbl_02 where custno=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, custno);

			rs = ps.executeQuery();

			while (rs.next()) {
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		return vo;
	}

	public int memberUpdate(MemberVO vo) {
		int result = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		conn = JDBCUtil.getConnection();
		String sql = "update member_tbl_02 set custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getCustname());
			ps.setString(2, vo.getPhone());
			ps.setString(3, vo.getAddress());
			ps.setDate(4, vo.getJoindate());
			ps.setString(5, vo.getGrade());
			ps.setString(6, vo.getCity());
			ps.setInt(7, vo.getCustno());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps);
		}
		return result;
	}
}
