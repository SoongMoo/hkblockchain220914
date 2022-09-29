package hk220929;

public class StringEquals {
	public static void main(String [] args) {
		//    객체변수/주소변수/참조변수
		String str1 = new String("이숭무");
		String str2 = new String("이숭무");
		char ch = 'A';
		char ch1 = 'A';
		System.out.println(str1 == str2); // false
		System.out.println(ch == ch1); // true
		
		System.out.println(str1.equals(str2));
		
		Integer i = new Integer(1);
		Integer i1 = new Integer(1);
		System.out.println(i == i1);
		System.out.println(i.equals(i1));
	}
}