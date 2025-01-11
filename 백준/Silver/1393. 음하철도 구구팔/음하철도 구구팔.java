/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		int x0 = Integer.parseInt(st.nextToken());
		int y0 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int dx = Integer.parseInt(st.nextToken());
		int dy = Integer.parseInt(st.nextToken());
		
		int gcd = gcd(Math.abs(dx), Math.abs(dy));
	    if (gcd > 0) {
	        dx /= gcd;
	        dy /= gcd;
	    }
	    
	    long min = Long.MAX_VALUE;
	    int tx = x1, ty = y1;
	    
	    for (int t = 0; t < 200; t++) {
	        int currX = x1 + t * dx;
	        int currY = y1 + t * dy;
	        long dist = (long)(x0 - currX) * (x0 - currX) + (long)(y0 - currY) * (y0 - currY);
	        
	        if (dist < min) {
	            min = dist;
	            tx = currX;
	            ty = currY;
	        }
	    }
	    
	    bw.write(tx + " " + ty);
		bw.flush();
		bw.close();
		br.close();
	}

	private int gcd(int a, int b) {
		while (b != 0) {
	        int tmp = a % b;
	        a = b;
	        b = tmp;
	    }
	    return a;
	}
}