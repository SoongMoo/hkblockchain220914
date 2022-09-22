package constractor;

public class Person {
	private String name;
	private float height;
	private float weight;
	public void setData(String name,float height,float weight ) {
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
