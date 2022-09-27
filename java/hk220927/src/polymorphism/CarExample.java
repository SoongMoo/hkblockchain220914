package polymorphism;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		for(int i = 1; i <=10 ; i++) {
			int problemLocation = car.run(); //1,2,3,4
			switch(problemLocation) {
			case 1 : 
				System.out.println("앞왼쪽 KumhoTire 교체");
				car.frontLeftTire = new KumhoTire("앞왼쪽", 17);break;
			case 2 : 
				System.out.println("앞오른쪽 KumhoTire 교체");
				car.frontRightTire = new KumhoTire("앞오른쪽", 17);break;
			case 3 : 
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.backLeftTire = new HankookTire("뒤왼쪽", 14);break;
			case 4 : 
				System.out.println("뒤오른쪽 HankookTire로 교체");
				car.backRightTire = new HankookTire("뒤오른쪽", 4);break;
			}
		}
		
	}

}
