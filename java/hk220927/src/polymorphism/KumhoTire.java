package polymorphism;

public class KumhoTire extends Tire{

	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean roll() {
		accumulatedRotation++;
		if(maxRotation >  accumulatedRotation) {
			System.out.println(location + "KumhoTire 수명 : " +
					(maxRotation-accumulatedRotation)+"회");
			return true;
		}else {
			System.out.println("*** " + location + " KumhoTire 펑크 ***");
			return false;
		}
	}
}
