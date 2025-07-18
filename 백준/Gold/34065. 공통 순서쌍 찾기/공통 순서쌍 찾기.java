/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K;
    static int[] A, B;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/제9회천하제일코딩대회본선OpenContest/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] posA = new int[N+1];
        for(int i=0; i<N; i++) {
            posA[A[i]] = i;
        }

        List<int[]> pairs = new ArrayList<>();

        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=N-1; i>=0 && pairs.size() < K; i--) {
            int curr = B[i];
            int currPosA = posA[curr];

            NavigableSet<Integer> larger = ts.tailSet(currPosA + 1, true);

            for(int l : larger) {
                if(pairs.size() >= K) break;

                int num = A[l];
                pairs.add(new int[] {curr, num});
            }

            ts.add(currPosA);

        }

        if (pairs.size() >= K) {
            System.out.println("Yes");
            for (int i = 0; i < K; i++) {
                sb.append(pairs.get(i)[0]).append(" ").append(pairs.get(i)[1]).append("\n");
            }
            bw.write(sb.toString());
        } else {
            System.out.println("No");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}