package hk220916;

public class Ex07 {
	public static void main(String[] args) {
		float f1 = 3.141592f;
		float f2 = (float)3.141592; // 8byte => 4byte
		System.out.println(f1);
		System.out.println(f2);
		
		int mat = 90;
		int eng = 75;
		int total; // 합을 구하시오
		double avg; // 평균을 구하시오.
		total = mat + eng;
		System.out.println(total);
		avg = (double)total / 2;
		//    int  / int = int
		//    (double) int /  int
		//      double / int
		//      double / double
		System.out.println(avg);
		avg = total / 2.0;
		System.out.println(avg);
	}
}