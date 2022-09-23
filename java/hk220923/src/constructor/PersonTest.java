package constructor;

public class PersonTest {

	public static void main(String[] args) {
		Member member = new Member();
		member.name = "hbbviis";
		Person person = new Person("이숭무", 172.5f, 75.9f);
		person.name = "bsvhs";
		person.print();
		
		Person person1 = new Person(); // 디펄트 생성자 
		person1.setData("박준현", 100.5f, 76.6f);
		person1.print();
		person1.setHeight(170.8f);
		person1.print();
		
		Person person2 = new Person("이상범");
		person2.print();
		person2.setHeight(197.0f);
		person2.setWeight(60.0f);
		person2.print();
		
		Person person3 = new Person();
		person3.setName("이장범");
		person3.setHeight(170.0f);
		person3.setHeight(50.6f);
		person3.print();
		
		

	}

}
