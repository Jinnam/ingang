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
	
	//생성자 메서드
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
	
	//전체 과정 리스트 가져오는 메서드
	public ArrayList<Classes> classList() throws ClassNotFoundException, SQLException {
		System.out.println("01 전class 조회 메서드 진입 LectureDao.java");
		ArrayList<Classes> classList = new ArrayList<Classes>();
		System.out.println(classList + "<-- classList");
		conn = ds.getConnection();

		pstmt = conn.prepareStatement("select * from class");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Classes cl = new Classes();
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
			
			classList.add(cl); // ArrayList객체내에 Member객체 주소값을 index 0번 부터 추가
		}
		System.out.println(classList + "<-- classList");
		close();
		return classList;
	}
	
	//하나의 과정에 따른 강의 리스트 조회 메서드
	public ArrayList<Lecture> oneClassLectures(String classCode) throws ClassNotFoundException, SQLException {
		System.out.println("02 하나의 클래스에 해당되는 강의들 조회 메서드 진입 LectureDao.java");
		ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
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
			
			lectureList.add(le); // ArrayList객체내에 Member객체 주소값을 index 0번 부터 추가
		}
		System.out.println("lectureList : "+lectureList);
		close();
		return lectureList;
	}
	
	//하나의 과정정보 가져오기
	public Classes selectOneClass(String classCode) throws ClassNotFoundException, SQLException {
		System.out.println("03 하나의 과정 조회 메서드 진입 LectureDao.java");
		Classes classes = new Classes();
		System.out.println(classes + "<-- classes");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("select * from class where class_code=?");
		pstmt.setString(1, classCode);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			classes.setClassCode(rs.getString("class_code"));
			classes.setInstructorCode(rs.getString("instructor_code"));
			classes.setClassName(rs.getString("class_name"));
			classes.setClassLevel(rs.getString("class_level"));
			classes.setClassCategory(rs.getString("class_category"));
			classes.setClassPeoriod(rs.getInt("class_peoriod"));
			classes.setClassPrice(rs.getInt("class_price"));
			classes.setDiscount(rs.getInt("discount"));
			classes.setClassNumber(rs.getInt("class_number"));
			classes.setClassRd(rs.getString("class_rd"));
			classes.setClassDetail(rs.getString("class_detail"));
			classes.setSoldNumber(rs.getInt("sold_number"));
			classes.setSoldAmount(rs.getInt("sold_amount"));
			classes.setGradeAverage(rs.getFloat("grade_average"));
			
			System.out.println(classes + "<--classList");
		}
		close();
		return classes;
	}
	
	//패키지 과정 리스트 가져오기 메서드
	public ArrayList<Classes> packageClassList(String classCode) throws ClassNotFoundException, SQLException {
		System.out.println("04 패키지 과정 리스트 조회 메서드 진입 LectureDao.java");
		ArrayList<Classes> classList = new ArrayList<Classes>();
		System.out.println(classList + "<-- classList");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("select * from package where class_set=?");
		pstmt.setString(1, classCode);
		rs = pstmt.executeQuery();
		ArrayList<Classes> clCodeList = new ArrayList<Classes>();
		while (rs.next()) {
			Classes cl = new Classes();
			cl.setClassCode(rs.getString("class_one"));
			clCodeList.add(cl); // ArrayList객체내에 Member객체 주소값을 index 0번 부터 추가
			System.out.println(clCodeList + "<-- classList");
		}
		for(int i = 0; i<clCodeList.size();i++){
			pstmt = conn.prepareStatement("select * from class where class_code=?");
			pstmt.setString(1, clCodeList.get(i).getClassCode());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Classes classes = new Classes();
				classes.setClassCode(rs.getString("class_code"));
				classes.setInstructorCode(rs.getString("instructor_code"));
				classes.setClassName(rs.getString("class_name"));
				classes.setClassLevel(rs.getString("class_level"));
				classes.setClassCategory(rs.getString("class_category"));
				classes.setClassPeoriod(rs.getInt("class_peoriod"));
				classes.setClassPrice(rs.getInt("class_price"));
				classes.setDiscount(rs.getInt("discount"));
				classes.setClassNumber(rs.getInt("class_number"));
				classes.setClassRd(rs.getString("class_rd"));
				classes.setClassDetail(rs.getString("class_detail"));
				classes.setSoldNumber(rs.getInt("sold_number"));
				classes.setSoldAmount(rs.getInt("sold_amount"));
				classes.setGradeAverage(rs.getFloat("grade_average"));
				
				classList.add(classes);
			}
		}
		close();
		return classList;
	}
	
	//객체 반납
	public void close(){
		if (rs != null)	try { rs.close();} catch (SQLException ex) {}
		if (pstmt != null) try { pstmt.close();	} catch (SQLException ex) {}
		if (conn != null) try {	conn.close(); } catch (SQLException ex) {}
	}
}
