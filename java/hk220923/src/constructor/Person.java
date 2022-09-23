package constructor;

public class Person {
  //접근집정자
	String name;
	float height;
	float weight;
	
	// 생성자 
	public Person(String name,float height, float weight ) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public Person(String name) {
		this.name=name;
		
	}
	public Person(String name, float weight) {
		this.name= name;
		this.weight = weight;
	}
	// 생성자를 정의하게 되면 디펄트 생성자는 자동으로 만들어지지 않는다.
	public Person() {}
	public void setData(String name,float height, float weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public void print() {
		System.out.println(name + "는 키가 " + height + "이고 몸무게는 "
				+ weight);
	}
}
