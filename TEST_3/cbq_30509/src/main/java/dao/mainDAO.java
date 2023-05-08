package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.bshopJoinListVO2;
import vo.bshopJoinVO;
import vo.testJoinVO;

public class mainDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	public int insertVISIT(String telno, String visitdate, String vissittime, String shopno) {
		int n = 0;
		sql = "insert into TBL_VISIT_202101 values (?, ?, ?, ?)";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, telno);
			pstmt.setString(2, visitdate);
			pstmt.setString(3, vissittime);
			pstmt.setString(4, shopno);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		
		return n;
	}
	
	public ArrayList<testJoinVO> testJoinList() {
		ArrayList<testJoinVO> testList = new ArrayList<testJoinVO>();
		testJoinVO vo;
		sql = "select \r\n"
				+ "		t.testno,\r\n"
				+ "		j.name,\r\n"
				+ "		substr(j.jumin, 0, 6) || '-' || substr(j.jumin, 6, 7) as jumin,\r\n"
				+ "		substr(j.jumin, 7, 1) as man,\r\n"
				+ "		j.city,\r\n"
				+ "		j.telno,\r\n"
				+ "		t.testresult\r\n"
				+ "from TBL_TEST_202101 t, tbl_jumin_202101 j\r\n"
				+ "where t.telno = j.telno\r\n"
				+ "order by t.testno";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new testJoinVO();
				
				vo.setTestno(rs.getString("testno"));
				vo.setName(rs.getString("name"));
				vo.setJumin(rs.getString("jumin"));
				vo.setMan(rs.getString("man"));
				vo.setCity(rs.getString("city"));
				vo.setTelno(rs.getString("telno"));
				vo.setTestresult(rs.getString("testresult"));
				
				testList.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return testList;
	}
	
	public ArrayList<bshopJoinVO> bshopJoinList() {
		ArrayList<bshopJoinVO> bshopList = new ArrayList<>();
		bshopJoinVO vo;
		sql = "select \r\n"
				+ "		v.telno,\r\n"
				+ "		to_char(to_date(v.visitdate, 'yyyymmdd'), 'yyyy\"년 \"mm\"월 \"dd\"일 \"') as visitdate,\r\n"
				+ "		substr(v.vissittime, 0, 2) || ':' || substr(v.vissittime, 3, 2) as vissittime,\r\n"
				+ "		b.site,\r\n"
				+ "		b.shopname,\r\n"
				+ "		b.shoptelno\r\n"
				+ "from TBL_BSHOP_202101 b, TBL_VISIT_202101 v\r\n"
				+ "where b.shopno = v.shopno\r\n"
				+ "order by v.telno asc";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new bshopJoinVO();
				
				vo.setTelno(rs.getString("telno"));
				vo.setVisitdate(rs.getString("visitdate"));
				vo.setVissittime(rs.getString("vissittime"));
				vo.setSite(rs.getString("site"));
				vo.setShopname(rs.getString("shopname"));
				vo.setShoptelno(rs.getString("shoptelno"));
				
				bshopList.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return bshopList;
	}
	
	public ArrayList<bshopJoinListVO2> bshopJoinList2() {
		ArrayList<bshopJoinListVO2> bshopList = new ArrayList<>();
		bshopJoinListVO2 vo;
		sql = "select \r\n"
				+ "		b.shopno,\r\n"
				+ "		b.shopname,\r\n"
				+ "		count(v.telno) as num\r\n"
				+ "from TBL_BSHOP_202101 b, TBL_VISIT_202101 v\r\n"
				+ "where b.shopno = v.shopno\r\n"
				+ "group by b.shopno, b.shopname\r\n"
				+ "order by b.shopno";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new bshopJoinListVO2();
				
				vo.setShopno(rs.getString("shopno"));
				vo.setShopname(rs.getString("shopname"));
				vo.setNum(rs.getInt("num"));
				
				bshopList.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return bshopList;
	}
}
