package hk220927;

public class TwoDimension {
	public static void main(String [] args) {
		int [] i1 = new int [3];
		int [] i2 = new int [3];
		int [] i3 = new int [3];
		int [] i4 = new int [3];
		
		int [][] arr = new int[4][3];
		arr[0] = i1 ;
		arr[1] = i2 ;
		arr[2] = i3 ;
		arr[3] = i4 ;
		
		int [][] arr1 = new int [4][3];
		arr1[0] = new int [3];
		arr1[1] = new int [3];
		arr1[2] = new int [3];
		arr1[3] = new int [3];
		
		arr1[0][0] = 10;
		arr1[1][2] = 30;
		
		int i11 [] = new int[3];
		for(int y = 0; y < 3; y++) {
			i11[y] = y;
		}
		for(int x = 0; x < 4 ; x++) {
			for(int y = 0; y < 3; y++) {
				arr1[x][y] = y;
			}
		}
		for(int x = 0; x < arr1.length ; x++) {
			for(int y = 0; y < arr1[x].length; y++) {
				System.out.println(arr1[x][y]);
			}
		}
	}
}
