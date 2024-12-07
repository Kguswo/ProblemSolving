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

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int minCnt = 0;
		for(int i=0; i<N; i++) {
			if(arr[i+1] > arr[i+2]) {
				// 2개짜리
				int cycle = Math.min(arr[i], arr[i+1] - arr[i+2]);
				for(int j=0; j<2; j++) {
					arr[i+j] -= cycle;
				}
				minCnt += 5*cycle;
			
				// 3개짜리
				cycle = Math.min(arr[i], Math.min(arr[i+1], arr[i+2])); 
				for(int j=0; j<3; j++) {
					arr[i+j] -= cycle;
				}
				minCnt += 7*cycle;
				
				cycle = arr[i];
				arr[i] -= cycle;
				minCnt += 3*cycle;
			}
			else {
				int cycle = Math.min(arr[i], Math.min(arr[i+1], arr[i+2])); 
				for(int j=0; j<3; j++) {
					arr[i+j] -= cycle;
				}
				minCnt += 7*cycle;
				
				cycle = Math.min(arr[i], arr[i+1]);
				for(int j=0; j<2; j++) {
					arr[i+j] -= cycle;
				}
				minCnt += 5*cycle;
				
				cycle = arr[i];
				arr[i] -= cycle;
				minCnt += 3*cycle;
			}
		}
		
		bw.write(String.valueOf(minCnt));
		bw.flush();
		bw.close();
		br.close();
	}
}