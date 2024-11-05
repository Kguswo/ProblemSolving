/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            sb.append(move(x, y)+"\n");
        }
        bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int move(int x, int y) {
        long len = y - x;
        
        long root = (long)Math.sqrt(len);
     
        if (len <= root * root) {
            return (int) (root * 2 - 1);
        } else if (len <= root * (root + 1)) {
            return (int) (root * 2);
        } else {
            return (int) (root * 2 + 1);
        }
    }
}