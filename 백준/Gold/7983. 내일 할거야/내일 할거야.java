/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	class Work implements Comparable<Work>{
		int time, end;
		public Work(int time, int end) {
			this.time = time;
			this.end = end;
		}
		
		@Override
		public int compareTo(Work o) {
			return o.end - this.end;
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

		int n = Integer.parseInt(br.readLine());
		Work[] work = new Work[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			work[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(work); // 내림차순
		
		int finalDay = work[0].end;
		for(int i=0; i<n; i++) {
			
			// 그리디한 시작날짜 선택
			if(work[i].end <= finalDay) finalDay = work[i].end - work[i].time;	
			else finalDay -= work[i].time;
		}

		bw.write(String.valueOf(finalDay));
		bw.flush();
		bw.close();
		br.close();
	}
}