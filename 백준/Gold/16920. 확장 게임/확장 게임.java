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
    static int N, M, P;
    static int[] S, res;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static char[][] board;
    static Queue<int[]>[] players;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_16920_확장게임/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        S = new int[P+1];
        res = new int[P+1];
        players = new ArrayDeque[P+1];
        for(int i = 0; i < P+1; i++) {
            players[i] = new ArrayDeque<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=P; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] != '.' && board[i][j] != '#'){
                    int pNum = board[i][j] - '0';
                    players[pNum].add(new int[]{i, j});
                    res[pNum]++;
                }
                else cnt++;
            }
        }
        int pIdx = 1;
        int fail = 0;

        while(cnt>0 && fail < P){
            Queue<int[]> currQ = players[pIdx];
            boolean flag = false;

            for(int i=0; i<S[pIdx]; i++){
                int size = currQ.size();
                if(size == 0) break;

                for(int j=0; j<size; j++){
                    int[] currCell = currQ.poll();
                    for(int k=0; k<4; k++){
                        int nr = currCell[0] + dr[k];
                        int nc = currCell[1] + dc[k];

                        if(isValid(nr, nc) && board[nr][nc] == '.'){
                            board[nr][nc] = (char)(pIdx + '0');
                            res[pIdx]++;
                            currQ.add(new int[]{nr, nc});
                            cnt--;
                            flag = true;
                        }
                    }
                }
            }

            if(!flag) fail++;
            else fail = 0;

            pIdx = nextP(pIdx);
        }

        for(int i=1; i<=P; i++){
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean isValid(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private int nextP(int pIdx){
        return pIdx % P + 1;
    }
}