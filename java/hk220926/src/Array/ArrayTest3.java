package Array;

public class ArrayTest3 {
	public static void main(String[] args) {
		double [] data = new double[5];
		int size = 0;
		// 0   1   2   3   4
		//0.0 0.0 0.0 0.0 0.0 
		data[0] = 100.0; size++; //1
		data[1] = 200.0; size++; //2
		data[2] = 300.0; size++; //3
		// 0      1      2      3    4
		//100.0  200.0  300.0  0.0  0.0
		// 저장된 값만 출력하세요.
		for(int idx = 0 ; idx < size ; idx++) {
			System.out.println(data[idx]);
		}
		
		for(int idx = 0 ; idx < data.length ; idx++) {
			System.out.println(data[idx]);
		}
		
		
		
		
		
	}
}
