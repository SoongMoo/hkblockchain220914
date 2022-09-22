package calculator;

public class CalculatorTest {
	public static void main(String [] args) {
		Calculator cal = new Calculator();
		int i = cal.add(20, 10);
		// int i = 30
		System.out.println(i);
		
		i = cal.sub(30, 10);
		// i = 20
		System.out.println(i);
	}
}
