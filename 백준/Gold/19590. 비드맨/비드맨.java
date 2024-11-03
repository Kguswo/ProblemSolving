/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N;
	static long[] bead;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		bead = new long[N];
		
		for(int i=0; i<N; i++) {
			long beadNum = Long.parseLong(br.readLine());
			bead[i] = beadNum;
		}
		
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
		
		for(long n : bead) 
			pq.offer(n);
		
		if(N==1) {
			bw.write(String.valueOf(bead[0]));
		}
		else {
			long max = pq.poll();
			
			long sum = pq.stream()
					.mapToLong(Long::longValue)
					.sum();
			
			long totalSum = sum + max;
			
			if(max > sum) {
				bw.write(String.valueOf(max - sum));
			}
			else {
				if(totalSum %2 == 0) bw.write(String.valueOf(0));
				else bw.write(String.valueOf(1));
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}