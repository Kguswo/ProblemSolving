
/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	private static final int LIGHT_ON = 1;
	private static final int VISITED = 2;
    private static final int CANDIDATE = 3;
    
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		st = new StringTokenizer(br.readLine());
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
		
		Queue<Area> queue = new ArrayDeque<>();
        int[][] v = new int[n+1][n+1];
        v[1][1] = VISITED;
        queue.add(new Area(1, 1));
        int cnt = 1;

        while (!queue.isEmpty()) {
            Area current = queue.poll();
            if (map.containsKey(current)) {
                for (Area light : map.get(current)) {
                    if (v[light.r][light.c] == VISITED || v[light.r][light.c] == LIGHT_ON) continue;
                    cnt++;
                    if (v[light.r][light.c] == CANDIDATE) {
                        queue.add(light);
                        v[light.r][light.c] = VISITED;
                    } else {
                        v[light.r][light.c] = LIGHT_ON;
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = current.r + dr[d];
                int nc = current.c + dc[d];
                if (nr < 1 || nr > n || nc < 1 || nc > n || v[nr][nc] == VISITED || v[nr][nc] == CANDIDATE) continue;

                if (v[nr][nc] == LIGHT_ON) {
                    v[nr][nc] = VISITED;
                    queue.add(new Area(nr, nc));
                    continue;
                }

                v[nr][nc] = CANDIDATE;
            }
        }
        System.out.println(cnt);

        br.close();
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
		Area a = (Area) o;
		return this.r == a.r && this.c == a.c;
	}
}