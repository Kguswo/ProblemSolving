/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	
	class Coordinate implements Comparable<Coordinate>{
		int x, y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Coordinate o) {
			if(this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
	}
	
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
		
		int N = Integer.parseInt(br.readLine());
		Coordinate[] coordinate = new Coordinate[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			coordinate[i] = new Coordinate(x, y);
		}
		
		Arrays.sort(coordinate, (o1, o2) -> o1.x - o2.x);
        int pos_x = coordinate[N/2].x;
        
        Arrays.sort(coordinate, (o1, o2) -> o1.y - o2.y);
        int pos_y = coordinate[N/2].y;
		
		long res = 0;
		for(int i=0; i<N; i++) {
			res += (int) (Math.abs(coordinate[i].x - pos_x) + Math.abs(coordinate[i].y - pos_y));
		}
		
		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();
		br.close();
	}
}