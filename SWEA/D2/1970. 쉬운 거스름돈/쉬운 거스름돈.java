import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int T, money;
	static int[] dp;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc<= T; tc++) {
			System.out.println("#"+tc);
			money=sc.nextInt();
			dp = new int[money+1];
			list = new LinkedList<Integer>();
			
			list.add(money / 50000);
			money %= 50000;
			list.add(money / 10000);
			money %= 10000;
			list.add(money / 5000);
			money %= 5000;
			list.add(money / 1000);
			money %= 1000;
			list.add(money / 500);
			money %= 500;
			list.add(money / 100);
			money %= 100;
			list.add(money / 50);
			money %= 50;
			list.add(money / 10);
			money %= 10;
			for(int a : list) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}