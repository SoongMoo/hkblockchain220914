package hk220921;

public class Ex01 {

	public static void main(String[] args) {
		// 리터널 / 변수
		// 리터널 : 변하지 않는 수 : 상수
		//        자연어(한글, 영어, 중국어,...)
		//             문자  : 'a', '1' , a(변수)
		//             문자열 : "a", "abcd", abcd(변수) 
		//        자연수(정수, 실수, 지수)
		//             정수 : 10, 2, 399 , 1 ,'1'(문자리터널) 
		//             실수 : 10.5, 10.0
		//        부울타입 : true/false
		//   변수 : 변하는 수 
		char c = 'c';
		String str = "str";
		c = '1';
		int i = 10;
		str = "10";
		double d; 
		
		// 변수를 만들기 위해서는 자료형
		// 정수 자료형 : char, int , long
		char ch = 10; // 정수가 저장
		System.out.println(ch);// 문자
		int i1 = 10;
		long l = 1000000000000000L;
		l = 1000000000;
		
		// 실수 자료형 : float, double
		float f = 10.5f;
		double d1 = 10.5;
		
		// 문자 자료형 : char
		char ch1 = 'A';
		System.out.println(ch1);
		
		//  문자열 자료형 : String
		String str1 = "abcdf";
		
		// 강제형/자동형
		// 자동형 
		// char => int => long
		// 정수 => 실수
		double d2 = 10;
		System.out.println(d2);
		
		// 강제 형변환 
		// long => int => char
		// 실수 => 정수
		int i2 =(int)10.5;

		// 연사자
		// 산술연산자 : +,-,*,/,%
		System.out.println(10 % 3); // 나머지 연산자.
		System.out.println(10% 2); // 0: 짝수
		System.out.println(11% 2); // 1: 홀수
		// 대입 연산자 : =, +=, -=,*=, /=
		// i = i + 2 => i+=2
		// i = i / 2 => i/=2
		// 증가감 : ++, --
		i = i + 1;
		i += 1;
		i++; // 1씩증가
		i = i - 1;
		i -= 1;
		i--; // 1씩감소
		++i; //선행
		--i;
		
		i = 10;
		int y = i++; // 후행
		// y = i , i = i + 1
		// y = 10, i = 11
		
		i = 10;
		y = ++i;
		// i = i + 1, y = i
		// i = 11, y = 11
		
		// 관계 연산 : ==, <, >, <=, >= !=
		// 논리연산 : &&, || , ! : !true , !false 
		
		// 조건문 :  if , if ~ else, 
		// if ~ else if ~ ... ~else if ~ else : 다중 if
		// 이중 if : 범위 값
		// switch ~ case :  단일 값
		// 반복문 :  for, while, do ~ while : while(true)
		//"이샘을 전적으로 믿습니다."을 10번 출력하세요.
		for(int j = 0; j < 10; j++) {
			System.out.println("이샘을 전적으로 믿습니다.");
		}
		// 7단 출력
		for(int j = 1 ; j <= 9; j++) {
			System.out.println("7 * " + j + " = " + 7 * j);
		}
		
		int k = 1;
		for(int j = 1; j < 10; j++) {
			System.out.println("7 * " + k + " = " + 7 * k);
			k++;
		}
		
		k = 1;
		int j = 1;
		while(j < 10) {
			System.out.println("7 * " + k + " = " + 7 * k);
			k++;
		}
		// break, continue	
		
		
		
		
		
		
		
		
		
		
	}

}
