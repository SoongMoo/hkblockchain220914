package classMethod;

public class Ex01 {

	public static void main(String[] args) {
		String name = "이숭무";
		int age = 15;
		String addr = "성남";
		System.out.println(age +"세인 " 
		          + name +"은 "+addr+"에 살아요.");
		
		String name1 = "장인호";
		int age1 = 15; 
		
		Member member = new Member();
		/*	name;
			age;
			addr;
		 */
		member.addr = "성남";
		member.age = 15;
		member.name ="이숭무";
		
		Member member1 = new Member();
						//  객체/인스턴스
		// heap영역에 만들어진 모든 것을 객체라고 한다.
		member1.name = "장인호";
		
		Member member2 = new Member();
		member2.name= "bdskjbgv";
		
		Member_1 aaa = new Member_1();
		// aaa.name ="vcvhjv";
		// name
		// age
		// addr
		// setData()
		// print()
		// 호출 메서드
		// 피호출메서드에 있는 parameter에 값을 전달 하기 위해서 사용
		//         argument / 실인자 / 전달 인자
		aaa.setData("이숭무", 15 , "성남");
		aaa.print();
		Member_1 i = new Member_1();
		aaa.setName("장인호");
		aaa.print();
		// 호출메서드
		String addr11 = aaa.getAddr();// 성남
		System.out.println(addr11);
	}
}
