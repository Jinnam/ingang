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

import kr.co.no1.instructor.db.Instructor;
import kr.co.no1.instructor.db.InstructorDao;

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
				//���� ���� �����ͼ� ����(Classes) ��ü�� ��´�
				Instructor instructor = null;
				InstructorDao instructorDao = new InstructorDao();
				instructor = instructorDao.selectOneInstructor(rs.getString("instructor_code"));
				
				cl.setInstructor(instructor);
				
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
	public List<Lecture> oneClassLectures(String classCode) {
		System.out.println("oneClassLectures() ���� LectureDao.java");
		ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
		System.out.println("lectureList1 : " + lectureList);
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
			
			if(lectureList != null){
				for(int i=0; i < lectureList.size(); i++){
					Lecture lecture =lectureList.get(i);
					Classes classes = selectOneClass(lecture.getClassCode());
					if(classes != null){
						lecture.setClasses(classes);
					}
				}
			}
			System.out.println("lectureList2 : " + lectureList);
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
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select * from class where class_code=?");
			pstmt.setString(1, classCode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				classes.setClassCode(rs.getString("class_code"));
				Instructor instructor = null;
				InstructorDao instructorDao = new InstructorDao();
				instructor = instructorDao.selectOneInstructor(rs.getString("instructor_code"));
				classes.setInstructor(instructor);
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
	public List<Classes> packageClassList(String classCode) {
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
					Instructor instructor = null;
					InstructorDao instructorDao = new InstructorDao();
					instructor = instructorDao.selectOneInstructor(rs.getString("instructor_code"));
					classes.setInstructor(instructor);
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
	
	//���ǵ�� �޼���
	public int lectureInsert(Lecture lecture){
		System.out.println("lectureInsert() ���� LectureDao.java");
		String lectureCode = makeCode("lecture");
		System.out.println("lectureCode : "+lectureCode);
		int rowCount = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("insert into lecture "+
					"(lecture_code,class_code,lecture_name,lecture_detail,lecture_file,lecture_rd)"+
					" values(?,?,?,?,?,to_date(sysdate,'yy/mm/dd'))");
			pstmt.setString(1, lectureCode);
			pstmt.setString(2, lecture.getClassCode());
			pstmt.setString(3, lecture.getLectureName());
			pstmt.setString(4, lecture.getLectureDetail());
			pstmt.setString(5, "��������");
			System.out.println("pstmt : "+pstmt);
			rowCount = pstmt.executeUpdate();
			//������ class_number ��+1�ϱ�
			classNumberAdd(lecture.getClassCode());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return rowCount;
	}
	
	
	// ������� �޼���
	public int classInsert(Classes classes) {
		System.out.println("classInsert() ���� LectureDao.java");
		String classCode = makeCode("class");
		System.out.println("classCode : "+classCode);
		int rowCount = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("insert into class "+
					"(class_code,instructor_code,class_name,class_level,"+
					"class_category,class_peoriod,class_price,discount,"+
					" class_detail,class_rd,class_number) values("+
					" ?,?,?,?,?,?,?,?,?,to_date(sysdate,'yy/mm/dd'),'0')");
			pstmt.setString(1, classCode);
			pstmt.setString(2, classes.getInstructor().getInstructorCode());
			pstmt.setString(3, classes.getClassName());
			pstmt.setString(4, classes.getClassLevel());
			pstmt.setString(5, classes.getClassCategory());
			pstmt.setInt(6, classes.getClassPeoriod());
			pstmt.setInt(7, classes.getClassPrice());
			pstmt.setInt(8, classes.getDiscount());
			pstmt.setString(9, classes.getClassDetail());
			
			rowCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return rowCount;
	}
	
	//�ϳ��� �������� ���� ���� �ø���
	private void classNumberAdd(String classCode){
		System.out.println("classNumberAdd() ���� LectureDao.java");
		int classNumber = 0;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select class_number from class where class_code=? ");
			pstmt.setString(1, classCode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				classNumber = rs.getInt(1);
				System.out.println("classNumber1 : "+classNumber);
				classNumber++;
				System.out.println("classNumber2 : "+classNumber);
			}
			pstmt = conn.prepareStatement("update class set class_number=? where class_code=?");
			pstmt.setInt(1, classNumber);
			pstmt.setString(2, classCode);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		
	}

	//�ڵ�����ϴ� �޼���
	private String makeCode(String kind){
		System.out.println("makeCode() ���� LectureDao.java");
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
		//���糯¥�� �����ͼ� ���ϴ� �������� �ٲٲ�
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		System.out.println(dTime);
		
		madeClassCode += dTime;
		System.out.println("madeClassCode : " + madeClassCode);
		//���ó�¥�� ��ϵȰ� ����� �޾ƿͼ� 1�� ������
		int codeNo = checkRd(table)+1;
		System.out.println("codeNo : "+codeNo);
		//�޾ƿ� ������ 4�ڸ��� ���ڿ��� ��ȯ
		String resultCodeNo = String.format("%04d", codeNo);
		madeClassCode += resultCodeNo;
		System.out.println("madeClassCode : " + madeClassCode);
		
		
		return madeClassCode;
	}
	
	//���ó�¥ �������� ��ϵ� ��¥�� �ִ��� Ȯ���ϴ� �޼���
	private int checkRd(String table){
		System.out.println("checkRd() ���� LectureDao.java");
		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		System.out.println("dTime : "+dTime);
		int count = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select count(*) from "+table+" where "+table+"_rd=?");
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

	// ��ü �ݳ�
	private void close() {
		if (rs != null)	try {rs.close();} catch (SQLException ex) {	}
		if (pstmt != null)	try {pstmt.close();	} catch (SQLException ex) {	}
		if (conn != null)	try {conn.close();	} catch (SQLException ex) {	}
	}
}
