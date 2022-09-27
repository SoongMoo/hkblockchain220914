package hk220927;

public class TwoDimension2 {

	public static void main(String[] args) {
		int [] i = {1,2,3,4};
		int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		for(int x[] : arr) {
			for(int y : x) {
				System.out.print(y);
			}
			System.out.println();
		}
		int [][] arr1 = {{1,2,3},{1,2},{1,2,3,4}};
		for(int x[] : arr1) {
			for(int y : x) {
				System.out.print(y);
			}
			System.out.println();
		}
		for(int x = 0; x < arr1.length; x++) {
			for(int y = 0; y < arr1[x].length ; y++) {
				System.out.print(arr1[x][y]);
			}
			System.out.println();
		}
	}

}
