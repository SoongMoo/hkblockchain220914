package hk220929;

public class ToStringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book(200, "개미");
		System.out.println(book1);
		System.out.println(book1.toString());
		
		String str = new String("hello java");
		String str1 = "이숭무";
		System.out.println(str);
		System.out.println(str.toString());
		
		Integer i = new Integer(10);
		Integer i1 = 10;
		System.out.println(i);
		System.out.println(i.toString());
	}

}
