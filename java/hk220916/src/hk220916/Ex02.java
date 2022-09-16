package hk220916;

public class Ex02 {
	public static void main(String [] args) {
		// 변수 : 리터널 값을 저장 하는 역할
		// 정수 리터널 : 10, 9
		int i = 10; // int i : 4byte
		System.out.println(i);
		long l = 10000000000000L; // long l: 8byte
		System.out.println(l);
		// 실수 리터널 : 10.5
		float f; // 4byte : 정밀도 낮다.소수점 이하 8자리
		double d; // 8byte : 정밀도 높다.소수점 이하 17자리

		f = 0.1234567890123456789f;
		d = 0.1234567890123456789;
		System.out.println(f);
		System.out.println(d);
		
		//문자 리터널
		char ch = 'a'; //   문자 변수
		System.out.println(ch);
		char ch1 = 98; //   정수 변수
		System.out.println(ch1);// 정수에 해당하는 문자
		
		// 문자열 리터널
		String str = "a";
		System.out.println(str);
		str = "이숭무";
		System.out.println(str);
		
		
		// 부울 리터널: true, false
		//              "true", "false"(문자열)
		boolean bl1 ; // 선언
		bl1 = true; // 대입
		boolean bl2 = false; // 초기화
		int  i1 = 10;
		System.out.println(bl1);
		System.out.println(bl2);
		System.out.println(true);
		System.out.println(false);
		System.out.println(100 + 1);
		//boolean bl3 = "true";
		String str2 = "true";
		//str2 = true;
	}
}
