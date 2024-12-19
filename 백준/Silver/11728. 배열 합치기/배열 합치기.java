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

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++){
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int num : list){
			sb.append(num).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}