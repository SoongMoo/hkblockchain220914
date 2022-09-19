package hk220919;

public class Ex03 {
	public static void main(String[] args) {
		// 제어문 : 조건문 , 반복문
		// 조건문 : condition에 따라 실행할지 안할지
		// if(condition: 조건식){ // true: 실행
		// 명령어;
		// ...
		// }
		// 조건식 : 관계연산자 또는 논리연산자.
		// 단일 if : 실행이 되거나 안되거나
		int i = 10;
		if (i < 20)
			System.out.println("작다");
		if (i < 20) {
			System.out.println("작다");
		}
		if (i < 20) {
			System.out.println("i가");
			System.out.println("작다");
		}
		System.out.println("========================");
		i = 30;
		if (i < 20)
			System.out.println("작다");
		System.out.println("실행되는 명령어");// if문영향을 안받음

		int money = 3000;
		// 3000 원 이상이면 "차를 타고 가시오"를 출력
		if (money >= 3000)
			System.out.println("차를 타고 가시오");
		System.out.println("if문 종료");

		money = 2000;
		// 3000 원 이상이면 "차를 타고 가시오"를 출력
		if (money >= 3000)
			System.out.println("차를 타고 가시오");
		System.out.println("if문 종료");

		if (money >= 3000) {
			System.out.println("차를 타고 가시오");
		}
		System.out.println("if문 종료");
	}
}
