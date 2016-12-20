package kr.co.no1.instructor.db;

public class Instructor {
	private String instructorCode;
	private String instructorName;
	private String instructorDetail;
	private String instructorImage;
	
	public String getInstructorCode() {
		return instructorCode;
	}
	public void setInstructorCode(String instructorCode) {
		this.instructorCode = instructorCode;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getInstructorDetail() {
		return instructorDetail;
	}
	public void setInstructorDetail(String instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	public String getInstructorImage() {
		return instructorImage;
	}
	public void setInstructorImage(String instructorImage) {
		this.instructorImage = instructorImage;
	}
	@Override
	public String toString() {
		return "Instructor [instructorCode=" + instructorCode + ", instructorName=" + instructorName
				+ ", instructorDetail=" + instructorDetail + ", instructorImage=" + instructorImage + "]";
	}
	
	
}
