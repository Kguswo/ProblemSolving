import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];

		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			dq.add(i);
		}

		int idx = 1;
		while (!dq.isEmpty()) {
			for (int i = 0; i < idx; i++) {
				dq.addLast(dq.pollFirst());
			}
			int num = dq.pollFirst();
			arr[num] = idx++;
		}

		for(int i=0; i<n; i++) {
			bw.write(arr[i]+" ");
		}
		bw.flush();
        bw.close();
        br.close();
	}
}