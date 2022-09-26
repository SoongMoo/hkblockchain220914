package Array;

public class BookArray {

	public static void main(String[] args) {
		int i1 = 10;
		int i2 = 20;
		int i3 = 30;
		Book bk =  new Book();
		bk.setBookName("자바");
		bk.setAuthor("이숭무");
		Book bk1 = new Book();
		Book bk2 = new Book();
		
		int [] i = new int [3];
		i[0] = 10;
		i[1] = 20;
		i[2] = 30;
		Book [] library = new Book[3];
		library[0] = new Book();
		library[1] = new Book();
		library[2] = new Book();
		library[0].setBookName("데이터베이스");
		library[0].setAuthor("이상범");
		library[0].shoeBookInfo();
		library[1].setBookName("HTML");
		library[1].setAuthor("이장범");
		library[1].shoeBookInfo();
		library[2].setBookName("jsp");
		library[2].setAuthor("박준현");
		library[2].shoeBookInfo();
		
		
		for(int idx = 0; idx < i.length ; idx++) {
			System.out.println(i[idx]);
		}
		for(int idx = 0; idx < library.length ; idx++) {
			library[idx].shoeBookInfo();
		}
		
		

	}

}
