package hk220930;

public class Reference {
	int i;
	public int getI() {
		return i;
	}
	///             리터널변수
	///             parameter
	public void setI(int i) {
		// int i = 10;
		this.i = i;
		System.out.println(this.i);
		this.i = 2000;
		System.out.println(this.i);		
	}
	//        클래스형 변수 : 참조변수(reference 변수) / 주소변수 / 객체변수
	//                    힙영역 주소
	//                  10000번지
	public void setData(Reference1 r11) {
		//Reference1 r11 = new Reference1()
		r11.setY(30000);
		// 10000번지.setY(30);
		System.out.println("r11 : " + r11.getY());
	}
}
