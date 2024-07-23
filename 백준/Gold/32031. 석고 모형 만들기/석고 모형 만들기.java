import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
    static StringTokenizer st;
    static int[] parents = new int[320000];
    static int R, C, extended_R, extended_C, ans;
    static char[][] c = new char[200][201];
    public static void main(String[] args) throws IOException {
      br = new BufferedReader(new InputStreamReader(System.in));
 //       br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    	extended_R = R * 2;
    	extended_C = C * 2;

        Arrays.fill(parents, -1);

        for (int i = 0; i < R; i++) {
            c[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
            	cylinder(i, j, c[i][j]);
                connect(i, j);
            }
        }

		/*
		 * 결과 계산 루트 노드 값이 음수인 것의 개수 셈
		 * 이 개수가 연결되지 않은 영역의 수
		 */        
        ans = 0;
        for (int i = 0; i < 8* R * C; i++) {
            if (parents[i] < 0) ans++;
        }
        
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int x) {
        if (parents[x] < 0) return x;
        return parents[x] = find(parents[x]);

//        return parents[x] < 0 ? x : (parents[x] = find(parents[x]));
    }

    public static boolean isDivided(int x, int y) {
        x = find(x);
        y = find(y);
        // 붙어있으면
        if (x == y) return false;
        // 나뉘어졌으면
        parents[x] += parents[y]; // 집합 합치기
        parents[y] = x; // y의 부모를 x로
        return true;
    }

    public static void cylinder(int r, int c, char cylinder) {
    	/* 
    	 *  2x2 셀로 확장
    	 * (r, c) -> (2r, 2c), (2r, 2c+1), (2r+1, 2c), (2r+1, 2c+1)
    	 * (2r, 2c)     : a[0](1층) a[4](2층)
    	 * (2r, 2c+1)   : a[1](1층) a[5](2층)
    	 * (2r+1, 2c)   : a[2](1층) a[6](2층)
    	 * (2r+1, 2c+1) : a[3](1층) a[7](2층)
    	 * 
    	 */
        int doubled_r = r * 2, doubled_c = c * 2;
        int[] arr = new int[8];
        // 3차원을 1차원으로!
        // 2배 확대시킨 위치 인덱스 a[0] ~ a[3]
        arr[0] = doubled_r * extended_C + doubled_c;
        arr[1] = doubled_r * extended_C + doubled_c + 1;
        arr[2] = (doubled_r + 1) * extended_C + doubled_c;
        arr[3] = (doubled_r + 1) * extended_C + doubled_c + 1;
        
        // a[0] ~ a[3]가 2층에 위치한 형태
        for (int k = 4; k < 8; k++) arr[k] = arr[k - 4] + extended_R * extended_C;
        
        if (cylinder == 'O') {        	
        	isDivided(arr[0], arr[4]);
            isDivided(arr[1], arr[5]);
            isDivided(arr[2], arr[6]);
            isDivided(arr[3], arr[7]);
        }
        else if (cylinder == 'I') {
            isDivided(arr[0], arr[2]);
            isDivided(arr[1], arr[3]);
            isDivided(arr[4], arr[6]);
            isDivided(arr[5], arr[7]);
        }
        else if (cylinder == 'H') {
            isDivided(arr[0], arr[1]);
            isDivided(arr[2], arr[3]);
            isDivided(arr[4], arr[5]);
            isDivided(arr[6], arr[7]);
        }
    }

    public static void connect(int r, int c) {
        int doubled_r = r * 2, doubled_j = c * 2;
        int[] arr = new int[8];
        arr[0] = doubled_r * extended_C + doubled_j + 1;
        arr[1] = (doubled_r + 1) * extended_C + doubled_j + 1;
        arr[2] = (doubled_r + 1) * extended_C + doubled_j;
        arr[3] = (doubled_r + 1) * extended_C + doubled_j + 1;
        
        for (int k = 4; k < 8; k++) arr[k] = arr[k - 4] + extended_R * extended_C;
        
        for (int k = 0; k < 8; k++) {
        	// a[0], a[1], a[4], a[5]면서 마지막 열이 아닐때 가로로 연결
            if (k % 4 <= 1 && c + 1 < C) isDivided(arr[k], arr[k] + 1);
            
            // a[2], a[3], a[6], a[7]면서 마지막 행이 아닐때 세로로 연결
            if (k % 4 > 1 && r + 1 < R) isDivided(arr[k], arr[k] + extended_C);
        }
    }
}
