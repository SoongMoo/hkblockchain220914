package hk220915;

public class Valiable6 {
	public static void main(String [] args) {
		// 실수형 리터널 : 10.5 : 8byte
		// float(4byte), double(8byte)
		float f = 10;
		System.out.println(f);
		f = 10.5f; // 소수점이하 4자리
		System.out.println(f);
		double  d = 10.5;
		System.out.println(d);
		d = 1001.12345678901589;
		System.out.println(d);
		f = (float)d;
		System.out.println(f);
	}
}
