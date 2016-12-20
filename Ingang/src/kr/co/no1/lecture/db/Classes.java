package kr.co.no1.lecture.db;

import kr.co.no1.instructor.db.Instructor;

public class Classes {
	private String classCode;
	private Instructor instructor;
	private String className;
	private String classLevel;
	private String classCategory;
	private int classPeoriod;
	private int classPrice;
	private int discount;
	private int classNumber;
	private String classRd;
	private String classDetail;
	private int soldNumber;
	private int soldAmount;
	private float gradeAverage;
	
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}
	public String getClassCategory() {
		return classCategory;
	}
	public void setClassCategory(String classCategory) {
		this.classCategory = classCategory;
	}
	public int getClassPeoriod() {
		return classPeoriod;
	}
	public void setClassPeoriod(int classPeoriod) {
		this.classPeoriod = classPeoriod;
	}
	public int getClassPrice() {
		return classPrice;
	}
	public void setClassPrice(int classPrice) {
		this.classPrice = classPrice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public String getClassRd() {
		return classRd;
	}
	public void setClassRd(String classRd) {
		this.classRd = classRd;
	}
	public String getClassDetail() {
		return classDetail;
	}
	public void setClassDetail(String classDetail) {
		this.classDetail = classDetail;
	}
	public int getSoldNumber() {
		return soldNumber;
	}
	public void setSoldNumber(int soldNumber) {
		this.soldNumber = soldNumber;
	}
	public int getSoldAmount() {
		return soldAmount;
	}
	public void setSoldAmount(int soldAmount) {
		this.soldAmount = soldAmount;
	}
	public float getGradeAverage() {
		return gradeAverage;
	}
	public void setGradeAverage(float gradeAverage) {
		this.gradeAverage = gradeAverage;
	}
	
	@Override
	public String toString() {
		return "Classes [classCode=" + classCode + ", instructor=" + instructor + ", className=" + className
				+ ", classLevel=" + classLevel + ", classCategory=" + classCategory + ", classPeoriod=" + classPeoriod
				+ ", classPrice=" + classPrice + ", discount=" + discount + ", classNumber=" + classNumber
				+ ", classRd=" + classRd + ", classDetail=" + classDetail + ", soldNumber=" + soldNumber
				+ ", soldAmount=" + soldAmount + ", gradeAverage=" + gradeAverage + "]";
	}
	
	
	
	
}
