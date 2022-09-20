package hk220920;

public class Ex14 {
	public static void main(String [] args) {
		int sum = 0;
		int i = 11;
		while(i <= 10) {
			sum+=i;
			i++;
		}
		System.out.println(sum);

		
		
		sum = 0;
		i = 11;
		do {
			sum+=i;
			i++;
		}while(i<=10);
		System.out.println(sum);
	}
}
