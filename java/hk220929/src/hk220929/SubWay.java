package hk220929;

public class SubWay {
	int lineNumber;
	int money;
	int passengerCount;
	SubWay(int lineNumber){
		this.lineNumber = lineNumber;
	}
	public void takeSub(int money) {
		this.money += money;
		passengerCount++;
	}
	public void showSubInfo() {
		System.out.println(lineNumber + "호선의 승객은 " +
				passengerCount + "명이고 수익금은 " +
				money +"원입니다.");
	}
}
