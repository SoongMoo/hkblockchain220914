package hk220920;

public class Ex04 {
	public static void main(String[] args) {
		// 1 ~ 10까의 합을 구해 출력
		int sum = 0;
		sum = sum + 1; //1  // num += 1
		sum = sum + 2; //3
		sum = sum + 3; // 6
		sum = sum + 4; // 10
		sum = sum + 5; // 15
		sum = sum + 6;
		sum = sum + 7;
		sum = sum + 8;
		sum = sum + 9;
		sum = sum + 10;
		System.out.println(sum);
		sum = 0;
		for(int i = 1; i <= 10 ; i++) {
			sum = sum + i;  // 합계값
		}
		System.out.println(sum);
		
		sum = 0;
		for(int i = 1; i <= 100 ; i++) {
			sum = sum + i;  // 합계값
		}
		System.out.println(sum);
		
	}
}
