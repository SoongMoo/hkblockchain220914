package hk220920;

public class Ex18 {
	public static void main(String[] args) {
		for(int gop = 1; ; gop++) {
			if(gop == 10) break;
			System.out.println("7 * " + gop +" = " + 7 * gop);	
		}
		for(int gop = 1; ; gop++) {
			System.out.println("7 * " + gop +" = " + 7 * gop);
			if(gop == 9) break;
		}
		int gop = 1;
		while(gop <= 1000) {
			if(gop == 10 ) break;
			System.out.println("7 * " + gop +" = " + 7 * gop);
			gop++;
		}
		
		gop = 1;
		while(gop <= 1000) {
			System.out.println("7 * " + gop +" = " + 7 * gop);
			if(gop == 9 ) break;
			gop++;
		}
	}
}
