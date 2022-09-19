package hk220919;

public class Ex01 {
	public static void main(String [] main) {
		// 관계연산자 : 10 > 3 , <, <=, >=, ==, !=
		// 결과는 부울타입 : true, false
		// 제어문에서 많이 사용하게 된다. if, for
		// if(condition:관계연산자){}
		int i = 10;
		System.out.println(i > 5); //  true
		if(i > 5) { // true
			System.out.println("i는 5보다 큽니다.");
		}
		//  if문의 condition의 결과는 부울타입
		
		int i3 = 65; // 대입
		int i4 = 75;
		int i5 = 85;
		boolean result;
		result = i3 > i5; // 65 > 85
		System.out.println(result); // false
		result = i4 < i3 ; // 75 < 65
		System.out.println(result); // false
		result = i4 == i5; // result = false
		System.out.println(result);
		result = i3 != i5; // 65 != 85 // true
		System.out.println(result);
		
		
	}
}
