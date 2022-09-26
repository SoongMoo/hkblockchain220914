package staticex;

public class StudentTest1 {

	public static void main(String[] args) {
		Student stu1 = new  Student();
		stu1.setStudentId(stu1.serialNum);// serialNum=1001
		System.out.println(stu1.getStudentId());

	}
}
