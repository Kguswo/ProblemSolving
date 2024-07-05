import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int init[], fin[], N, size, cnt, ans;
	public static void main(String[] args) throws FileNotFoundException {
		 Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		N = sc.nextInt();
		init = new int[N];
		fin = new int[N];
		size = init.length;
		cnt = 0; ans = 0;
		String start = sc.next();
		String end = sc.next();
		for (int i = 0; i < N; i++) {
			init[i] = start.charAt(i) - '0';
			fin[i] = end.charAt(i) - '0';
		}
		
		 // 1번 x
        cnt = 0;
		int[] dontpressfirstcopy = Arrays.copyOf(init, N);
		doSwitch(dontpressfirstcopy, fin);
		int dontpressfirst = cnt;

        // 1번 o
		cnt = 1;
		int[] pressfirstcopy = Arrays.copyOf(init, N);
		for(int i=0; i<=Math.min(size-1, 1); i++) pressfirstcopy[i] = Math.abs(pressfirstcopy[i] - 1);
		doSwitch(pressfirstcopy, fin);
		int pressfirst = cnt;
		
		if (dontpressfirst == -1 && pressfirst == -1) ans = -1;
		else if (dontpressfirst == -1) ans = pressfirst;
		else if (pressfirst == -1) ans = dontpressfirst;
		else ans = Math.min(dontpressfirst, pressfirst);
		
		System.out.println(ans);
	}
	private static void doSwitch(int[] init, int[] fin) {
		int[] initcopy = Arrays.copyOf(init, size);
		int[] fincopy = Arrays.copyOf(fin, size);
		
		for(int i=1; i<=size-1; i++) {
			if(initcopy[i-1] != fincopy[i-1]) {
				if(i==size-1) {
					for(int j=i-1; j<=i; j++) initcopy[j] = Math.abs(initcopy[j] - 1);
					cnt++;
				}
				else {
					for(int j=i-1; j<=i+1; j++) initcopy[j] = Math.abs(initcopy[j] - 1);
					cnt++;
				}
			}
		}
		cnt = Arrays.equals(initcopy, fincopy) ? cnt : -1;
	}
}
