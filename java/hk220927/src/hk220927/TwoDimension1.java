package hk220927;

public class TwoDimension1 {
	public static void main(String [] args) {
		int x = 1;
		int y = 2;
		int z = 3;
		int t[] = new int [3]; // 1차원 배열
		t[0] = 1; // x = 1
		t[1] = 2; // y = 2
		t[2] = 3; // z = 3
	
		int [] i1 = {1,2,3};
		int [] i2 = {10,20,30};
		int [] i3 = {100,200,300};
		System.out.println(i1[0]);
		
		                  //   행 열
		int [][] arr = new int[3][3];
		arr[0] = new int[]{1,2,3}; // i1 = {1,2,3}
		arr[1] = new int[] {10,20,30}; //i2 = {10,20,30}
		arr[2] = new int[] {100,200,300};// i3 = {100,200,300}

		int [][] arr1 = new int[3][4];
		arr1[0] = new int[4];
		arr1[1] = new int[4];
		arr1[2] = new int[4];
		/*      0  1  2  3
		 * 	0  00  01 02 03
		 *  1  10  11 12 13
		 *  2  20  21 22 23
		 */
		arr1[0][0] = 1;
		arr1[0][1] = 2;
		arr1[0][2] = 3;
		arr1[0][3] = 4;
		arr1[1][0] = 10;
		arr1[1][1] = 20;
		arr1[1][2] = 30;
		arr1[1][3] = 40;
		arr1[2][0] = 100;
		arr1[2][1] = 200;
		arr1[2][2] = 300;
		arr1[2][3] = 400;
		System.out.println(arr1[0][2]);
		
		for(int i = 0; i < 3; i++) {
			for(int y1 =0 ; y1 < 4; y1++ ) {
				System.out.println(arr1[i][y1]);
			}
		}
		// 1차원 배열의 크기
		int [] i11= new int[3];
		System.out.println(i11.length);
		// 행의 크기 : 2차원 배열의 크기
		System.out.println(arr1.length);
		// 열의 크기 : 1차원배열의 크기
		System.out.println(arr1[0].length);
		
		for(int i = 0; i < arr1.length; i++) {
			for(int y1 =0 ; y1 < arr1[i].length; y1++ ) {
				System.out.println(arr1[i][y1]);
			}
		}
		for(int [] a : arr1) {
			for(int b : a) {
				System.out.println(b);
			}
		}
		
		i11[0] = 1;
		i11[2] = 2;
		i11[1] = 3;
		for(int i = 0; i < 3; i++) {
			System.out.println(i11[i]);
		}
		for(int s : i11) {
			System.out.println(s);
		}
		
		
		
		
		
		
	}
}
