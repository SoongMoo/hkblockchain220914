package hk220920;

public class Ex01 {

	public static void main(String[] args) {
		//  조건문 : if, if ~ else, if ~ else if ~ ... ~ else if ~ else,
		//         이중 if, switch ~ case
		
		// 반복문 for , while, do ~ while
		// 반복적으로 수행되는 명령문을 한번만 사용해서 같은 결과를 갖도록 하는 것
		System.out.println("1번찍었습니다.");
		System.out.println("2번찍었습니다.");
		System.out.println("3번찍었습니다.");
		System.out.println("4번찍었습니다.");
		System.out.println("5번찍었습니다.");
		System.out.println("6번찍었습니다.");
		System.out.println("7번찍었습니다.");
		System.out.println("8번찍었습니다.");
		System.out.println("9번찍었습니다.");
		System.out.println("10번찍었습니다.");
		System.out.println("나무가 넘어간다.");
		
		System.out.println("==== 반복문 =====");
		//     1         2       4
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + "번찍었습니다."); //3
		}
		// 1-2-3-4-2-3-4-2-3-....-3-4-2
		System.out.println("나무가 넘어간다.");
	}
}
