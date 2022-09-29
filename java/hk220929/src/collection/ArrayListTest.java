package collection;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// 변수 : 1개 값
		// 배열 : 
		//	장점 : 여러개 값을 저장 : 
		//  단점 : 크기가 정해져 있다.
		// 컬렉션 : 크기를 가지지 않는 배열
		int i []= new int [3];
		i[0] = 1;
		i[1] = 2;
		i[2] = 3;
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1); // 0
		list1.add(2); // 1
		list1.add(3); // 2
		list1.add(4);
		list1.add(5);
		list1.add(6);
		list1.add(7);
		System.out.println(list1.get(0));
		
		for(int idx = 0; idx < list1.size(); idx++) {
			System.out.println(list1.get(idx));
		}
		
		for(int s: list1) {
			System.out.println(s);
		}
		list1.add(5);
		for(int s: list1) {
			System.out.println(s);
		}
	}

}
