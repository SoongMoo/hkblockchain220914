package hk220921;

public class StudentBus {

	public static void main(String[] args) {
		int i = 10;
		Student student = new Student(); // 객채 생성
		//      객체변수   =    객체
							/*
							age;
							height;
							addr;
							phone;
							name;
							*/
		student.addr = "서울";
		student.age = 30;
		student.height = 175.8;
		student.name ="이숭무";
		student.phone="012";
		
		Student student1 = new Student();
		student1.name = "박기영";
		student1.addr = "오산";
		student1.age=25;
		student1.height = 180.0;
		student1.phone = "010";
		
		Bus bus = new Bus();
		bus.number = 145;
		
		System.out.println(student1.name + "은 " + bus.number +"를 타고 갑니다."  );
		System.out.println(student.name + "은 " + bus.number +"를 타고 갑니다."  );
		student.print(); //이숭무
		student1.print(); // 박기영
	}

}
