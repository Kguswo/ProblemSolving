/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Node{
	int x;
	int cnt;
	public Node(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}
}
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K;
    static int[] arr, dx = {-1, 1};
	static long res = 0;
    static Queue<Node> queue = new LinkedList<>();
	public static HashSet<Integer> visited = new HashSet<>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_18513_샘터/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());

    	arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}

        for(int i=0;i<N;i++) {
    		queue.offer(new Node(arr[i], 0)); //BFS 시작위치
    		visited.add(arr[i]);
    	}

        bfs();

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private void bfs() {
        int houseCnt = 0;
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            int currX = curr.x;
            int currCnt = curr.cnt;
            res += currCnt;
            for(int k=0; k<2; k++) {
                int nx = currX + dx[k];
                if(visited.contains(nx)) continue;
                if(houseCnt >= K) continue;
                queue.offer(new Node(nx, currCnt+1));
                visited.add(nx);

                houseCnt++;
            }
        }
    }
}