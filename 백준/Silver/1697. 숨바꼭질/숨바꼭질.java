import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K, time=0;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println(bfs(N, K));
    }

    private static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == target) {
                    return time;
                }
                if (current - 1 >= 0 && !visited[current - 1]) {
                    queue.offer(current - 1);
                    visited[current - 1] = true;
                }
                if (current + 1 <= 100000 && !visited[current + 1]) {
                    queue.offer(current + 1);
                    visited[current + 1] = true;
                }
                if (current * 2 <= 100000 && !visited[current * 2]) {
                    queue.offer(current * 2);
                    visited[current * 2] = true;
                }
            }
            time++;
        }

        return Integer.MAX_VALUE;
    }
}
