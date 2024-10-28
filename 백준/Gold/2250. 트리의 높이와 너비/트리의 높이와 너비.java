/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	
	class Node{
		int num;
		int left, right;
		
		public Node(int num, int left, int right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}
		
	}
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static Set<Integer> rootList = new HashSet<>();
	static Map<Integer, Node> tree = new HashMap<Integer, Node>();
	static Map<Integer, List<Integer>> levelColumn = new HashMap<>(); // 레벨별 열 list
    static int columnCnt=0;
    static int maxLevel=0, maxLength=0;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			rootList.add(i);
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			tree.put(num, new Node(num, left, right));
			
			if(left != -1) rootList.remove(left);
			if(right != -1) rootList.remove(right);
			
		}
		
		int root = rootList.stream().findFirst().get();
		dfs(root, 1);

		for(Map.Entry<Integer, List<Integer>> entry : levelColumn.entrySet()){
			int level = entry.getKey();
			List<Integer> column = entry.getValue();
			
			// 길이 =  마지막열 - 첫번째열 + 1
			int len = column.get(column.size()-1) - column.get(0) + 1;
			
			if(len > maxLength) {
				maxLevel = level;
				maxLength = len;
			}
		}
        
		bw.write(maxLevel + " " + maxLength);
		bw.flush();
		bw.close();
		br.close();
	}

	private void dfs(int num, int level) {
		Node node = tree.get(num);
		
		if(node.left != -1) {
			dfs(node.left, level+1);
		}
		
        // 현재 노드의 열 번호 처리
        columnCnt++;
        levelColumn.computeIfAbsent(level, columnIdx -> new ArrayList<>()).add(columnCnt);
        
		if(node.right != -1) {
			dfs(node.right, level+1);
		}
	}
	
}