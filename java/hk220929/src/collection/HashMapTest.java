package collection;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "이숭무"); // index 대신 key를 사용
		map.put(2, "이상범");
		map.put(3, "이장범");
		map.put(4, "박준현");
		
		System.out.println(map.get(1));
		System.out.println(map.get(3));
		map.put(3, "강원일"); // 키가 있는 경우 값이 수정
		System.out.println(map.get(3));
		map.put(5, "이장범"); // 키가 없는 경우에는 map에 추가
		
		map.put(10, "김찬중");
		
		System.out.println(map.keySet());
		
		for(Integer key : map.keySet()) {
			System.out.println(map.get(key));
		}

		// 삭제
		map.remove(8);
		System.out.println(map.get(8));
		map.remove(10);
		System.out.println(map.get(10));
		// 모두 삭제
		map.clear();
		System.out.println(map.isEmpty());
	}
}
