package hk220919;

public class Ex10 {
	public static void main(String[] args) {
		int score = 77;
		if(score >= 90) {
			System.out.println("A");
		}else if(score >= 80) {
			System.out.println("B");
		}else if(score >= 70) {
			System.out.println("C");
		}else if(score >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		System.out.println("=====이중 조건문 =====");
		if(score >= 90) {
			if(score>=95)System.out.println("A+");
			else System.out.println("A");
		}else if(score >= 80) {
			if(score>=85)System.out.println("B+");
			else System.out.println("B");
		}else if(score >= 70) {
			if(score>=75)System.out.println("C+");
			else System.out.println("C");
		}else if(score >= 60) {
			if(score>=65)System.out.println("D+");
			else System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
}
