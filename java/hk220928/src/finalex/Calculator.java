package finalex;

public final class Calculator { // 상속되지 않는 클래스
	int num1;
	int num2;
	
	public void setData(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	public int add() {
		return num1 + num2;
	}
	public int sub() {
		return num1 - num2;
	}
}
