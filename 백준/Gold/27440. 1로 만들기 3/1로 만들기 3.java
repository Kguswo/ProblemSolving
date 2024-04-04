import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static long N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        System.out.println(bfs(N));
    }

    private static long bfs(long N) {
        Queue<long[]> queue = new LinkedList<long[]>();
        queue.offer(new long[]{N, 0});
        Set<Long> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            long[] arr = queue.poll();
            long idx = arr[0];
            long cnt = arr[1];

            if (idx == 1) {
                return cnt;
            }

            if (!visited.contains(idx - 1)) {
                visited.add(idx - 1);
                queue.offer(new long[]{idx - 1, cnt + 1});
            }
            if (idx % 3 == 0 && !visited.contains(idx / 3)) {
                visited.add(idx / 3);
                queue.offer(new long[]{idx / 3, cnt + 1});
            }
            if (idx % 2 == 0 && !visited.contains(idx / 2)) {
                visited.add(idx / 2);
                queue.offer(new long[]{idx / 2, cnt + 1});
            }
        }
        return Integer.MIN_VALUE;
    }
}
