package hk220919;

public class Ex08 {
	public static void main(String [] args) {
		// 8단의 곱을 랜덤으로 출력하기
		int num = (int)(Math.random()  * 9 ) + 1;// 1 ~ 9
		if (num == 1) {
			System.out.println(" 8 * 1 = 8" );
		}else if(num == 2) {
			System.out.println(" 8 * 2 = 16" );
		}else if(num == 3) {
			System.out.println(" 8 * 3 = " + 8 * 3 );
		}else if(num == 4) {
			System.out.println(" 8 * 4 = " + 8 * 4  );
		}else if(num == 5) {
			System.out.println(" 8 * 5 = " + 8 * 5  );
		}else if(num == 6) {
			System.out.println(" 8 * 6 = " + 8 * 6  );
		}else if(num == 7) {
			System.out.println(" 8 * 7 = " + 8 * 7 );
		}else if(num == 8) {
			System.out.println(" 8 * 8 = " + 8 * 8  );
		}else {
			System.out.println(" 8 * 9 = " + 8 * 9  );
		}
		System.out.println("======swith======");
		switch(num) {
		case 1: System.out.println(" 8 * 1 = " + 8 * 1  );break;
		case 2: System.out.println(" 8 * 2 = " + 8 * 2  );break;
		case 3: System.out.println(" 8 * 3 = " + 8 * 3  );break;
		case 8: System.out.println(" 8 * 8 = " + 8 * 8  );break;
		default : System.out.println(" 8 * 9 = " + 8 * 9  );break;
		case 5: System.out.println(" 8 * 5 = " + 8 * 5  );break;
		case 6: System.out.println(" 8 * 6 = " + 8 * 6  );break;
		case 4: System.out.println(" 8 * 4 = " + 8 * 4  );break;
		case 7: System.out.println(" 8 * 7 = " + 8 * 7  );break;
		}
	}
}