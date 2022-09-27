package inheritance;

public class CustomerTest2 {

	public static void main(String[] args) {
		// 묵시적 형 변환
		Customer vc = new VIPCustomer(1003,"나몰라", 2000);
		// 부모 클래스에 있는 멤버들만 사용 가능
		vc.bonusPoint= 1000;
		System.out.println(vc.getCustomerName()+"님이 지불해야 하는 "+
		"금액은 " +vc.calcPrice(10000)+"원입니다.");
		
	}

}
