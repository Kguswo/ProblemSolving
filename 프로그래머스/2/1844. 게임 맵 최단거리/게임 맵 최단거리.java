import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        // 맵의 크기
        int n = maps.length, m = maps[0].length;
        // 방문 배열을 맵의 크기보다 2씩 더 크게 만들어서 경계를 0으로 설정
        int[][] visited = new int[n+2][m+2];
        bfs(maps, visited, n, m);
        int answer = visited[n-1][m-1];

        return (answer > 0) ? answer : -1;
    }

    // 이동 방향 (상, 하, 좌, 우)
    static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    // 최단 거리를 구해야 하므로 BFS 사용
    public static void bfs(int[][] maps, int[][] visited, int n, int m) {
        // 시작 위치
        int x = 0, y = 0;
        visited[y][x] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int dr = r + d[i][0];
                int dc = c + d[i][1];

                // 경계를 넘어가는지 확인
                if (dr < 0 || dr >= n || dc < 0 || dc >= m) {
                    continue;
                }
                // 방문하지 않았고, 벽이 아닌 경우
                if (visited[dr][dc] == 0 && maps[dr][dc] == 1) {
                    queue.add(new int[] {dr, dc});
                    visited[dr][dc] = visited[r][c] + 1;
                }
            }
        }
    }
}
