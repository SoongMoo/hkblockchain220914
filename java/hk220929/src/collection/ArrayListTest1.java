package collection;

import java.util.ArrayList;

public class ArrayListTest1 {

	public static void main(String[] args) {// TODO Auto-generated method stub
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("이숭무");
		list1.add("이상범");
		
		list1.add("이상범");
		list1.add("이장범");
		
		System.out.println(list1.subList(1, 1 + 2));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 1+2));
		
		System.out.println(list2);
		
		for(String s : list1) {
			System.out.println(s);
		}
		list1.add(2, "박준현");
		for(String s : list1) {
			System.out.println(s);
		}
		list1.remove(3);
		for(String s : list1) {
			System.out.println(s);
		}
		list1.remove("이상범");
		for(String s : list1) {
			System.out.println(s);
		}
		list1.clear();
		System.out.println(list1.isEmpty());
		System.out.println(list1.size());
	}

}
