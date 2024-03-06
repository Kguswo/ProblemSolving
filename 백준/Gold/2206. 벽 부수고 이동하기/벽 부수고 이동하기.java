import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M;
    static int[][] board;
    static boolean[][][] visited; // 벽을 부수었는지의 여부를 추가
    static int[][][] length; // 벽을 부수었을 때와 부수지 않았을 때의 길이를 저장
    static int mincount = Integer.MAX_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2]; // 벽을 부수었는지의 여부를 추가
        length = new int[N + 1][M + 1][2]; // 벽을 부수었을 때와 부수지 않았을 때의 길이를 저장

        for (int r = 1; r <= N; r++) {
            String str = sc.next();
            for (int c = 1; c <= M; c++) {
                board[r][c] = str.charAt(c - 1) - '0';
            }
        }

        bfs(1, 1);
        if (mincount == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(mincount);
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 0}); // 벽을 부수지 않았을 때의 정보 추가

        visited[r][c][0] = true; // 벽을 부수지 않았음을 표시
        length[r][c][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentr = current[0];
            int currentc = current[1];
            int currentwallbreak = current[2];

            // 도착점에 도달하면 최단 경로 업데이트
            if (currentr == N && currentc == M) {
                mincount = Math.min(mincount, length[currentr][currentc][currentwallbreak]);
            }

            for (int idx = 0; idx < 4; idx++) {
                int newr = currentr + dr[idx];
                int newc = currentc + dc[idx];

                if (newr >= 1 && newr <= N && newc >= 1 && newc <= M) {
                    // 이동할 곳이 빈 공간이고 아직 방문하지 않았을 때
                    if (board[newr][newc] == 0 && !visited[newr][newc][currentwallbreak]) {
                        queue.add(new int[]{newr, newc, currentwallbreak});
                        visited[newr][newc][currentwallbreak] = true;
                        length[newr][newc][currentwallbreak] = length[currentr][currentc][currentwallbreak] + 1;
                    }
                    // 이동할 곳이 벽이고 아직 벽을 부수지 않았을 때
                    else if (board[newr][newc] == 1 && currentwallbreak == 0 && !visited[newr][newc][1]) {
                        queue.add(new int[]{newr, newc, 1});
                        visited[newr][newc][1] = true;
                        length[newr][newc][1] = length[currentr][currentc][currentwallbreak] + 1;
                    }
                }
            }
        }
    }
}
