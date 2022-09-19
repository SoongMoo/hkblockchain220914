package hk220919;

public class Ex05 {
	public static void main() {
		// if ~ else : 두가지 중 하나를 선택
		// 다중  if문 : 여러개 중에 하나를 선택
		// if ~ else if ~ else if ~ ... ~ else
		// 학점 : A, B, C, D ,F
		int score = 75;
		if(score >= 90)System.out.println("A");
		else if(score >= 80) System.out.println("B");
		else if(score >= 70) System.out.println("C");
		else if(score >= 60) System.out.println("D");
		else System.out.println("F");
		
		// 문제
		// 8살 이하면 용돈 2000, "취학전 아동"을 출력
		// 14살  이하면 용돈 4000, "초등학생"
		// 17살 이하면 용돈 6000, "중학생"
		// 20살 이하면 용돈 8000, "고등학생"
		// 용돈을 10000, 성인입니다.
		// 용돈 출력
		int age = 7, money=2000;
		if (age <= 8) {
			money = 2000;
			System.out.println("취학전 아동");
		}else if(age <= 14) {
			money = 4000;
			System.out.println("초등학생");
		}else if(age <= 17) {
			money = 6000;
			System.out.println("중등학생");
		}else if(age <= 20) {
			money = 8000;
			System.out.println("고등학생");
		}else {
			money = 10000;
			System.out.println("성인");
		}
		System.out.println("용돈 = " + money);
		
		
		
		if (age <= 8) {
			money = 2000;
			System.out.println("취학전 아동");
		}
		if(age <= 14) {
			money = 4000;
			System.out.println("초등학생");
		}
		if(age <= 17) {
			money = 6000;
			System.out.println("중등학생");
		}
		if(age <= 20) {
			money = 8000;
			System.out.println("고등학생");
		}else {
			money = 10000;
			System.out.println("성인");
		}
		System.out.println("용돈 = " + money);
		
	}
}
