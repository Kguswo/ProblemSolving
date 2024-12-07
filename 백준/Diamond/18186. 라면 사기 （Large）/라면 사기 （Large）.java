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
		long N = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long[] arr = new long[(int) (N+2)];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long minCnt = 0;
		if(B<C) {
			for(int i=0; i<N; i++){
				minCnt += B * arr[i];
			}
		}
		else {
			for(int i=0; i<N; i++) {
				if(arr[i+1] > arr[i+2]) {
					// 2개짜리
					long cycle = Math.min(arr[i], arr[i+1] - arr[i+2]);
					for(int j=0; j<2; j++) {
						arr[i+j] -= cycle;
					}
					minCnt += (B+C)*cycle;
				
					// 3개짜리
					cycle = Math.min(arr[i], Math.min(arr[i+1], arr[i+2])); 
					for(int j=0; j<3; j++) {
						arr[i+j] -= cycle;
					}
					minCnt += (B+2*C)*cycle;
					
					cycle = arr[i];
					arr[i] -= cycle;
					minCnt += B*cycle;
				}
				else {
					long cycle = Math.min(arr[i], Math.min(arr[i+1], arr[i+2])); 
					for(int j=0; j<3; j++) {
						arr[i+j] -= cycle;
					}
					minCnt += (B+2*C)*cycle;
					
					cycle = Math.min(arr[i], arr[i+1]);
					for(int j=0; j<2; j++) {
						arr[i+j] -= cycle;
					}
					minCnt += (B+C)*cycle;
					
					cycle = arr[i];
					arr[i] -= cycle;
					minCnt += B*cycle;
				}
			}
		}
		
		bw.write(String.valueOf(minCnt));
		bw.flush();
		bw.close();
		br.close();
	}
}