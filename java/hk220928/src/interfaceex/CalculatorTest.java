package interfaceex;

public class CalculatorTest {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		
		CompleteCalc calc = new CompleteCalc();
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.substract(num1, num2));
		calc.showInfo();
		calc.description();
		
		Calc newCalc = calc;
		System.out.println(newCalc.add(num1, num2));
		// newCalc.showInfo();
		
		// 다운 캐스팅
		CompleteCalc cal = (CompleteCalc)newCalc;
		cal.showInfo();
		cal.description();
		
		Calc.myStaticMethod();
	}
}
