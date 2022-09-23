package hk220923;

import constructor.Member;

public class PersonTest {

	public static void main(String[] args) {
		Member member = new Member();
		//member.name="nvbiosdxhg";
		// 객체 선언       // 객체 생성
		Person person = new Person(); // 디펄트 생성자
		             // 객체, 인스턴스
		// person.name = "이숭무"; // 은닉된 상태
		//    인스턴스변수
		//     호출메서드  // argument, 실안자, 전달인자
		person.setData("이숭무", 197.00f, 75.0f);
		// 객체(인스턴스)내에 있는 멤버필드(인스턴스 변수)에 초기화
		person.print();
		
		Person person1; // 객체 선언
		person1 = new Person(); // 객체 생성
		//  생성자 : 객체(인스턴스)내에 있는 멤버필드(인스턴스 변수)에 초기화
		Person_1 p = new Person_1("박준현", 197.00f, 75.0f);
		p.print();
		
		// 객체를 생성할 때는 생성자를 이용해서 객체를 생성한다.
	}
}
