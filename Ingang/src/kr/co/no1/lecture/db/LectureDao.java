package kr.co.no1.lecture.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LectureDao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<Classes> list;
	Classes cl;

	public LectureDao() {
		System.out.println("---생성자메서드 LectureDao---");
		try {
			Context init = new InitialContext();
			System.out.println(init + "<-- init LectureDao() ");
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			System.out.println(ds + "<-- ds LectureDao() ");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}

	public ArrayList<Classes> classList() throws ClassNotFoundException, SQLException {
		System.out.println("01 전class 조회 메서드 선언 LectureDao.java");
		list = new ArrayList<Classes>();
		System.out.println(list + "<-- alm 111");
		conn = ds.getConnection();

		pstmt = conn.prepareStatement("select * from class");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			cl = new Classes();
			cl.setClassCode(rs.getString("class_code"));
			cl.setInstructorCode(rs.getString("instructor_code"));
			cl.setClassName(rs.getString("class_name"));
			cl.setClassLevel(rs.getString("class_level"));
			cl.setClassCategory(rs.getString("class_category"));
			cl.setClassPeoriod(rs.getInt("class_peoriod"));
			cl.setClassPrice(rs.getInt("class_price"));
			cl.setDiscount(rs.getInt("discount"));
			cl.setClassNumber(rs.getInt("class_number"));
			cl.setClassRd(rs.getString("class_rd"));
			cl.setClassDetail(rs.getString("class_detail"));
			cl.setSoldNumber(rs.getInt("sold_number"));
			cl.setSoldAmount(rs.getInt("sold_amount"));
			cl.setGradeAverage(rs.getFloat("grade_average"));
			
			list.add(cl); // ArrayList객체내에 Member객체 주소값을 index 0번 부터 추가
			System.out.println(list + "<-- alm 222");
		}
		close();
		return list;
	}
	
	public void close(){
		if (rs != null)	try { rs.close();} catch (SQLException ex) {}
		if (pstmt != null) try { pstmt.close();	} catch (SQLException ex) {}
		if (conn != null) try {	conn.close(); } catch (SQLException ex) {}
	}
}
