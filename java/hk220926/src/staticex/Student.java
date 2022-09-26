package staticex;

public class Student {
	static int serialNum = 1000; // 정적 변수 , 클래스 변수
	int studentId;
	String studentName;
	int grade;
	String address;
	
	// 클래스 메서드
	public static int getSerialNum() {
		return serialNum;
	}
	
	//setter
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	// getter
	public int getStudentId() {
		return this.studentId;
	}
	public String getStudentName() {
		return this.studentName;
	}
	public int getGrade() {
		return grade;
	}
	public String getAddress() {
		return address;
	}	
}
