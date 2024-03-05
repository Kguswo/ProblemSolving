import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());

		visited = new boolean[node + 1];
		arr = new ArrayList[node + 1];

		for (int i = 1; i < node + 1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start].add(end);
			arr[end].add(start);
		}
		int count = 0;
		for (int i = 1; i < node+1; i++) {
			if (!visited[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}

	static void dfs(int idx) {
		if (visited[idx]) {
			return;
		}
		visited[idx] = true;
		for (int i : arr[idx]) {
			if (visited[i] == false) {
				dfs(i);
			}
		}
	}
}
