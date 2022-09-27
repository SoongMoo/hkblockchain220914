package polymorphism;

public class Tire {
	int maxRotation;
	int accumulatedRotation;
	String location;
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	public boolean roll() {
		accumulatedRotation++;
		if(maxRotation >  accumulatedRotation) {
			System.out.println(location + "Tire 수명 : " +
					(maxRotation-accumulatedRotation)+"회");
			return true;
		}else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		}
	}
}
