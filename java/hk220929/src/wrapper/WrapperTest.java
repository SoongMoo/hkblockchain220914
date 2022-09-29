package wrapper;

public class WrapperTest {

	public static void main(String[] args) {
		int i =10;
		Integer in = 10;
		long l = 1000;
		Long lo = 1000L;
		float f = 10.7f;
		Float f1 = 10.7f;
		double d = 10.6;
		Double d1 = 10.5;
		boolean bl = true;
		Boolean bl1 = true;
		
		System.out.println(Boolean.valueOf("True"));
		
		Integer num1 = 100;
		int num2 = num1; // 언박싱
		int num3 = 10;
		num1 = num3; // 오토 박싱

	}

}
