package kr.co.no1.lecture.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LectureDao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// ������ �޼���
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

	// ��ü ���� ����Ʈ �������� �޼���
	public ArrayList<Classes> classList() {
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
	
				classList.add(cl); // ArrayList��ü���� Member��ü �ּҰ��� index 0�� ���� �߰�
			}
			System.out.println(classList + "<-- classList");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return classList;
	}

	// �ϳ��� ������ ���� ���� ����Ʈ ��ȸ �޼���
	public ArrayList<Lecture> oneClassLectures(String classCode) {
		System.out.println("oneClassLectures() ���� LectureDao.java");
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
	
				lectureList.add(le); // ArrayList��ü���� Member��ü �ּҰ��� index 0�� ���� �߰�
			}
			System.out.println("lectureList : " + lectureList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return lectureList;
	}

	// �ϳ��� �������� ��������
	public Classes selectOneClass(String classCode) {
		System.out.println("selectOneClass() ���� LectureDao.java");
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

	// ��Ű�� ���� ����Ʈ �������� �޼���
	public ArrayList<Classes> packageClassList(String classCode) {
		System.out.println("packageClassList() ���� LectureDao.java");
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
				clCodeList.add(cl); // ArrayList��ü���� Member��ü �ּҰ��� index 0�� ���� �߰�
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

	// ������� �޼���
	public int classInsert(Classes classes) {
		System.out.println("classInsert() ���� LectureDao.java");
		String classCode = "cc";
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		System.out.println(dTime);
		classCode += dTime;
		System.out.println("classCode : " + classCode);
		
		int codeNo = 1;
		
		String resultCodeNo = String.format("%04d", codeNo);
		classCode += resultCodeNo;
		System.out.println("classCode : " + classCode);

		
		return 0;
	}
	
	//���� �������� ��ϵ� ��¥�� �ִ��� Ȯ���ϴ� �޼���
	public int checkRd(){
		System.out.println("checkRd() ���� LectureDao.java");
		
		
		return 0;
	}

	// ��ü �ݳ�
	public void close() {
		if (rs != null)	try {rs.close();} catch (SQLException ex) {	}
		if (pstmt != null)	try {pstmt.close();	} catch (SQLException ex) {	}
		if (conn != null)	try {conn.close();	} catch (SQLException ex) {	}
	}
}
