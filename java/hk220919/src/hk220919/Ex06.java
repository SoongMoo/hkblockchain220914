package hk220919;

public class Ex06 {
	public static void main(String[] args) {
		int score = 75;
		String str = "합격";
		if (score >= 60) str = "합격";
		else str = "불합격";
		System.out.println(str);
		
		/// 삼항 연산자, 조건식 연산자
		str = (score >= 60) ? "합격" : "불합격" ;
		System.out.println(str);
		
		char grade = 'T';
		if (score  >= 60) grade = 'T';
		else grade = 'F';
		System.out.println(grade);
		// 삼항연산자.
		
		
		
		
	}
}
