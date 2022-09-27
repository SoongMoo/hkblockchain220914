package inheritance;

public class Calculator {
	int num1 ;
	int num2 ;
	int result;
	
	public void setData(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	public int add() {
		result = num1 + num2;
		return result;
	}
	public int div() {
		result = num1 / num2;
		return result;
	}
	public int rest() {
		result = num1 % num2;
		return result;
	}
}
