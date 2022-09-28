package scheduler;

import java.io.IOException;

public class SchedulerTest {

	public static void main(String[] args) throws IOException {// TODO Auto-generated method stub
		Scheduler scheduler = null;
		System.out.println("전화 상담 할당 방식을 선택 하세요.");
		System.out.println("R : 한명씩 차례로 할당 ");
		System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
		System.out.println("P : 우선순위가 높은 고객 먼저 할당 ");
		int ch = System.in.read();
		if(ch == 'R' || ch == 'r') {
			scheduler = new RoundRobin();
		}else if(ch == 'L' || ch == 'l') {
			scheduler = new LeastJob();
		}else if(ch == 'P' || ch == 'p') {
			scheduler = new PriorityAllocation();
		}
		scheduler.getNextCall();
		scheduler.sendCallToAgent();		
	}

}
