package Array;

public class ObjectCopy {

	public static void main(String[] args) {
		Book [] bookArray1 = new Book[3];
		Book [] bookArray2 = new Book[3];
		bookArray1[0] = new Book("자바", "이숭무");
		bookArray1[1] = new Book("데이터베이스", "이상범");
		bookArray1[2] = new Book("jsp", "이장범");
		
		bookArray2 = bookArray1; //(x)
		bookArray2[0].setBookName("박준현");
		
		System.out.println(bookArray2[0].getBookName());
		System.out.println(bookArray1[0].getBookName());
		int i = 10;
		int y = i;
		System.out.println(i);
		System.out.println(y);
		y = 20;
		
		// 깊은 복사
		Book [] bookArray3 = new Book[3];
		bookArray3[0] = new Book();
		bookArray3[1] = new Book();
		bookArray3[2] = new Book();
		for(int idx = 0; idx < bookArray3.length; idx ++) {
			bookArray3[idx].setBookName(bookArray1[idx].getBookName());
			bookArray3[idx].setAuthor(bookArray1[idx].getAuthor());
		}
		System.out.println(bookArray1[0].getAuthor());
		System.out.println(bookArray3[0].getAuthor());
		bookArray3[0].setAuthor("박준현");
		System.out.println(bookArray1[0].getAuthor());
		System.out.println(bookArray3[0].getAuthor());
	}

}
