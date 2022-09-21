package hk220921;

public class Student { // 사용자 자료형
	// 멤버 변수
	// 멤버 필드
	int age;
	double height;
	String addr;
	String phone;
	String name;
	
	// 메서드 : 기능 구현
	public void print() {
		System.out.println(name + "의 주소는 " + addr);
	}
}
