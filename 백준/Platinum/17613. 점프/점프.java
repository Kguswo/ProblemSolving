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
    static int TC;
    static long X, Y;
    static long[] arr;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_17613_점프/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TC = Integer.parseInt(br.readLine());

        // int 가 2^31-1까지니까 최대 31번점프가능
        arr = new long[31];
        for(int i=1; i<31; i++) {
            arr[i] = (1L << i) -1;
        }

        while(TC-->0){
            st = new StringTokenizer(br.readLine());
            X = Long.parseLong(st.nextToken());
            Y = Long.parseLong(st.nextToken());
            sb.append(maxJ(X, Y)).append('\n');
        }
        System.out.println(sb);
        bw.flush();
        bw.close();
        br.close();
    }

    // x까지 최소점프횟수
    private static int calJ(long x) {
        long tmp = 1;
        int j = 0;
        while (x>0) {
            x -= tmp;

            // 점프초기화
            if (2 * tmp > x) tmp = 1;
            else tmp *= 2;
            j++;
        }
        return j;
    }

    // [left ~ right] 최대점프횟수구하기
    private static int maxJ(long left, long right) {
        if(left == right) return calJ(right);
        if(left + 1 == right) return Math.max(calJ(left), calJ(right));

        // right보다 큰 2거듭제곱 J찾기
        int idx;
        for(idx=0; idx<31; idx++){
            if(arr[idx] > right) break;
        }

        if(idx==1) return 1;
        //J(i-1), J(i-2)
        long J_1 = arr[idx-1]; // J(i-1)
        long J_2 = arr[idx-2]; // J(i-2)

        // case1: 20~100 (left <= J2 인 경우)
        // J2까지 가는 경우와 J1까지 가는 경우 중 더 큰 값 선택
        if(left <= J_2) return Math.max((idx-2) + maxJ(0, J_2), (idx-1) + maxJ(0, right-J_1));

        // case4: 64~100 (left > J1 인 경우)
        // 예: [64~100] 구간처럼 시작점이 J1보다 큰 경우
        // 전체 구간을 J1만큼 빼서 재귀적으로 처리
        if(left > J_1) return (idx-1) + maxJ(left-J_1, right-J_1);

        // case3: 40~100 (J2 < left < J1 인 경우)
        // 예: [32~62] 구간처럼 시작점이 J2와 J1 사이인 경우
        // J2를 밟고 가는 경우와 J1까지 가는 경우 중 더 큰 값 선택
        if(left < J_1) return Math.max((idx-2) + maxJ(left-J_2, J_2), (idx-1) + maxJ(0, right-J_1));

        // case2: (left == J1 인 경우)
        // 예: [63~100] 구간처럼 시작점이 정확히 J1인 경우
        // J1까지는 idx-1번의 점프로 도달, 나머지는 재귀로 처리
        return (idx-1) + maxJ(0, right-J_1);
    }
}