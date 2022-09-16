package hk220916;

public class Ex08 {
	public static void main(String [] args) {
		int i = 10;
		i = i + 1; //i = 10 + 1; // i = 11
		System.out.println(i); // 11
		i = i + 1; // i = 11 + 1 ; i = 12 
		System.out.println(i); //12
		i = i + 1;
		System.out.println(i);// 13
		i++; // i = i + 1
		System.out.println(i); // 14
		i++; // 후행
		System.out.println(i ); //15
		++i; // 선행
		System.out.println(i); //16
		++i; // 연산 
		System.out.println(i); // 출력 17
		System.out.println(++i); // 18 
		// i = i + 1; System.out.println(i)
		System.out.println(i++);  // 18
		// System.out.println(i); i = i + 1;
		System.out.println(i); // 19
	}
}
