/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {

    class Cell{
        int r, c, state, dist;
        public Cell(int r, int c, int state, int dist) {
            this.r = r;
            this.c = c;
            this.state = state;
            this.dist = dist;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static char[][] board;
    static List<int[]> dirty; // 입력순서대로 더러운칸 번호
    static Map<Integer, Integer> dirtyMap; // 더러운 곳 (r, c) 로 해싱해서 몇번째 더러운 칸인지 체크
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_4991_로봇청소기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;
            board = new char[N][M];
            dirty = new ArrayList<>();
            dirtyMap = new HashMap<>();
            Cell start = new Cell(0,0,0,0);
            int num = 0;
            for(int i = 0; i < N; i++) {
                String Line = br.readLine();
                for(int j = 0; j < M; j++) {
                    board[i][j] = Line.charAt(j);
                    if(board[i][j] == '*') {
                        dirty.add(new int[]{i, j});
                        dirtyMap.put(j + i*M, num++);
                    }
                    else if(board[i][j] == 'o'){
                        start.r = i;
                        start.c = j;
                    }
                }
            }

            Queue<Cell> queue = new ArrayDeque<>();
            visited = new boolean[N][M][1<<10];
            queue.add(start);
            visited[start.r][start.c][0] = true;

            boolean flag = false;
            while(!queue.isEmpty() && !flag) {
                Cell curr = queue.poll();
                for(int k=0; k<4; k++) {
                    int nr = curr.r + dr[k];
                    int nc = curr.c + dc[k];
                    if(isValid(nr, nc) && board[nr][nc] != 'x') {
                        if(board[nr][nc] == '*'){
                            int n = dirtyMap.get(nc + nr*M); // 몇번째 더러운 칸인지
                            int nstate = curr.state | (1 << n); // 새로운 state값

                            if(nstate == ((1<<dirty.size()) - 1)) {
                                sb.append(curr.dist + 1).append("\n");
                                flag = true;
                                break;
                            }
                            Cell nextCell = new Cell(nr, nc, nstate, curr.dist + 1);
                            if(!visited[nr][nc][nstate]){
                                visited[nr][nc][nstate] = true;
                                queue.add(nextCell);
                            }
                        }
                        else if(board[nr][nc] == '.' || board[nr][nc] == 'o') {
                            Cell nextCell = new Cell(nr, nc, curr.state, curr.dist + 1);
                            if(!visited[nr][nc][curr.state]){
                                visited[nr][nc][curr.state] = true;
                                queue.add(nextCell);
                            }
                        }
                        else continue;
                    }
                }
            }

            if(!flag){
                sb.append("-1\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean isValid(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}