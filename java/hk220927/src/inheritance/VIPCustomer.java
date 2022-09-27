package inheritance;

public class VIPCustomer extends Customer {
	private int apendID;
	double saleRatio;
	
	public VIPCustomer() {
		super();// public Customer()
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		System.out.println("VIPCusomer() 생성자 호출");
	}
	public VIPCustomer(int customerID, String customerName,
			int apendID) {
		//Customer(int customerID, String customerName)
		super(customerID,customerName); 
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.apendID = apendID;
	}
	public int getAgentID() {
		return apendID;
	}
}
