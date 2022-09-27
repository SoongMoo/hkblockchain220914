package polymorphism;

public class AnimalTest1 {

	public static void main(String[] args) {
		Animal animal = new Human();
		animal.move();
		animal = new Tiger();
		animal.move();
		animal = new Eagle();
		animal.move();
	}

}
