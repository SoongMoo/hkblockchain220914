package scheduler;

public class LeastJob implements Scheduler{

	@Override
	public void getNextCall() {
		// TODO Auto-generated method stub
		System.out.println("상담 전화를 순서대로 대기열에서 가져옵니다");
	}

	@Override
	public void sendCallToAgent() {
		// TODO Auto-generated method stub
		System.out.println("현재 상담업무가 없거나 "
				+ "상담대기가 가장 작은 상담원에게 할당합니다.");
	}
	
	public void ccc() {
		// TODO Auto-generated method stub
		System.out.println("상담 전화를 순서대로 대기열에서 가져옵니다");
	}
	
	public void ddd() {
		// TODO Auto-generated method stub
		System.out.println("현재 상담업무가 없거나 "
				+ "상담대기가 가장 작은 상담원에게 할당합니다.");
	}
}
