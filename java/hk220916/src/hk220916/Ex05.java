package hk220916;

public class Ex05 {
	public static void main(String [] args) {
		// 명시적 형 변환 : 강제형변환
        // 큰 자료형을 작은 자료형으로 변환시키는 것
		int i = 100; // 4byte
		short sh = (short)i; // 강제형변환
		sh = 128 + 256; //0000000110000000
		// 1byte : -128 ~ 127
		byte b = (byte)sh;
		System.out.println(b);// 10000000
		
		float f1 = 3.14f;
		int iNum = (int)f1;
		System.out.println(iNum);
		
		double dd1 = 3.141592;
		iNum = (int)dd1;
		System.out.println(iNum);
		
		iNum = 97; // -32
		System.out.println((char)iNum);
		iNum = 65;
		System.out.println((char)iNum);
		
		char ch1 ='A';
		System.out.println((int)ch1);
		
		
		double dNum1 = 1.7;
		float fNum2 = 0.9f;
		
		int iNum3 =(int)(dNum1 + fNum2);
		//               double + float
		//               double + double
		//         (int)(1.7 + 0.9 = 2.6) = 2
		System.out.println(iNum3);

		iNum3 = (int)dNum1 + (int)fNum2;
		//            1.7  + 0.9
		//            1    + 0 = 1  
		
		int ii = 10;
		double ddd = 2.0;
		int result2 = (int)(ii + ddd);
		char ch22 = '글';
		System.out.println((int)ch22);
	}
}
