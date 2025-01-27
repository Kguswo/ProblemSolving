/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, H, a, b, res=-1;
    static int[][] ladder;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_15684_사다리조작/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H+1][N+1];

        if(M==0) {
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        else if(M==1) {
            if(H==1) bw.write(String.valueOf(-1));
            else bw.write(String.valueOf(1));
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            // a번째 높이에 b와 b+1을 연결
            ladder[a][b] = 1; // 오른쪽으로 연결
            ladder[a][b+1] = -1; // 왼쪽으로 연결
        }

        if(needMoreThan4()){
            bw.write(String.valueOf(-1));
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        if(check()) {
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        for(int i=0; i<=3; i++) {
            dfs(0, 1, i);  // i는 목표 가로선 개수
            if(res != -1) break;  // 답을 찾으면 즉시 종료
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean needMoreThan4(){
        int sum = 0;
        for(int i=1; i<N; i++){
            int cnt = 0;
            for(int j=1; j<=H; j++){
                if(ladder[j][i] == 1) cnt++;
            }
            // 한 사다리에서 우측으로 짝수개가 붙어있어야함.
            if(cnt %2 != 0) sum++;
        }
        return sum >= 4;
    }

    private int goDown(int start) {
        int r = 1;
        int c = start;
        while(r <= H) {
            c += ladder[r][c];
            r++;
        }
        return c;
    }

    private boolean check(){
        for(int i=1; i<=N; i++){
            if(goDown(i) != i) return false;
        }
        return true;
    }

    private void dfs(int cnt, int depth, int line){ // line개만큼 둬야하는데 dfs돌리기
        if(cnt > line) return;

        if(cnt == line){
            if(check()){
                res = cnt;
                return;
            }
            return;
        }

        for(int i=depth; i<=H; i++){
            for(int j=1; j<N; j++){
                if(ladder[i][j] == 0 && ladder[i][j+1]==0){
                    if(j>=2 && ladder[i][j-1] == 1) continue; // 본인꺼 이전 -> 본인꺼 연결 x
                    if(j<N-1 && ladder[i][j+2] == -1) continue; // 본인꺼 다음 <- 다다음꺼 연결 x

                    ladder[i][j] = 1;
                    ladder[i][j+1] = -1;

                    dfs(cnt+1, i, line);
                    if(res != -1) return;

                    ladder[i][j] = 0;
                    ladder[i][j+1] = 0;
                }
            }
        }
    }
}