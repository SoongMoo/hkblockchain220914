package hk220916;

public class Ex03 {
	public static void main(String [] args) {
		int i ;// 변수: 변할 수 있는 값
		i = 10;
		System.out.println(i);
		i = 20; // 값을 변경
		System.out.println(i);
		// 상수: 값을 변경 할수 없다.
		// 리터널 상수 : 10
		// 사용자 상수 : 사용자 정의 : final
		double pi = 3.141592;
		System.out.println(pi);
		pi = 3.1111;
		System.out.println(pi);
		
		final double PI = 3.141592;
		System.out.println(PI);
		//PI = 3.1111;
		final int MAX_VOL = 100;
		final int MIN_VOL = 1;
	}
}
