/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, arr[][];

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1946_신입사원/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
//        while (T-- > 0) {
//            N = Integer.parseInt(br.readLine());
//            arr = new int[N][2];
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                arr[i][0] = Integer.parseInt(st.nextToken());
//                arr[i][1] = Integer.parseInt(st.nextToken());
//            }
//
//            arr = Arrays.stream(arr)
//                    .sorted((o1, o2) -> o1[0] - o2[0])
//                    .toArray(int[][]::new);
//
//            int score = arr[0][1];
//            int cnt = 1;
//            for (int i = 1; i < N; i++) {
//                if (score >= arr[i][1]) {
//                    score = arr[i][1];
//                    cnt++;
//                }
//            }
//
//            sb.append(String.valueOf(cnt) + "\n");
//        }

        // 발전된 버전
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] interviews = new int[N];

            for (int i = 0; i < N; i++) {
                String[] scores = br.readLine().split(" ");
                int document = Integer.parseInt(scores[0]) - 1;
                int interview = Integer.parseInt(scores[1]) - 1;
                interviews[document] = interview;
            }

            int score = interviews[0];
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (score >= interviews[i]) {
                    score = interviews[i];
                    cnt++;
                }
            }

            sb.append(cnt).append('\n');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}