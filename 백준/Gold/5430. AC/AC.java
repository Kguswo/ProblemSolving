/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N;
	static String command, nums;
	static Deque<Integer> dq = new ArrayDeque<Integer>();
	static boolean isError, isReversed;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			dq.clear();
			isError = false;
			isReversed = false;
			
			command = br.readLine();
			N = Integer.parseInt(br.readLine());
			nums = br.readLine();
			
			if(N == 0) {
				for(int i=0; i<command.length(); i++) {
					if(command.charAt(i) == 'R') continue;
					else {
						isError = true;
						break;
					}
				}
			}
			else {
				String[] split = nums.substring(1, nums.length()-1).split(",");
	//			System.out.println(Arrays.toString(split));
				for(String s : split) dq.offer(Integer.parseInt(s));
				
				for(int i=0; i<command.length(); i++) {
					if(command.charAt(i) == 'R') isReversed = !isReversed;
					else {
						if(dq.isEmpty()) {
							isError = true;
							break;
						}
						
					    if(isReversed) dq.pollLast();
					    else dq.pollFirst();
					}
				}
			}
			if(isError) sb.append("error").append("\n");
			else {
//				if(isReversed) {
//					List<Integer> tmp = new ArrayList<Integer>();
//					while(!dq.isEmpty()) tmp.add(dq.pollLast());
//					sb.append(Arrays.toString(tmp.toArray())).append("\n");
//				}
//			    else sb.append(Arrays.toString(dq.toArray())).append("\n");
				sb.append("[");
			    if(isReversed) {
			        List<Integer> tmp = new ArrayList<>();
			        while(!dq.isEmpty()) tmp.add(dq.pollLast());
			        for(int i = 0; i < tmp.size(); i++) {
			            sb.append(tmp.get(i));
			            if(i < tmp.size() - 1) sb.append(",");
			        }
			    } else {
			        int size = dq.size();
			        for(int i = 0; i < size; i++) {
			            sb.append(dq.pollFirst());
			            if(i < size - 1) sb.append(",");
			        }
			    }
			    sb.append("]\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}