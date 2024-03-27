import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static Integer[] arr, S;
    static int N, R;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        Arrays.sort(arr, (o1, o2) -> o1 - o2);

        S = new Integer[R];
        permutation(0);

        bw.flush();
        bw.close();
    }

    private static void permutation(int cnt) throws IOException {
        if (cnt == R) {
            showAns();
            return;
        }
        for (int i = 0; i < N; i++) {
            S[cnt] = arr[i];
            permutation(cnt + 1);
        }
    }

    private static void showAns() throws IOException {
        for (int i = 0; i < S.length; i++) {
            bw.write(S[i] + " ");
        }
        bw.newLine();
    }
}
