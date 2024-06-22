import java.util.*;
 
public class Main {
 
	private static int[][] map;
	private static int[][] dir = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		int h = r2 - r1 + 1;
		int w = c2 - c1 + 1;
		map = new int[h][w];
 
		int x = 0, y = 0, d = 0, num = 1, cnt = 0, wCnt = 0, dCnt = 1;
		while (true) {
			if(wCnt >= h*w) {
				break;
			}
			if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
				map[x - r1][y - c1] = num;
				wCnt++;
			}
			num++;
			cnt++;
			x = x + dir[d][0];
			y = y + dir[d][1];
			if (cnt == dCnt) {
				cnt = 0;
				if (d == 1 || d == 3)
					dCnt++;
				d = (d + 1) % 4;
			}
		}
        
		int blank = (int)(Math.log10(num)+1);
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int len = (int)(Math.log10(map[i][j])+1);
				for (int k = 0; k < blank-len; k++) {
					System.out.print(" ");
				}
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}