package abstractex;

// 추상클래스는 꼭 상속해서 재 정의해서 사용해야 한다.
public abstract class Computer { // 추상 클래스
	int num1;
	static int num2;
	final int num3 = 10;

	public abstract void display(); // 추상 메서드
	public abstract void typing();
	public void turnOn()
	{
		System.out.println("전원을 켭니다.");
	}
	public void turnOff()
	{
		System.out.println("전원을 끕니다.");
	}
}
