/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, k, p;
    static int left, right;
    static int[] minHeap; // 넣는 순서 배열
    static List<Integer> ancestors = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_15942_ThinkingHeap/input.txt")));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        minHeap = new int[N+1];

        minHeap[p] = k;

        // p의 조상 채우기
        int idx = p;
        while(idx > 1){
            idx >>= 1;
            ancestors.add(idx);
        }
        Collections.reverse(ancestors);

        // 채워야할 개수가 k 값보다 크면 넘치므로
        if(ancestors.size() >= k){
            System.out.println(-1);
            return;
        }

        left = 0; // 위에서부터 조상 채우기
        for(int a : ancestors){
            minHeap[a] = ++left;
        }

        // p의 자식 채우기
        right = N;

        if(2*p <= N) dfs(2*p); // 좌
        if(2*p + 1 <= N) dfs(2*p + 1); // 우

        if(right < k){
            System.out.println(-1);
            return;
        }

        // 나머지 빈 칸 적절히 최소힙 되도록 채우기
        // 지금 트리는 p조상과 자손 부분을 채웠음 : (1~left) , ... , (k) , ... , (right+1 ~ N)
        Queue<Integer> queue = new LinkedList<>();
        for(int i=left+1; i<=right; i++){
            if(i==k) continue; // 이미 배치한 k값은 제외
            queue.add(i);
        }
        for(int i=1; i<=N; i++){
            if(minHeap[i] != 0) continue;
            minHeap[i] = queue.poll();
        }

        for(int i=1; i<=N; i++){
            sb.append(minHeap[i]).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private void dfs(int node) {
        minHeap[node] = right--;

        if(2*node <= N) dfs(2*node);
        if(2*node + 1 <= N) dfs(2*node + 1);
    }
}