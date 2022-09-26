package Array;

public class ArrayCopy {

	public static void main(String[] args) {
		int [] array1 = new int[]{10,20,30,40,50};
		int [] array2 = {1,2,3,4,5};
		System.out.println(array1[0]);
		System.out.println(array2[0]);
		System.out.println(array1); // [I@515f550a
		System.out.println(array2); // [I@626b2d4a
		// xxxxxx
		array2 = array1; // (x)
		// 얕은 복사
		System.out.println(array1[0]);
		System.out.println(array2[0]);
		
		array2[0] = 1;
		System.out.println(array2[0]); // 1
		System.out.println(array1[0]); // 10
		
		int [] array3 = {1,2,3,4,5};
		array3[0] = array1[0];
		array3[1] = array1[1];
		array3[2] = array1[2];
		System.out.println(array1[0]);
		System.out.println(array3[0]);
		array3[0] = 10;
		System.out.println(array1[0]);
		System.out.println(array3[0]);
		// 복사할 이 코드
		for(int idx = 0; idx < array1.length ; idx++) {
			array3[idx] = array1[idx];
		}
	}

}
