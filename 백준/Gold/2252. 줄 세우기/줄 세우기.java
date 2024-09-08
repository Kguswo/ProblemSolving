/**
 * Author : nowalex322, Kim Hyeonjae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
	static int N, M, inDegree[];
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			arr.add(new ArrayList<>());
		}
		
		inDegree = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			arr.get(front).add(back);
			inDegree[back]++;
			
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			bw.write(curr + " ");
			for(int next : arr.get(curr)) {
				inDegree[next]--;
				if(inDegree[next]==0) queue.add(next);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
