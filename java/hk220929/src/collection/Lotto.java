package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		ArrayList<Integer> lottoNum = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("구매 갯수를 입력하세요");
		int cnt = sc.nextInt();
		for(int num = 1 ; num <= cnt ; num++) {
			for(int i = 1 ; i <= 45 ; i++) {
				lottoNum.add(i);
			}
			// System.out.println(lottoNum);
			int lottoSize;
			for(int i = 1; i <= 6 ; i++){
				lottoSize = lottoNum.size();
				int idx = (int)(Math.random() * lottoSize); // 0~ 44
				int lotto = lottoNum.remove(idx);
				System.out.print(lotto + ", ");
			}
			lottoNum.clear();
			System.out.println();
		}
	}
}
