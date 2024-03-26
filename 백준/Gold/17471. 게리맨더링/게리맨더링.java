import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int mindiff = Integer.MAX_VALUE;
	static int[] num;
	static boolean S[], visited[];
	static List<ArrayList<Integer>> linked;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        num = new int[N];
        S = new boolean[N];
        visited = new boolean[N];
        
        for(int i=0; i<N; i++) {
        	num[i] = sc.nextInt();
        }
        linked = new ArrayList<>();
        for(int i=0; i<N; i++) {
        	linked.add(new ArrayList<>());
        }
        for(int i=0; i<N; i++) {
        	int a = sc.nextInt();
        	for(int j=0; j<a; j++) {
        		int b = sc.nextInt()-1;
        		linked.get(i).add(b);
        	}
        }
//        System.out.println(Arrays.toString(num));
//        System.out.println(linked);
        
        separate(0);
        if(mindiff == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(mindiff);
	}
	private static void separate(int cnt) {
		if(cnt == N) {
			List<Integer> area1 = new ArrayList<Integer>();
			List<Integer> area2 = new ArrayList<Integer>();
			for(int i=0; i<N; i++) {
				if(S[i]) area1.add(i);
				else area2.add(i);
			}
			
			if(area1.size() == 0 || area2.size() == 0) return;
			
			if(isLinked(area1) && isLinked(area2)) calDiff();
			
			return;
		}
		
		S[cnt] = true; // area1
		separate(cnt+1);
		S[cnt] = false; // area2
		separate(cnt+1);
	}
	
	private static boolean isLinked(List<Integer> area) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[N];
		visited[area.get(0)] = true;
		queue.add(area.get(0));
		
		int count = 1;
		while(queue.isEmpty() == false) {
			int current = queue.poll();
			for(int i=0; i<linked.get(current).size(); i++) {
				int next = linked.get(current).get(i);
				if(area.contains(next) && visited[next] == false) {
					queue.add(next);
					visited[next] = true;
					count++;
				}
			}
		}
		
		if(count == area.size()) return true;
		else return false;
	}
	
	private static void calDiff() {
		int area1people = 0, area2people = 0;
		for(int i=0; i<N; i++) {
			if(S[i]) area1people += num[i];
			else area2people += num[i];
		}
		int value = (int) Math.abs(area1people - area2people);
		mindiff = Math.min(value, mindiff);
	}
}