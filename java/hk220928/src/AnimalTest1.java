public class AnimalTest1 {
	public static void main(String[] args) {
		Animal animal = new Human();
		animal.move();
		animal = new Tiger();
		animal.move();
		animal = new Eagle();
		animal.move();
		
		Eagle eagle = (Eagle)animal; // 다운캐스팅
		eagle.flying();
		System.out.println();
		if (animal instanceof Eagle ) {
			System.out.println("Eagle입니까?");
		}
		if (animal instanceof Tiger ) {
			System.out.println("Tiger입니까?");
		}
	}
}