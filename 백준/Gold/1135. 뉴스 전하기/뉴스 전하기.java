/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, parent[], maxP, time[];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1135_뉴스전하기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        time = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            parent[i] = num;
            maxP = num;
        }

        // 자식부터 시간 업데이트
        for(int i=N-1; i>=0; i--){
            updateTime(i);
        }

        bw.write(String.valueOf(time[0]));
        bw.flush();
        bw.close();
        br.close();
    }

    private void updateTime(int num) {
        ArrayList<Integer> childList = new ArrayList<>();
        for(int i=0; i<N; i++){
            if(parent[i] == num) childList.add(time[i]);
        }

        Collections.sort(childList, Collections.reverseOrder());

        int maxT = 0;
        for(int order = 1; order<=childList.size(); order++){
            maxT = Math.max(maxT, order + childList.get(order-1));
        }
        time[num] = maxT;
    }
}
