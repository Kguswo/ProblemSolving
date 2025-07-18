/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] dr = {-1, 1, 0 ,0}, dc = {0, 0, -1, 1};
    static boolean[][] star, visited;
    static int N, M, K, a1, b1, a2, b2, a3, b3, a4, b4;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/제9회천하제일코딩대회본선OpenContest/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        star = new boolean[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            star[x][y] = true;
        }

        st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a3 = Integer.parseInt(st.nextToken());
        b3 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a4 = Integer.parseInt(st.nextToken());
        b4 = Integer.parseInt(st.nextToken());

        long res = 0;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(!star[i][j] && !visited[i][j]){
                    List<int[]> list = bfs(i, j);

                    long cnt1 = 0, cnt2 = 0;

                    for(int[] l : list){
                        int x = l[0], y = l[1];

                        if(x >= a1 && x <= a2 && y >= b1 && y <= b2) cnt1++;

                        if(x >= a3 && x <= a4 && y >= b3 && y <= b4) cnt2++;
                    }

                    res += cnt1 * cnt2;
                }
            }
        }

        System.out.println(res);

        bw.flush();
        bw.close();
        br.close();
    }

    private static List<int[]> bfs(int x, int y){
        List<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            list.add(new int[] {curr[0], curr[1]});

            for(int k=0 ; k<4; k++){
                int nx = curr[0] + dr[k];
                int ny = curr[1] + dc[k];

                if(!isValid(nx, ny)) continue;

                if(star[nx][ny]) continue;

                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }

        return list;
    }

    private static boolean isValid(int x, int y){
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
}