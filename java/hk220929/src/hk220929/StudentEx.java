package hk220929;

public class StudentEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1 = new Student(6000,"이숭무");
		Student stu2 = new Student(6000,"이상범");
		
		Bus bus = new Bus(101);
		SubWay sub = new SubWay(1);
		
		stu1.use(bus);
		stu1.use(sub);
		stu1.use(10);
		
		bus.showBusInfo();
		sub.showSubInfo();
		
		
	}

}
