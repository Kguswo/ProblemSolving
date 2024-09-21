import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
    private static final int LIGHT_ON = 1;
    private static final int VISITED = 2;
    private static final int CAN_VISIT = 3;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Area, List<Area>> map = new HashMap<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Area cur = new Area(x, y);
            map.computeIfAbsent(cur, k -> new ArrayList<>()).add(new Area(a, b));
        }

        int result = bfs(n, map);
        System.out.println(result);

        br.close();
    }

    private int bfs(int n, Map<Area, List<Area>> map) {
        Queue<Area> queue = new ArrayDeque<>();
        int[][] board = new int[n+1][n+1];
        board[1][1] = VISITED;
        queue.add(new Area(1, 1));
        int cnt = 1;

        while (!queue.isEmpty()) {
            Area current = queue.poll();
            if (map.containsKey(current)) {
                for (Area light : map.get(current)) {
                    if (board[light.r][light.c] == VISITED || board[light.r][light.c] == LIGHT_ON) continue;
                    cnt++;
                    if (board[light.r][light.c] == CAN_VISIT) {
                        queue.add(light);
                        board[light.r][light.c] = VISITED;
                    } else {
                        board[light.r][light.c] = LIGHT_ON;
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 1 || nr > n || nc < 1 || nc > n || board[nr][nc] == VISITED || board[nr][nc] == CAN_VISIT) continue;

                if (board[nr][nc] == LIGHT_ON) {
                    board[nr][nc] = VISITED;
                    queue.add(new Area(nr, nc));
                    continue;
                }

                board[nr][nc] = CAN_VISIT;
            }
        }
        return cnt;
    }
}

class Area {
    int r, c;

    public Area(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int hashCode() {
        return c * 20000 + r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area a = (Area) o;
        return this.r == a.r && this.c == a.c;
    }
}