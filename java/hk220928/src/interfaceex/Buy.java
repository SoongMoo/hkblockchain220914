package interfaceex;

public interface Buy {
	void buy(); // 추상 메서드
	
	default void order(){
		System.out.println("구매 주문");
	}
}
