import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M;
	static int[] minTree, maxTree, num;

	public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = (int) Math.pow(2, treeHeight + 1) - 1;

		minTree = new int[treeSize];
		maxTree = new int[treeSize];
		num = new int[N+1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(num));

		initMinTree(1, N, 1);
		initMaxTree(1, N, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			bw.write(getMin(1, N, 1, from, to) + " " + getMax(1, N, 1, from, to) + "\n");
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
	private static int initMinTree(int start, int end, int node) { // 최솟값 트리

		if (start == end) return minTree[node] = num[start];

		int mid = (start + end) / 2;

		return minTree[node] = Math.min(initMinTree(start, mid, node*2), initMinTree(mid + 1, end, node*2 + 1));

	}
	
	private static int initMaxTree(int start, int end, int node) { // 최댓값 트리
		
		if (start == end) return maxTree[node] = num[start];
		
		int mid = (start + end) / 2;
		
		return maxTree[node] = Math.max(initMaxTree(start, mid, node*2), initMaxTree(mid + 1, end, node*2 + 1));
		
	}

	// from ~ to 구간 최솟값
	private static int getMin(int start, int end, int node, int from, int to) {
		// 보고있는 노드의 구간이 원하는 범위 밖인 경우
		if (from > end || to < start) return Integer.MAX_VALUE;

		// 보고있는 노드의 구간이 원하는 범위 안인 경우
		if (from <= start && to >= end) return minTree[node];

		// 그 외 걸치는 경우는 재귀적으로 두 자식노드로 나눠서 최솟값 구하기
		int mid = (start + end) / 2;
		
		return Math.min(getMin(start, mid, node*2, from, to), getMin(mid + 1, end, node*2 + 1, from, to));
	
	}
	
	// from ~ to 구간 최댓값
	private static int getMax(int start, int end, int node, int from, int to) {
		// 보고있는 노드의 구간이 원하는 범위 밖인 경우
		if (from > end || to < start) return Integer.MIN_VALUE;
		
		// 보고있는 노드의 구간이 원하는 범위 안인 경우
		if (from <= start && to >= end) return maxTree[node];
		
		// 그 외 걸치는 경우는 재귀적으로 두 자식노드로 나눠서 최댓값 구하기
		int mid = (start + end) / 2;
		
		return Math.max(getMax(start, mid, node*2, from, to), getMax(mid + 1, end, node*2 + 1, from, to));
		
	}

}