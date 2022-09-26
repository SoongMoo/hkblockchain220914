package staticex;

public class StudentTest {
	public static void main(String[] args) {
		Student stu1 = new Student();
		    // 객체변수
		stu1.setStudentId(++Student.serialNum);// serialNum =1001
		System.out.println(stu1.getStudentId());
		
		
		Student stu2 = new Student(); // serialNum = 1001
		stu2.setStudentId(++Student.serialNum); // serialNum = 1002
		System.out.println(stu2.getStudentId());
		
		Student stu3 = new Student(); // serialNum = 1002
		stu3.setStudentId(++Student.serialNum); // serialNum = 1003
		System.out.println(stu3.getStudentId());
		
		System.out.println(Student.getSerialNum());   // 1003
		System.out.println(Student.getSerialNum());   // 1003
		System.out.println(Student.getSerialNum());   // 1003
	}
}
