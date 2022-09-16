package hk220916;

public class Ex09 {
	public static void main(String [] args) {
		int i = 10;
		System.out.println(++i); // 증가 연산자
		// i = i + 1; System.out.println(i)
		System.out.println(i++);
		//System.out.println(i); i = i + 1;
		System.out.println(i);// 12
		i = i - 1; // i = 12 - 1
		System.out.println(i); // 11
		i = i - 1; // i = 11 - 1;
		System.out.println(i);
		i--; // i = i - 1; i = 10 -1 ; // 후행
		System.out.println(i); // 9
		--i; // 선행
		System.out.println(i); // 8
		System.out.println(--i); // 7
		// i = i - 1; System.out.println(i);
		System.out.println(i--); // 7
		// System.out.println(i); i = i -1
		System.out.println(i); // 6
	}
}
