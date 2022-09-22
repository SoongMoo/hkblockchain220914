package classMethod;

public class Member_1 {
	// 멤버 필드 / 멤버 변수
	private String name;
	private int age;
	private String addr;
	// 피 호출메서드  // parameter/ 매개변수 / 가인자
	public void setData(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	// getter
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	// 피호출메서드
	public String getAddr() {
		// return은 retrun 뒤에 있는 값을 호출함수로 전달
		return this.addr; 
	}
	
	public void print() {
		System.out.println(this.name);
		System.out.println(age);
		System.out.println(addr);
	}
}
