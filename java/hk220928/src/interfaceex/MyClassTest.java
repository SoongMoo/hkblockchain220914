package interfaceex;

public class MyClassTest {
	public static void main(String [] args ) {
		MyClass mClass = new MyClass();
		mClass.x();
		
		X x = mClass;
		x.x();
		
		Y y = mClass;
		y.y();
		
		MyInterface iClass = mClass;
		iClass.x();
		// 클래스 = > 클래스
		// 인터페이스 => 클래스
		// 인터페이스 => 인터페이스 => 클래스
		// 인터페이스
		//        ===> 클래스
		// 클래스
	}
}
