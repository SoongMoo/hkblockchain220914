package Array;

public class ForLoop {

	public static void main(String[] args) {
		String [] strArray = {"자바","데이터베이스","jsp"};
		for(int idx = 0 ; idx < strArray.length ; idx++) {
			System.out.println(strArray[idx]);
		}
		
		for(String str : strArray) {// "자바","데이터베이스","jsp"
			System.out.println(str);
		}
		int i [] = {1,2,3,4,5,6};
		for(int s : i) { // for each
			System.out.print(s);
		}
		
		
		double d []  = {1.0,2.0,3.0,4.0,5.0};
		for(double ff : d) {
			System.out.println(ff);
		}
	}

}
