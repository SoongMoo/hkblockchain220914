package hk220916;

public class Ex06 {
	public static void main(String[] args) {
		int i = -(+10); // = 대입연산
		i = 10 + 20; // 
		++i;
		System.out.println((5>3)? 1: 0);
		// 산술 연산자(+,-,/,*, %)
		i = 10;
		int i1 = 20;
		int res = i1 + i;
		System.out.println(res);
		res = i1 / i;
		System.out.println(res);
		res = i1 * i;
		System.out.println(res);
		double d1 = 3;
		double d2 = 10;
		System.out.println(d2 % d1); // 10을 3으로 나눈 나머지
		// d2을 d1으로 나눈 몫을 구하시오
		System.out.println((int)(d2/d1));
	}
}
