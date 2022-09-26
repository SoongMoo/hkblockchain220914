package cooperation;

public class Student {
	String studentName;
	int grade;
	int money;
	
	// 생성자
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	public void takeBus(Bus bus) { // Bus bus = bus1
		bus.take(1000);
		this.money -= 1000;
	}
	public void takeSubWay(SubWay subWay) {
		subWay.take(1500);
		this.money -= 1500;
	}
	public void showInfo() {
		System.out.println(studentName+"님의 남은 돈은 "
								+ money+"원 입니다");
	}
	
	
	
}
