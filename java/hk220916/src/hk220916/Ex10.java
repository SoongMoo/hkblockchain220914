package hk220916;

public class Ex10 {
	public static void main(String []  args) {
		int i = 10;
		int j;
		j = ++i;
		// i = i + 1; j = i
		System.out.println(i); // 11
		System.out.println(j); // 11
		j = i ++;
		// j = i; i = i + 1
		System.out.println(j); // 11
		System.out.println(i); // 12
		
		int x = 10;
		int y;
		
		y = --x; // 선행연산자.
		// x = x - 1; y = x
		System.out.println(x); // 9
		System.out.println(y); // 9
		y = x--;
		// y = x; x = x - 1;
		System.out.println(y); // 9
		System.out.println(x); // 8
		
		
		// 대입 연산자
		int i1 = 10; 
		i1 = i1 + 1;
		System.out.println(i1); // 11
		i1++; // i1 = i1 + 1
		System.out.println(i1); //12
		i1+=1; // i1 = i1 + 1;
		System.out.println(i1); // 13
		i1 += 2; // i1 = i1 + 2;
		System.out.println(i1); // 15
		i1 += 3;
		System.out.println(i1); // 18
		i1 -= 3; // i1 = i1 - 3;
		System.out.println(i1);
		i1 *= 2;// i1 = i1 * 2;
		System.out.println(i1);
		i1 /= 2;// i1 = i1 / 2;
		System.out.println(i1);
		i1 %= 3; //i1 = i1 % 3;
		System.out.println(i1);
		
		String str = null; //'\0';	
	}
}