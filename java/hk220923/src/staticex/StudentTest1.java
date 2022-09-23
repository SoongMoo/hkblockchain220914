package staticex;

public class StudentTest1 {

	public static void main(String[] args) {
		Student stu = new Student();
		stu.setStudentId(++stu.serialNum);
		stu.setStudentName("이숭무");
		System.out.println(stu.getStudentId());
		System.out.println(stu.getStudentName());
		
		Student stu1 = new Student();
		stu1.setStudentId(++stu1.serialNum);
		System.out.println(stu.getStudentId());
	}

}
