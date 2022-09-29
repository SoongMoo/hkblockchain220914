package collection;

public class Account {
	String accNum;
	String accName;
	int balance;
	public Account(String accNum, String accName, int balance) {
		this.accName = accName;
		this.accNum = accNum;
		this.balance = balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	public void withdraw(int money) {
		balance -= money;
	}
	public void showInfo() {
		System.out.println(accNum +"\t"+accName+"\t"+balance);
	}
}
