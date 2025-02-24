/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, H, nums[], odd[], even[], count[], min = Integer.MAX_VALUE;
    static Map<Integer, List<Integer>> breakMap = new HashMap<>(); // key : 부수는횟수, value : 해당 구간들
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_3020_개똥벌레/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        odd = new int[H+1]; // 홀수번째(석순) 누적합
        even = new int[H+1]; // 짝수번째(종유석) 누적합
        count = new int[H+1]; // 구간별 부술 개수 누적합배열

        for(int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++){
            if(i%2 == 1) odd[nums[i]]++;
            else even[(H+1) - nums[i]]++;
        }

        // 홀수는 끝부터 누적합
        for(int i=H-1; i>=1; i--){
            odd[i] += odd[i+1];
        }
        // 짝수는 처음부터 누적합
        for(int i=2; i<=H; i++){
            even[i] += even[i-1];
        }

        for(int i=1; i<=H; i++){
            count[i] = odd[i] + even[i];
        }

        for(int i=1; i<=H; i++){
            if(!breakMap.containsKey(count[i])) breakMap.put(count[i], new ArrayList<>());
            breakMap.get(count[i]).add(i);
            if(min > count[i]) min = count[i];
        }

        sb.append(min).append(" ").append(breakMap.get(min).size());
        System.out.println(sb);
        bw.flush();
        bw.close();
        br.close();
    }
}