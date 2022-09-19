package hk220919;

public class Ex07 {
	public static void main(String [] args) {
		/*
		 * 조건문 : 
		 * if , if ~ else, 
		 * if ~ else if ~ else if ~ ... ~ else
		 * swith ~ case
		 */
		/*
		 * int i = 10; 
		 * if( i == 20) : 단일값 
		 * if( i <= 20) : 범위값
		 */
		// Math.random() : 0 < Math.random() < 1
		// 0.0000000000001 * 6 : 0.00000000006
		// 0.9999999999999 * 6 : 5.99999999999
		 System.out.println((int)(Math.random() * 6) + 1);
		 // 0 ~ 5
		 int num = (int)(Math.random() * 6) + 1;
		 if(num == 1)
			 System.out.println("1입니다.");
		 else if(num == 2)
			 System.out.println("2입니다.");
		 else if(num == 3)
			 System.out.println("3입니다.");
		 else if(num == 4)
			 System.out.println("4입니다.");
		 else if(num == 5)
			 System.out.println("5입니다.");
		 else
			 System.out.println("6입니다.");
		 System.out.println("======swith======");
		 switch(num) {
		 // if(num == 1){System.out.println("1입니다.");}
		 case 1 : System.out.println("1입니다.");break;
		 // if (num == 2)
		 case 2 : System.out.println("2입니다.");break;
		 case 3 : System.out.println("3입니다.");break;
		 case 4 : System.out.println("4입니다.");break;
		 case 5 : System.out.println("5입니다.");break;
		 default : System.out.println("6입니다.");
		 }
	}
}







