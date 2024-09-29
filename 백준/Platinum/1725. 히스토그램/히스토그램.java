/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, tree[], num[];
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
			n = Integer.parseInt(br.readLine());
			
			num = new int[n+1];
			for(int i=1; i<=n; i++) {
				num[i] = Integer.parseInt(br.readLine());
			}
			
			tree = new int[4*n];
			init(1, n, 1);
			
			long maxRecS = getMaxRectangle(1, n);
			sb.append(maxRecS).append("\n");
		
        bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}

	/**
	 * a~b 까지 최대 직사각형 S 계산 후
	 * 좌우 분할정복으로 다시 계산 ( 다이아몬드 모양 )
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	private long getMaxRectangle(int left, int right) {
        if (left > right) return 0;

		long maxS = 0L;
		long tmpS = 0L;
		int idx = getMinH(1, n, 1, left, right);
		
		maxS = (long)(right-left+1) * (long)num[idx];

		tmpS = getMaxRectangle(left, idx-1);
        maxS = Math.max(maxS, tmpS);
        
        tmpS = getMaxRectangle(idx+1, right);
        maxS = Math.max(maxS, tmpS);
        
		return maxS;
		
	}

    private int getMinH(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 0;
        
        if(left <= start && end <= right) return tree[node];
        
        int mid = (start + end) / 2;
        int leftIdx = getMinH(start, mid, node*2, left, right);
        int rightIdx = getMinH(mid+1, end, node*2+1, left, right);
        
        if(leftIdx == 0) return rightIdx;
        if(rightIdx == 0) return leftIdx;
        return num[leftIdx] < num[rightIdx] ? leftIdx : rightIdx;
    }

	// 각 노드마다 구간별 최소높이의 인덱스를 저장 ( 높이 저장하면 분할정복 불가능 )
	private int init(int start, int end, int node) {
		if(start == end) return tree[node] = start;
		
		int mid = (start + end) / 2;
		int left = init(start, mid, node*2);
		int right = init(mid+1, end, node*2+1);
		
		return tree[node] = num[left] < num[right] ? left : right;
	}
	
	
}