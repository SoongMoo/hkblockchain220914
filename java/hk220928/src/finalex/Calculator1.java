package finalex;

public class Calculator1 {
	int num1;
	int num2;
	
	public void setData(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	public int add() {
		return num1 + num2;
	}
	public final int sub() {
		return num1 - num2;
	}
}
