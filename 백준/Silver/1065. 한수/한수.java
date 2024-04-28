import java.util.Scanner;
 
public class Main {
    static int cnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(count(sc.nextInt()));
	}
 
	private static int count(int num) {
		if (num < 100) return num;
		else {
			cnt = 99;
			for (int i = 100; i <= num; i++) {
				if (((i / 100) - ((i / 10) % 10)) == (((i / 10) % 10) - (i % 10))) cnt++;
			}
		}
		return cnt;
	}
 
}