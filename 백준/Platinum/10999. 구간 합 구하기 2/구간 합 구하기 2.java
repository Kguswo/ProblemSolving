import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, K;
	static long[] tree, lazy, num;

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
        lazy = new long[treeSize];
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
                long d = Long.parseLong(st.nextToken());
                update_range(1, N, 1, b, (int) c, d);
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

	
	/**
	 * Lazy propagation을 통해 현재 노드의 지연 값을 처리
	 * 노드의 지연 값(lazy[node])이 0이 아니면, 이 값을 현재 노드에 적용하고 자식 노드에 전달
	 * 
	 * @param start
	 * @param end
	 * @param node
	 */
	private static void update_lazy(int start, int end, int node) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }
	
	/*
	 * 세그먼트 트리 갱신 
	 * node : 세그먼트 트리의 정점 번호 
	 * start : 이 정점이 관리하는 연속 구간의 왼쪽 끝 
	 * end : 이 정점이 관리하는 연속 구간의 오른쪽 끝
	 * from ~ to : 업데이트할 구간
	 * diff : 새로 더할 차이값
	 * 
	 */	
	private static void update_range(int start, int end, int node, int from, int to, long diff) {
        
		update_lazy(start, end, node);

        if (to < start || end < from) return;

        if (from <= start && end <= to) {
            tree[node] += (end - start + 1) * diff;
            if (start != end) {
                lazy[node*2] += diff;
                lazy[node*2+1] += diff;
            }
            return;
        }

        int mid = (start + end) / 2;
        update_range(start, mid, node*2, from, to, diff);
        update_range(mid+1, end, node*2+1, from, to, diff);

        tree[node] = tree[node*2] + tree[node*2+1];
    }
	
	// from ~ to 구간합
	private static long sum(int start, int end, int node, int from, int to) {
		
		// 현재 노드의 lazy 값을 처리한 후에 업데이트 적용
        update_lazy(start, end, node);
        
		// 덧셈 항등원 사용
		if (to < start || end < from) return 0;

        if (from <= start && end <= to) return tree[node];

        int mid = (start + end) / 2;
        
        return sum(start, mid, node * 2, from, to) + sum(mid + 1, end, node * 2 + 1, from, to);
	}
	
}