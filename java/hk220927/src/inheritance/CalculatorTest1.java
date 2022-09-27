package inheritance;

public class CalculatorTest1 {

	public static void main(String[] args) {
		FourCalculator cal = new FourCalculator();
		cal.setData(10, 0); // 0 / 10
		int i = cal.div();
		i = cal.pDiv();
		System.out.println(i);
		// 10 / 0 : 불능
	}

}
