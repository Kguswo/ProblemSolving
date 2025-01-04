/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	
	class Number {
	    long value;
	    int originalIndex;
	    Number(long value, int originalIndex) {
	        this.value = value;
	        this.originalIndex = originalIndex;
	    }
	}
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static ArrayList<Number>[] num;
	static final long MOD = 1000000007;
	static long size;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		size = N;
		num = new ArrayList[7];
		for(int i=0; i<7; i++) {
			num[i] = new ArrayList<Number>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			long n = Long.parseLong(st.nextToken());
			int m = (int) n % 7;
		    num[m].add(new Number(n % MOD, i));
		}
		
		long sumMod = 0; // 7로 나눈 나머지 ( 계속 추가됨 )
		long actualSum = 0;  // 실제 더할 값

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			long l = Long.parseLong(st.nextToken());
			
			long nextSumMod = ((sumMod + (l % 7)) % 7);
			
			//제거될 인덱스
			int idx = (7 - (int) (nextSumMod))%7;
			int l_size = num[idx].size();
			if(size - l_size == 0) {
				continue;
			}
			else {
				size -= l_size;
				num[idx].clear();
				actualSum = ((actualSum % MOD) + (l % MOD)) % MOD;
		        sumMod = nextSumMod;
			}
		}
		
		sb.append(size + "\n");
		
		ArrayList<Number> result = new ArrayList<>();
		for(int i = 0; i < 7; i++) {
		    for(Number n : num[i]) {
		        result.add(new Number(
		            ((n.value % MOD) + (actualSum % MOD)) % MOD, 
		            n.originalIndex
		        ));
		    }
		}

		// originalIndex 기준으로 정렬
		Collections.sort(result, (a, b) -> a.originalIndex - b.originalIndex);


		for(Number n : result) {
		    sb.append(n.value + " ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}