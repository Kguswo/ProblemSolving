import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 가방 최대 무게가 정해져있고 가방에 1개씩밖에 못 넣는 상황에서 최대 합을 구해야하므로
 * 보석을 무게순으로 내림차순 정렬하고(무게가 같으면 가중치가 높은 순으로)
 * 가방을 무게순으로 내림차순으로 정렬해서
 * 가방에 넣을 수 있는 보석을 모두 우선순위큐에 넣은 뒤
 * 가장 가중치가 높은 보석을 빼내서 합에 더하면 될 듯.
*/
public class Main {
	static class Jewerly implements Comparable<Jewerly>{
		int w, v;
		public Jewerly(int w, int v){
			this.w = w;
			this.v = v;
		}
		public int compareTo(Jewerly o) {
			return this.w - o.w;
		}
	}
	
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K;
    static long maxSum;
	static ArrayList<Jewerly> jewerly;
	static int[] bag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		
		jewerly = new ArrayList<Jewerly>();
		bag = new int[K];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.valueOf(st.nextToken());
			int V = Integer.valueOf(st.nextToken());
			jewerly.add(new Jewerly(M, V));
		}
        for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
            bag[i] = Integer.valueOf(st.nextToken());
        }		
		Collections.sort(jewerly);
		Arrays.sort(bag);
		
		maxSum = 0;
		putIntoBag();
        System.out.println(maxSum);

	}

	private static void putIntoBag() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int k = 0;		
        for(int i=0; i<K; i++) {
			while(k<N && jewerly.get(k).w <= bag[i]) {
				pq.add(jewerly.get(k).v);
				k++;
			}
			if(!pq.isEmpty()) maxSum += pq.poll();
		}
	}
}
