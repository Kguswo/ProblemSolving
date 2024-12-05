/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	class Checker{
		int x;
		int y;
		Checker(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int[] x_arr = new int[N];
		int[] y_arr = new int[N];
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Checker[] checker = new Checker[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			x_arr[i] = x;
			y_arr[i] = y;
			checker[i] = new Checker(x, y);
		}
		
		List<Integer> distances = new ArrayList<Integer>();
		for(int i=0; i<x_arr.length; i++) {
			for(int j=0; j<y_arr.length; j++) {
				distances.clear();
				int dis = 0;
				for(Checker c : checker) {
					distances.add(getDis(x_arr[i], y_arr[j], c));
				}
				
				Collections.sort(distances);
				
				int cnt = 0;
				for(int k=0; k<distances.size(); k++) {
					cnt += distances.get(k);
					dist[k] = Math.min(cnt, dist[k]);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(dist[i] + " ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private int getDis(int i, int j, Checker c) {
		return (int) Math.abs(i-c.x) + Math.abs(j-c.y);
		
	}
}