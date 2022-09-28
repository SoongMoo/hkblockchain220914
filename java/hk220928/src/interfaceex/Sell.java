package interfaceex;

public interface Sell {
	void sell();
	
	default void order1(){
		System.out.println("판매 주문");
	}
}
