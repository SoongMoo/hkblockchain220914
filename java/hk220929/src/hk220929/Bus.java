package hk220929;

public class Bus {
	int busNumber;
	int money;
	int passengerCount;
	Bus(int busNumber){
		this.busNumber = busNumber;
	}
	public void takeBus(int money) {
		this.money += money;
		passengerCount++;
	}
	public void showBusInfo() {
		System.out.println(busNumber + "번의 승객은 " +
				passengerCount + "명이고 수익금은 " +
				money +"원입니다.");
	}
}
