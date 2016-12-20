package kr.co.no1.lecture.db;

public class Lecture {
	private String lectureCode;
	private String classCode;
	private Classes classes;
	private String lectureName;
	private String lectureDetail;
	private String lectureFile;
	private String lectureRd;
	
	public String getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}
	
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	public String getLectureDetail() {
		return lectureDetail;
	}
	public void setLectureDetail(String lectureDetail) {
		this.lectureDetail = lectureDetail;
	}
	public String getLectureFile() {
		return lectureFile;
	}
	public void setLectureFile(String lectureFile) {
		this.lectureFile = lectureFile;
	}
	public String getLectureRd() {
		return lectureRd;
	}
	public void setLectureRd(String lectureRd) {
		this.lectureRd = lectureRd;
	}
	@Override
	public String toString() {
		return "Lecture [lectureCode=" + lectureCode + ", classes=" + classes + ", lectureName=" + lectureName
				+ ", lectureDetail=" + lectureDetail + ", lectureFile=" + lectureFile + ", lectureRd=" + lectureRd
				+ "]";
	}
	
	
}
