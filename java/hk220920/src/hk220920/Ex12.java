package hk220920;

public class Ex12 {
	public static void main(String [] args) {
		// 4단을 3에서 8까지
		// 5단을 3에서 8까지
		// 6단을 3에서 8까지되는 이중 반복문을 만드시오.
		for(int dan = 4; dan <= 6 ; dan++) {
			for(int gop = 3; gop <= 8 ; gop++) {
				System.out.println(dan + " * " + gop + " = " + dan * gop);
			}
		}
		int dan = 4;
		while(dan <= 6) {
			int gop = 3;
			while (gop <= 8) {
				System.out.println(dan + " * " + gop + " = " + dan  * gop);
				gop++;
			}
			dan++;
		}
	}
}
