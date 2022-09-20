package hk220920;

public class Ex08 {
	public static void main(String [] args) {
		int sum = 0;
		//     1         2       4
		for(int i = 1; i <= 10 ; i++) {
			sum += i;//3
		}
		// 1-2-3-4-2-3-4-....-3-4-2
		System.out.println(sum);
		System.out.println("====while====");
		sum = 0;
		int j = 1; // 1
		while(j <= 10) { //2
			sum += j; //3
			j++; //4
		}
		// 1-2-3-4-2-3-4-....-3-4-2
		System.out.println(sum);
	}
}
