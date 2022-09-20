package hk220920;

public class Ex09 {

	public static void main(String[] args) {
		// 5단을 for
		for(int gop = 1; gop <= 9; gop++) {
			System.out.println("5 * " + gop + " =" + 5 * gop);
		}
		// while
		int gop =1;
		while (gop <= 9) {
			System.out.println("5 * " + gop + " =" + 5 * gop);
			gop++;
		}
		
		/*
		 * 3 * 3 = 9 
		 * 3 * 4 = 12 
		 * 3 * 5 = 15 
		 * 3 * 6 = 18 
		 * 3 * 7 = 21
		 */
		// for
		for(gop =3 ; gop <= 7; gop++ ) {
			System.out.println("3 * " + gop + " =" + 3 * gop);
		}
			
		// while
		gop = 3;
		while(gop <= 7) {
			System.out.println("3 * " + gop + " =" + 3 * gop);
			gop++;
		}
	}
}
