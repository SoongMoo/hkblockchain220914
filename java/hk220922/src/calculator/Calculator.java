package calculator;

public class Calculator {
	int num1;
	int num2;
	
	int result;
	
	public int add(int num1, int num2) {
		result = num1 + num2;
		return result;
	}
	////   반환형 
	public int sub(int num1, int num2) {
		result = num1 - num2;
		return result;
	}
	public int mul(int num1, int num2) {
		result = num1 * num2;
		return result;
	}
	public int div(int num1, int num2) {
		result = num1 / num2;
		return result;
	}
	
}
