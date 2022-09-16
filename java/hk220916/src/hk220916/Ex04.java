package hk220916;

public class Ex04 {
	public static void main(String [] args) {
		// 형변환
		// 자동형변환 : 작은 자료형이 큰 자료형으로 변환하는 것
		// 1byte => 2byte => 4byte => 8byte
		// 1byte => 4byte , 1byte => 8byte
		// 2byte => 8byte
		//         정수 => 실수
		double d = 10; // 10.0 : 자동형변환
		
		short s = 10;// 2byte 정수자료형
		int i = s; //대입 : 오른쪽에 있는 값을 왼쪽에 전달
		System.out.println(i);
// 자동형변환 = 암시적 형변환 = 묵시적 형변환
//                         정수  => 실수 
// byte => short => int => long => float =>double
//         char
		short sh = 30000;
		int i1 = sh ;
		float f = sh; // 정수 => 실수
		System.out.println(i1);
		System.out.println(f);
		double d1 = sh;
		System.out.println(d1);
        
		long l = 1000; // 8byte
		f = l; // 정수 => 실수
		System.out.println(f);
		
		short sh1 = 100;
		int num = 20;
		int rsult = sh1 + num;
		//          2byte + 4byte
		//          4byte + 4byte = 4byte
		
		//  0000010100001111 : 4byte
		//+         01100101 : 2byte
		//-------------------
		//          01110100
		
		//  0000010100001111 : 4byte
		//+ 0000000001100101 : 4byte
		//-------------------
		//  0000010101110100 : 4byte
		// 정수 : 4byte 
		// 실수 : 8byte
		long ii = 10; // 정수
		float d2 = 10.6f; // 실수
		float result12 = ii + d2;
		// 정수 + 실수 => 실수 + 실수 = 실수
		System.out.println(result12);
		double result3 = ii + d2;
		//      (double)(float + float)
			
		int iNum = 20;
		float fNum = iNum; // 자동형변환 : 20.0
		double dNum;
		dNum = iNum + fNum;
		//      int + float
		//     float + float = float
		// double = (double)float
	}
}
