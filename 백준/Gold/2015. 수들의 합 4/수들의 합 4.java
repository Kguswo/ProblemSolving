/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static long K, prefixSum[];

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2015_수들의합4/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        prefixSum = new long[N + 1];

        Map<Long, Long> sumCnt = new HashMap<>();
        long res = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Long.parseLong(st.nextToken());

            if (prefixSum[i] == K) res++;

            res += sumCnt.getOrDefault(prefixSum[i] - K, 0L);
            sumCnt.put(prefixSum[i], sumCnt.getOrDefault(prefixSum[i], 0L) + 1);
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}