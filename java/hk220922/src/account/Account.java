package account;

public class Account {
	String accountNum;
	String accountName;
	int balance;
	public void setData(String accountNum,
			String accountName,int balance ) {
		this.accountName = accountName;
		this.accountNum = accountNum;
		this.balance = balance;
	}
	public void deposit(int money) {
		balance = balance + money;
		print();
	}
	public void withdraw(int money) {
		balance = balance - money;
		print();
	}
	public void print() {
		System.out.println(accountName+"의 계좌번호 "
				+accountNum +"에는 잔액 "
				+balance+"원이 있습니다.");
	}
}
