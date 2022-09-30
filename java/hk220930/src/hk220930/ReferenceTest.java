package hk220930;

public class ReferenceTest {

	public static void main(String[] args) {
		int i1 = 10;  // 리터널 변수
		Reference r = new Reference();
		//     argument
		r.setI(i1);
		System.out.println(i1);
		//      주소 변수 / 참조변수 / 객체변수 
		Reference1 r1 = new Reference1();
		///      10000번지
		r.setData(r1); // r.setData(100000번지);
		// 10000번지.setY(50);
		System.out.println("r1 : " + r1.getY());
	}
}
