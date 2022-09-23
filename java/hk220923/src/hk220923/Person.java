package hk220923;

public class Person {
	// 멤버 필드, 멤버 변수
	private String name;
	private float height;
	private float weight;
	// 모든 클래스에는 생성자가 존재해야 한다.
	public Person() {} // 디펄트 생성자.
	// setter/getter
	// 피 호출 메서드
	// 멤버 메서드        // parameter / 가인자 / 매개변수
	public void setData(String name,float height,float weight  ){
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public void print() {
		System.out.println(name + "는 키가 " + height + "이고 몸무게는 "
				+ weight);
	}
	
}
