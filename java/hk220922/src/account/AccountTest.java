package account;

public class AccountTest {
	public static void main(String[] args) {
		// 문제
		// Account라는 클래스가 있고 클래스에는 
		// 계좌번호 , 계좌주, 잔액이 있고 최초 잔액 0 원입니다.
		// accountNum, accountName, balance
		// 계좌 개설을 한 후 setData메서드 사용해서 각 멤버에 값을저장
		// deposit함수를 이용하여 입금을 시키고 잔액을 출력
		// withdraw함수를 이용하여 출금을 하고 잔액을 출력
		Account acc = new Account();
		acc.setData("1111", "이숭무", 0);
		System.out.println("입금");
		acc.deposit(100);
		System.out.println("출력");
		acc.withdraw(50);
	}
}
