package inheritance;

public class FourCalculator extends Calculator{
	/*
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
	 */
    // 메서드 오버라이딩 : 상속받은 부모클래스의 메서드를 다시 정의한 것
	// 오버라이딩된 메서드가 우선순위가 높다.
	
	public int div() { 
		if(num2 == 0) {
			return 0;
		}else {
			return num1 / num2;
		}
	}
	public int pDiv() {
		return super.div();
	}
	public int sub() {
		result = num1 - num2;
		return result;
	}
	public int mul() {
		result = num1 * num2;
		return result;
	}
	
}
