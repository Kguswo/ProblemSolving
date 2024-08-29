import java.io.*;
import java.util.*;

public class Main {
	
	public static class Node{
		int start;
		List<Integer> end;
		int value;
		int totalV;
		int intoNum; // 진입차수
		
		Node(int start, int value){
			this.start = start;
			this.end = new ArrayList<>();
			this.value = value;
			this.totalV = value;
			this.intoNum = 0;
		}
	}
	
	static BufferedReader br;
	static StringTokenizer st;
	static int T, N, K, X, Y, W;
	static Node[] nodes;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) { 
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			nodes = new Node[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				int v = Integer.parseInt(st.nextToken());
				nodes[i] = new Node(i, v);
			}
			
			for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                
				nodes[X].end.add(Y);
				nodes[Y].intoNum++;
			}
            W = Integer.parseInt(br.readLine());

			Queue<Node> queue = new LinkedList<Node>();
			for(int i=1; i<=N; i++) {
				if(nodes[i].intoNum == 0) queue.add(nodes[i]);
			}
			
			while(!queue.isEmpty()) {
				Node current = queue.poll();
				for(int next : current.end) {
					nodes[next].totalV = Math.max(nodes[next].totalV, current.totalV + nodes[next].value);
					if(--nodes[next].intoNum == 0) queue.add(nodes[next]);
				}
			}
			System.out.println(nodes[W].totalV);		
		}
	}
}
