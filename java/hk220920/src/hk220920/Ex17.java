package hk220920;

public class Ex17 {

	public static void main(String[] args) {
		// continue
		//7단
		for(int gop = 1; gop <= 9; gop++ ) {
			System.out.println("7 * " + gop + " = " + 7 * gop);
		}
		//  홀수곱만 출력하시오,.
		for(int gop = 1; gop <= 9; gop+=2 ) {
			System.out.println("7 * " + gop + " = " + 7 * gop);
		}
		for(int gop = 1; gop <= 9; gop++ ) {
			if(gop % 2 == 0) continue;
			System.out.println("7 * " + gop + " = " + 7 * gop);
		}
		//  짝수곱만 출력하시오,.
		for(int gop = 1; gop <= 9; gop++ ) {
			if(gop % 2 == 1) continue;
			System.out.println("7 * " + gop + " = " + 7 * gop);
		}
	}

}
