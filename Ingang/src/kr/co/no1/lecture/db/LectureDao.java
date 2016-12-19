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
	ArrayList<Classes> classList;
	ArrayList<Lecture> lectureList;
	Classes cl;
	
	//������ �޼���
	public LectureDao() {
		System.out.println("---�����ڸ޼��� LectureDao---");
		try {
			Context init = new InitialContext();
			System.out.println(init + "<-- init LectureDao() ");
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			System.out.println(ds + "<-- ds LectureDao() ");
		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	
	//��ü ���� ����Ʈ �������� �޼���
	public ArrayList<Classes> classList() throws ClassNotFoundException, SQLException {
		System.out.println("01 ��class ��ȸ �޼��� ���� LectureDao.java");
		classList = new ArrayList<Classes>();
		System.out.println(classList + "<-- classList");
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
			
			classList.add(cl); // ArrayList��ü���� Member��ü �ּҰ��� index 0�� ���� �߰�
			System.out.println(classList + "<-- alm 222");
		}
		close();
		return classList;
	}
	
	//�ϳ��� ������ ���� ���� ����Ʈ ��ȸ �޼���
	public ArrayList<Lecture> oneClassLectures(String classCode) throws ClassNotFoundException, SQLException {
		System.out.println("02 �ϳ��� Ŭ������ �ش�Ǵ� ���ǵ� ��ȸ �޼��� ���� LectureDao.java");
		lectureList = new ArrayList<Lecture>();
		System.out.println("lectureList : "+lectureList);
		conn = ds.getConnection();

		pstmt = conn.prepareStatement("select * from lecture where class_code=?");
		pstmt.setString(1, classCode);
		rs = pstmt.executeQuery();
		Lecture le = null;
		while (rs.next()) {
			le = new Lecture();
			le.setLectureCode(rs.getString("lecture_code"));
			le.setClassCode(rs.getString("class_code"));
			le.setLectureName(rs.getString("lecture_name"));
			le.setLectureDetail(rs.getString("lecture_detail"));
			le.setLectureFile(rs.getString("lecture_file"));
			le.setLectureRd(rs.getString("lecture_rd"));
			
			lectureList.add(le); // ArrayList��ü���� Member��ü �ּҰ��� index 0�� ���� �߰�
		}
		System.out.println("lectureList : "+lectureList);
		close();
		return lectureList;
	}
	
	public void close(){
		if (rs != null)	try { rs.close();} catch (SQLException ex) {}
		if (pstmt != null) try { pstmt.close();	} catch (SQLException ex) {}
		if (conn != null) try {	conn.close(); } catch (SQLException ex) {}
	}
}
