package hk220921;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		//              (argument / 실인자 / 전달인자)
		// 호출 메서드
		calculator.setData(10, 20, 30);
		System.out.println(calculator.num1);
		System.out.println(calculator.num2);
		int i = calculator.add(); // 10 + 20 = 30
		System.out.println(i);
		i = calculator.sub();
		System.out.println(i);
		Calculator calculator1 = new Calculator();
		calculator1.setData(100, 200,300);
		System.out.println(calculator1.num1);
		System.out.println(calculator1.num2);
		int i1 = calculator1.add();
		System.out.println(i1);
	}

}
