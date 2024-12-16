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
    static int N, M;
    static ArrayList<Integer>[] lawyer; // a->b 변호 관계
    static ArrayList<Integer>[] doubleRelationship; // 양방향관계
    static boolean[] isDefended; 		// 변호받았는지 여부
    static boolean flag;
    static int[] p;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lawyer = new ArrayList[N + 1];
        doubleRelationship = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            lawyer[i] = new ArrayList<>();
            doubleRelationship[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lawyer[a].add(b);
        }

        isDefended = new boolean[N + 1];
        
        p = new int[N+1];
        for(int i=1; i<=N; i++) {
        	p[i] = i;
        }
        
        for(int i=1; i<=N; i++) { // 나
        	for(int l : lawyer[i]) { // 변호사
        		if(lawyer[l].contains(i)) {
        			// 서로 포함하므로 
        			doubleRelationship[i].add(l);
        		}
        		else {
        			isDefended[l] =true;
        		}
        	}
        }
        
        for(int i=1; i<=N; i++) {
        	if(isDefended[i] || p[i] != i) continue;
        	flag = false;
        	dfs(i, i);
        	if(!flag) {
        		System.out.println("NO");
        		return;
        	}
        }
        

        System.out.println("YES");
        bw.flush();
        bw.close();
        br.close();
    }

	private void dfs(int prev, int curr) {
		for(int next : doubleRelationship[curr]) {
			if(next == prev) continue;
			if(isDefended[next]) {
				flag = true;
			}
			if(!union(curr, next)) {
				flag = true;
				continue;
			}
			dfs(curr, next);
		}
	}
	
	private boolean union(int x, int y) {
		if(find(y) == find(x)) return false;
		p[find(y)] = find(x);
		return true;
	}
	
	private int find(int x) {
		if(p[x] != x) return p[x] = find(p[x]);
		return x;
	}
}