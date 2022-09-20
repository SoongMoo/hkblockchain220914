package hk220920;

public class Ex05 {
	public static void main(String[] args) {
		// 1 ~ 10
		int sum = 0;
		/*
		 * for(int i = 1; ; i++) { // 조건이 없으므로 무한 반복이 된다. System.out.println(i
		 * +"찍었습니다."); }
		 */
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "찍었습니다.");
		}
		System.out.println("나무가 넘어간다.");

		System.out.println("==========================");

		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "찍었습니다.");
			if (i == 10)
				System.out.println("나무가 넘어간다.");
		}
	}
}
