package hk220920;

public class Ex11 {

	public static void main(String[] args) {
		// 5단
		for (int i = 1; i <= 9; i++) {
			System.out.println("5 * " + i + " = " + 5 * i);
		}
		// 6단
		for (int i = 1; i <= 9; i++) {
			System.out.println("6 * " + i + " = " + 6 * i);
		}
		// 7단
		for (int i = 1; i <= 9; i++) {
			System.out.println("7 * " + i + " = " + 7 * i);
		}
		// 8단
		for (int i = 1; i <= 9; i++) {
			System.out.println("8 * " + i + " = " + 8 * i);
		}
		//      1           2        4        
		for(int dan = 5; dan <= 8; dan++) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(dan + " * " + i + " = " + dan * i);
			}
		}
		// 5단 while
		int gop = 1;
		while(gop<=9) {
			System.out.println("5 * " + gop + " = " + 5 * gop);
			gop++;
		}
		// 6단 while
		gop = 1;
		while(gop<=9) {
			System.out.println("6 * " + gop + " = " + 6 * gop);
			gop++;
		}
		// 7단 while
		gop = 1;
		while(gop<=9) {
			System.out.println("7 * " + gop + " = " + 7 * gop);
			gop++;
		}
		// 
		int dan = 5;
		while(dan <= 7) {
			gop = 1;
			while(gop<=9) {
				System.out.println(dan + " * " + gop + " = " + dan * gop);
				gop++;
			}
			dan++;
		}
	}
}
