package interfaceex;

public class CompleteCalc extends Calculator{
// class에 class상속인 경우 extends
// class에 interface를 상속하는 경우에는 implements
	@Override
	public int times(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		// TODO Auto-generated method stub
		if(num2 != 0 )
			return num1/num2;
		else 
			return Calc.ERROR;
	}
	
	public void showInfo(){
		System.out.println("Calc 인터페이스를 구현하였습니다" );
	}

}
