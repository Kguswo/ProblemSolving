import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<String>();
		Set<String> treeSet = new TreeSet<>(); // TreeSet을 사용하여 자동으로 정렬

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				treeSet.add(str);
			}
		}

		System.out.println(treeSet.size());
		for (String s : treeSet) {
			System.out.println(s);
		}
	}
}
