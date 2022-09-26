package Array;

public class ArrayTest4 {
	public static void main(String[] args) {
		// 문자배열 만들기
		// 문자 변수
		char ch = 'A';
		System.out.println(ch);
		
		String str="hello";
		
		char ch1[] = new char[5];
		ch1[0] = 'h';
		ch1[1] = 'e';
		ch1[2] = 'l';
		ch1[3] = 'l';
		ch1[4] = 'o';
		
		for(int idx = 0; idx < ch1.length ; idx++) {
			System.out.print(ch1[idx]);
		}
		System.out.println();
		//  문자 배열 알파펫을 저장하자.
		char ch2 [] = new char[26];
		char cha = 'A';
		for(int idx = 0; idx < ch2.length ; idx++,cha++) {
			ch2[idx] = cha;
		}
		for(int idx = 0; idx <ch2.length ; idx++) {
			System.out.println(ch2[idx]);
		}
	}
}
