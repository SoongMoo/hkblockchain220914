package interfaceex;

public abstract class Calculator implements Calc {
    // public int times(int num1, int num2)
	// public int divide(int num1, int num2) 
	@Override
	public int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		// TODO Auto-generated method stub
		return  num1 - num2;
	}


}
