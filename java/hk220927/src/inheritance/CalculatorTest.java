package inheritance;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourCalculator cal = new FourCalculator();
		cal.setData(20, 10);
		int i = cal.add();
		System.out.println(i);
		i = cal.div();
		System.out.println(i);
		i = cal.sub();
		System.out.println(i);
	}

}
