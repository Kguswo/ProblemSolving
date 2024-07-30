import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, K;
	static long[] tree, num;

	public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

		int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (treeHeight + 1);

		tree = new long[treeSize];
		num = new long[N+1];

		for (int i = 1; i <= N; i++) {
			num[i] = Long.parseLong(br.readLine());
		}
//		System.out.println(Arrays.toString(num));

		init(1, N, 1);

		for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 숫자 업데이트
                update(1, N, 1, b, c);
                num[b] = c;
            } 
            else { // a==2 인 경우 - 합계산
                bw.write(sum(1, N, 1, b, (int) c) + "\n");
            }                       
            
        }
		
        bw.flush();
        bw.close();
        br.close();

	}

	/*
	 * 세그먼트 트리 초기화 
	 * node : 세그먼트 트리의 정점 번호 
	 * start : 이 정점이 관리하는 연속 구간의 왼쪽 끝 
	 * end : 이 정점이 관리하는 연속 구간의 오른쪽 끝
	 * 
	 */
	private static long init(int start, int end, int node) { // 최솟값 트리

		if (start == end) return tree[node] = num[start];

		int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node*2) + init(mid + 1, end, node*2 + 1);

	}

	/*
	 * 세그먼트 트리 갱신 
	 * node : 세그먼트 트리의 정점 번호 
	 * start : 이 정점이 관리하는 연속 구간의 왼쪽 끝 
	 * end : 이 정점이 관리하는 연속 구간의 오른쪽 끝
	 * idx : 업데이트할 위치
	 * value : 새로 업데이트 할 값
	 * 
	 */	
	private static void update(int start, int end, int node, int idx, long value) {
		
        if (idx < start || end < idx) return;

		// 리프 노드시 변경
        if (start == end) {
            tree[node] = value;
            return;
        }
		
	    else {
	    	int mid = (start + end) / 2;
		        
	    	// 왼쪽자식구간
	        update(start, mid, node * 2, idx, value);
	        
	        // 오른쪽자식구간
	        update(mid + 1, end, node * 2 + 1, idx, value);		        

	        // 부모노드도 합 바뀌니까 자식 노드 업데이트 후 바뀐 자식 합으로 계산 다시해줌 
		    tree[node] = tree[node * 2] + tree[node * 2 + 1];
	    }

	        
	}
	
	// from ~ to 구간합
	private static long sum(int start, int end, int node, int from, int to) {
		
		// 덧셈 항등원 사용
		if (to < start || end < from) return 0;

        if (from <= start && end <= to) return tree[node];

        int mid = (start + end) / 2;
        
        return sum(start, mid, node * 2, from, to) + sum(mid + 1, end, node * 2 + 1, from, to);
	}
	
}