package hk220920;

public class Ex10 {
	public static void main(String[] args) {
		int i ;
		int sum;
		for(i = 1, sum =0; i <= 10 ; i ++) {
			sum += i;
		}
		System.out.println(sum);
		
		for(i = 1,sum = 0 ; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		for(i = 1; i <= 1000; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
