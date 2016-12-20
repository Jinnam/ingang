package kr.co.no1.lecture.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LectureDao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 생성자 메서드
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

	// 전체 과정 리스트 가져오는 메서드
	public List<Classes> classList() {
		System.out.println("classList() LectureDao.java");
		ArrayList<Classes> classList = new ArrayList<Classes>();
		System.out.println(classList + "<-- classList");
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return classList;
	}

	// 하나의 과정에 따른 강의 리스트 조회 메서드
	public List<Lecture> oneClassLectures(String classCode) {
		System.out.println("oneClassLectures() 진입 LectureDao.java");
		ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
		System.out.println("lectureList : " + lectureList);
		try {
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
			System.out.println("lectureList : " + lectureList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return lectureList;
	}

	// 하나의 과정정보 가져오기
	public Classes selectOneClass(String classCode) {
		System.out.println("selectOneClass() 진입 LectureDao.java");
		Classes classes = new Classes();
		System.out.println(classes + "<-- classes");
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return classes;
	}

	// 패키지 과정 리스트 가져오기 메서드
	public List<Classes> packageClassList(String classCode) {
		System.out.println("packageClassList() 진입 LectureDao.java");
		ArrayList<Classes> classList = new ArrayList<Classes>();
		System.out.println(classList + "<-- classList");
		try {
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
			for (int i = 0; i < clCodeList.size(); i++) {
				pstmt = conn.prepareStatement("select * from class where class_code=?");
				pstmt.setString(1, clCodeList.get(i).getClassCode());
				rs = pstmt.executeQuery();
				while (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return classList;
	}

	// 과정등록 메서드
	public int classInsert(Classes classes) {
		System.out.println("classInsert() 진입 LectureDao.java");
		String classCode = makeCode("class");
		System.out.println("classCode : "+classCode);
		int rowCount = 0;
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return 0;
	}
	
	//코드생성하는 메서드
	private String makeCode(String kind){
		System.out.println("makeCode() 진입 LectureDao.java");
		String madeClassCode = null;
		String table = null;
		switch(kind){
			case "class" :
				madeClassCode = "cc";
				table = "class";
				break;
			case "lecture" :
				madeClassCode = "lc";
				table = "lecture";
				break;
				
			default : break;
		}
		//현재날짜를 가져와서 원하는 포멧으로 바꾸꿈
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		System.out.println(dTime);
		
		madeClassCode += dTime;
		System.out.println("madeClassCode : " + madeClassCode);
		//오늘날짜로 등록된게 몇개인지 받아와서 1을 더해줌
		int codeNo = checkRd(table)+1;
		System.out.println("codeNo : "+codeNo);
		//받아온 개수를 4자리수 문자열로 변환
		String resultCodeNo = String.format("%04d", codeNo);
		madeClassCode += resultCodeNo;
		System.out.println("madeClassCode : " + madeClassCode);
		
		
		return madeClassCode;
	}
	
	//오늘날짜 기준으로 등록된 날짜가 있는지 확인하는 메서드
	private int checkRd(String table){
		System.out.println("checkRd() 진입 LectureDao.java");
		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		System.out.println(dTime);
		int count = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select count(*) from "+table+" where class_rd=?");
			pstmt.setString(1, dTime);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return count;
	}

	// 객체 반납
	public void close() {
		if (rs != null)	try {rs.close();} catch (SQLException ex) {	}
		if (pstmt != null)	try {pstmt.close();	} catch (SQLException ex) {	}
		if (conn != null)	try {conn.close();	} catch (SQLException ex) {	}
	}
}
