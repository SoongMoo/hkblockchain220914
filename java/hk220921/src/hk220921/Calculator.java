package hk220921;

public class Calculator { // 사용자 자료형
	int num1;
	int num2;
	int result;
	//멤버필드를 사용하기 위한 기능 구현 : 메서드
	//                 (  parameter : 매개변수 : 가인자)
	// 피호출 메서드
	public void setData(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
	}
	//    반환형
	public int add() {
		result = this.num1 + num2;
		return result;
	}
	public int sub() {
		result = num1 - num2;
		return result;
	}
	public int mul() {
		result = num1 * num2;
		return result;
	}
	public int div() {
		result = num1 / num2;
		return result;
	}
	
	
	
}
