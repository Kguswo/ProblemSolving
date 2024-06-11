import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        
        // 경계를 0으로 둘러싸기 위해 새로운 맵 생성
        int[][] extendedMaps = new int[n + 2][m + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                extendedMaps[i + 1][j + 1] = maps[i][j];
            }
        }
        
        // 방문 배열 생성
        int[][] visited = new int[n + 2][m + 2]; // 0으로 초기화
        
        // 1,1부터 출발하고, n, m을 출력해주면 되므로 한번만 호출
        bfs(extendedMaps, visited, n + 2, m + 2);
        int answer = visited[n][m];

        return (answer > 0) ? answer : -1;
    }

    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // 최단 거리이므로 BFS 사용
    public static void bfs(int[][] maps, int[][] visited, int n, int m) {
        int x = 1, y = 1;
        visited[y][x] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int dr = r + d[i][0];
                int dc = c + d[i][1];

                // 경계를 넘어가는지 확인할 필요가 없음
                if (visited[dr][dc] == 0 && maps[dr][dc] == 1) {
                    queue.add(new int[]{dr, dc});
                    visited[dr][dc] = visited[r][c] + 1;
                }
            }
        }
    }
}
