package constractor;

public class Person_1 {
	private String name;
	private float height;
	private float weight;
	// 클래스명과 같은 이름의 메서드, 반환형 없는
	public Person_1(String name,float height,float weight ) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public void print() {
		System.out.println(name);
		System.out.println(height);
		System.out.println(weight);
	}
}
