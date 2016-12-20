package kr.co.no1.instructor.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class InstructorDao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 생성자 메서드
	public InstructorDao() {
		System.out.println("---생성자메서드 InstructorDao---");
		try {
			Context init = new InitialContext();
			System.out.println(init + "<-- init InstructorDao() ");
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			System.out.println(ds + "<-- ds InstructorDao() ");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//강사 전체 리스트
	public List<Instructor> instructorList(){
		System.out.println("instructorList() 진입 InstructorDao.java");
		ArrayList<Instructor> list = new ArrayList<Instructor>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select * from instructor");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Instructor instructor = new Instructor();
				instructor.setInstructorCode(rs.getString("instructor_code"));
				instructor.setInstructorName(rs.getString("instructor_name"));
				instructor.setInstructorDetail(rs.getString("instructor_detail"));
				instructor.setInstructorImage(rs.getString("instructor_image"));
				
				list.add(instructor);
			}
			System.out.println("instructor list : "+list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return list;
	}
	
	//강사 한명
	public Instructor selectOneInstructor(String instructroCode){
		System.out.println("selectOneInstructor() 진입 InstructorDao.java");
		Instructor instructor = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select * from instructor where instructor_code=?");
			pstmt.setString(1, instructroCode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				instructor = new Instructor();
				instructor.setInstructorCode(rs.getString("instructor_code"));
				instructor.setInstructorName(rs.getString("instructor_name"));
				instructor.setInstructorDetail(rs.getString("instructor_detail"));
				instructor.setInstructorImage(rs.getString("instructor_image"));
			}
			System.out.println("instructor : "+instructor);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return instructor;
	}
	
	// 객체 반납
	public void close() {
		if (rs != null)	try {rs.close();} catch (SQLException ex) {	}
		if (pstmt != null)	try {pstmt.close();	} catch (SQLException ex) {	}
		if (conn != null)	try {conn.close();	} catch (SQLException ex) {	}
	}
}
