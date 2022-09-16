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
		
		
		
		
		
		
				
		
	}
}
