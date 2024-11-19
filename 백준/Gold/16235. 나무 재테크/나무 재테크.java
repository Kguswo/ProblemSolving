/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, K, A[][], energy[][];
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static Deque<Tree> trees = new LinkedList<Main.Tree>();
	static Queue<Tree> deadTrees;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	class Tree implements Comparable<Tree> {
		int x, y, age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N+1][N+1];
		energy = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				energy[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees.addFirst(new Tree(x, y, z));
		}

		while (K-- > 0) {
			deadTrees = new LinkedList<Main.Tree>();
			year();
		}
		bw.write(String.valueOf(trees.size()));
		bw.flush();
		bw.close();
		br.close();
	}

	private void year() {
		spring();
		summer();
		fall();
		winter();
	}

	private void spring() {
		Deque<Tree> tmpTrees = new ArrayDeque<Main.Tree>();
		int size = trees.size();
		while(size-->0) {
			Tree currTree = trees.poll();
			if (currTree.age <= energy[currTree.x][currTree.y]) {
				energy[currTree.x][currTree.y] -= currTree.age;
				currTree.age++;
				tmpTrees.add(currTree);
			} else {
				deadTrees.add(currTree);
			}
		}
		trees = tmpTrees;
	}

	private void summer() {
		while(!deadTrees.isEmpty()) {
			Tree currTree = deadTrees.poll();
			int newEnergy = currTree.age/2;
			energy[currTree.x][currTree.y] += newEnergy;
		}
	}

	private void fall() {
		Deque<Tree> tmpTrees = new ArrayDeque<Main.Tree>();
		int size = trees.size();
		while(size-->0) {
			Tree currTree = trees.poll();
			if(currTree.age %5 == 0) {
				for(int k=0; k<8; k++) {
					int newr = currTree.x + dr[k];
					int newc = currTree.y + dc[k];
//					System.out.println("newr : " + newr);
//					System.out.println("newc : " + newc);
					if(isValidCoordinate(newr, newc)) {
						Tree newTree = new Tree(newr, newc, 1);
						tmpTrees.addFirst(newTree);
					}
				}
			}
			tmpTrees.addLast(currTree);
		}
		trees = tmpTrees;
	}

	private void winter() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N;j++) {
				energy[i][j] += A[i][j];
			}
		}
	}
	
	private boolean isValidCoordinate(int r, int c) {
		return r > 0 && r <= N && c > 0 && c <= N;
	}
}
