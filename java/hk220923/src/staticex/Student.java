package staticex;

public class Student {
	//정적 변수
	int serialNum = 1000;// 클래스 변수
	// 모든 객체가 공유하는 데이터를 만들어 사용
	int studentId;
	String studentName;
	int grade;
	String address;
	// 정적메서드 
	public int getSerialNum() {
		return serialNum;
	}
	public int getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public int getGrade() {
		return grade;
	}
	public String getAddress() {
		return address;
	}

	
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
}
