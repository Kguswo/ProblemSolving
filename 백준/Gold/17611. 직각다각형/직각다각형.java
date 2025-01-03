/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, point[][], startX, startY, initialX, initialY, currX, currY, res=-1;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		point = new int[1000001][2]; // 0 : 세로, 1 : 가로
		
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken()) + 500000;
		startY = Integer.parseInt(st.nextToken()) + 500000;
		
		initialX = startX;
		initialY = startY;
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			currX = Integer.parseInt(st.nextToken()) + 500000;
			currY = Integer.parseInt(st.nextToken()) + 500000;
			
			if(startY == currY) { // 세로검사
				checkV(startX, currX);
			}
			else { // 가로검사
				checkH(startY, currY);
			}
			
			startX = currX;
			startY = currY;
		}
		
		if(startY == initialY) {
			checkV(startX, initialX);
		}
		else {
			checkH(startY, initialY);
		}
		
		for(int i=0; i<point.length; i++) {
			res = Math.max(res, Math.max(point[i][0], point[i][1]));
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void checkV(int r1, int r2) {
		int left = Math.min(r1, r2);
		int right = Math.max(r1, r2);
		for(int i=left; i<right; i++) {
			point[i][0]++;
//	        System.out.println("V : " + (i-500000) + ", value: " + point[i][0]);

		}
	}

	private static void checkH(int c1, int c2) {
		int up = Math.max(c1, c2);
		int down = Math.min(c1, c2);
		for(int i=down; i<up; i++) {
			point[i][1]++;
//	        System.out.println("H : " + (i-500000) + ", value: " + point[i][1]);

		}
	}
}