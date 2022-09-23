package thisex;

public class Person {
	// 멤버필드는 초기화를 안해도 초기값을 가진다.
	private String name;
	float height;
	float weight;
	// getter
	public String getName() {
		return this.name;
	}
	public float getHeight() {
		return this.height;
	}
	public float getWeight() {
		return this.weight;
	}
	// this() : 생성자 호출 : 생성자에서 생성자를 호출할 때
	public Person() {
		this(75.0f);		
	}
	public Person(float weight) {
		this("박준현", 170.5f, weight );		
	}
	public Person(String name) {
		
	}
	public Person(float height,String name,  float weight) {

	}
	public Person(String name, float height, float weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
}
