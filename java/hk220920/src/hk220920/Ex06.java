package hk220920;

public class Ex06 {
	public static void main(String [] args) {
		// 블록변수
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
			System.out.println(i);
			int a = 10;
		}
		System.out.println(sum);
		// System.out.println(i); i는 for문 안에서만 사용가능
		// System.out.println(a); 
		sum = 0;
		int j;
		for (j = 1; j <= 10 ; j++) {
			sum += j;
			System.out.println(j);
		}
		System.out.println(j);
		System.out.println(sum);
	}
}
