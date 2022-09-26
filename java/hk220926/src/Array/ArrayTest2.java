package Array;

public class ArrayTest2 {
	public static void main(String[] args) {
		double [] data = new double[5];
		data[0] = 10.0;
		data[1] = 20.0;
		data[2] = 30.0;
		System.out.println(data.length);
		for (int idx = 0 ; idx < 5; idx++) {
			System.out.println(data[idx]);
		}
		for (int idx = 0 ; idx < data.length; idx++) {
			System.out.println(data[idx]);
		}
		int [] i = new int[] {100,200,300};
		for(int idx = 0; idx < i.length ; idx++) {
			System.out.println(i[idx]);
		}
		// 마지막 요소의 값을 출력하세요
		System.out.println(i[ i.length -1 ]);
		i[ i.length -1 ] = 1000; // i[2] = 1000;
		System.out.println(i[ i.length -1 ]);
		int a = 2;
		System.out.println(i[a]);
	}
}






