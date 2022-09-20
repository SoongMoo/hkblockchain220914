package hk220920;

public class Ex03 {

	public static void main(String[] args) {
		System.out.println("7 * " + 1 + " = " + 7 * 1);
		System.out.println("7 * " + 3 + " = " + 7 * 3);
		System.out.println("7 * " + 5 + " = " + 7 * 5);
		System.out.println("7 * " + 7 + " = " + 7 * 7);
		System.out.println("7 * " + 9 + " = " + 7 * 9);
		
		System.out.println("===============");
		
		for(int i = 1; i <= 9 ; i+=2) {
			System.out.println("7 * " + i + " = " + 7 * i);
		}
		
		System.out.println("=========================");
		System.out.println("7 * " + 8 + " = " + 7 * 8);
		System.out.println("7 * " + 6 + " = " + 7 * 6);
		System.out.println("7 * " + 4 + " = " + 7 * 4);
		System.out.println("7 * " + 2 + " = " + 7 * 2);
		
		System.out.println("=====for=======");
		for(int i = 8; i >= 2; i-=2) {
			System.out.println("7 * " + i + " = " + 7 * i);
		}


	}

}
