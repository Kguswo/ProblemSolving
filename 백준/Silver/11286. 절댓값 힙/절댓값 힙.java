import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			if(a == b) return o1 < o2 ? -1 : 1;
			else return a - b;
		});
		
		for(int i=0; i<n; i++) {
			int method = Integer.parseInt(br.readLine());
			if(method == 0) {
				if (pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			} else {
				pq.add(method);
			}
		}
		
	}
}
