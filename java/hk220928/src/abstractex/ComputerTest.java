package abstractex;

public class ComputerTest {

	public static void main(String[] args) {
		// 추상클래스로는 객체 생성을 할 수없다.
		//Computer computer = new Computer();
		//NoteBook noteBook = new NoteBook();
		MyNoteBook myNoteBook = new MyNoteBook();
		DeskTop deskTop = new DeskTop();
	}

}
