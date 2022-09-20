package hk220920;

public class Ex07 {

	public static void main(String[] args) {
		// while
		int sum = 0;
		for(int i = 1; i <= 10 ; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		int i = 1;
		for(; i <= 10 ; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		i = 1;
		for(; i <= 10 ; ) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		
		
		sum = 0;
		i = 1;
		while( i <= 10  ) {
			sum += i;
			i++;
		}
		System.out.println(sum);

	}

}
