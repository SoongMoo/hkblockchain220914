package collection;

import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("계좌번호 : 1 | 입금 : 2 | 출금 : 3 | 계좌출력 : 4 | 종료 : 5");
			System.out.print("해당번호를 입력해주세요. : ");
			String num = sc.nextLine();
			switch(num) {
			case "1" : 
				System.out.println("계좌번호 등록");
				break;
			case "2" :
				System.out.println("입금");
				break;
			case "3" :
				System.out.println("출금");
				break;
			case "4" :
				System.out.println("계좌 정보");
				break;
			case "5" :
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}

}
