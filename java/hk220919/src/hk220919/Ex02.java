package hk220919;

public class Ex02 {
	public static void main(String [] args) {
		// 논리연산자 : &&(논리 곱), ||( 논리 합) , !(부정 not)
		// 논리 연산자의 결과 부울타입 
		// 제어문에서 사용
		// 부울타입 끼리의 연산 
		//  false && true
		// 참 && 참 = 참
		// 참 && 거짓 = 거짓
		// true && true
		// bool타입의 연산이므로 bool타입의 결과를 가지는 관계연산자와 같이 사용
		int kor = 45;
		int eng = 75;
		int mat = 85;
		//  모든 점수가 60점 이상 이어야 합격
		boolean result = kor >= 60 && eng >= 60 && mat >=60;
		System.out.println(result);
		
		
		System.out.println(!true);
		System.out.println(!false);
		boolean bl = true;
		System.out.println(!bl);
		System.out.println(!!bl);
		
		int i3 = 65;
		int i4 = 75;
		int i5 = 85;
		boolean b5, b6, b7;
		b5 = i3 > i4; // false
		b6 = i4 < i5; // true
		b7 = b5 && b6;
		System.out.println(b7); // false
		b7 = (i3 > i4) && (i4 < i5);
		System.out.println(b7); 
		
		float f1 = 10.1f; // 4byte
		double d = 10.1; // 8byte
		result 	= f1 == d;
		System.out.println(f1); // 10.10000001
		System.out.println(d);  // 10.100000000000001
		System.out.println(result);
		result 	= (double)f1 == d;
		System.out.println(result);
		/// 문제 : 2200년은 윤년입니까?
		// 4년 마다 윤년이고 100년마다는 평년이다. 그러나 400마다는 윤년
		int year = 2200;
		boolean b1 = year % 4 == 0; // true
		boolean b2 = year % 100 != 0; // false
		boolean b3 = year % 400 == 0; // false
		boolean b4 = b1 && b2 || b3; 
		         // true && false || false
		         //    false || false = false  
		System.out.println("b3 : " + b3);
		System.out.println(b4);
		b4 =(year % 4 == 0 ) 
				&& (year % 100 != 0) || (year % 400 == 0);
		System.out.println(b4);
		
		if((year % 4 == 0 ) 
				&& (year % 100 != 0) || (year % 400 == 0)) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
		
		int num1 = 10;
		int i = 1;
		boolean value = 
				(num1 = num1+ 10) < 10 // false 
			  &&(i = i + 2) < 10 // true
				; // false && true = false
		System.out.println(value);
		 
		value = (num1 = num1 + 10) > 10// true
			 ||(i = i + 2 ) < 10 //true
			 ; // true || true = true
		System.out.println(value);
		
		// && (and) , || (or)
		// &&
		// A      B   C
		// 참   && 참 = 참
		// 거짓     X = 거짓
		// 참   && 거짓 = 거짓
		
		// ||
		// 참   ||  X  = 참
		// 거짓  || 참  = 참
		// 거짓  || 거짓 = 거짓
		// 조건 연산자 , 삼항 연산자. (? :)
		int i11  = (10 > 5) ? 10 : 5;
		System.out.println(i11);
		// 1항의 값이 참이면 2항의 값을 전달하고 
		// 1항의 값이 거짓이면 3항의 값을 전달
		// 1항의 값은  true/false이어야 한다.
		
		// ,연산자
		int a,b,c;
		a = b = c = 10;
		// + : 문자열 연결연산자
		System.out.println("hello" + " " + "java");
		
		
		
		
		
		
	}
}