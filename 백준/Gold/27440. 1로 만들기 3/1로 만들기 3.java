import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
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
        Deque<long[]> dq = new ArrayDeque<>();
        dq.offer(new long[]{N, 0});
        Set<Long> visited = new HashSet<>();

        while (!dq.isEmpty()) {
            long[] arr = dq.poll();
            long idx = arr[0];
            long cnt = arr[1];

            if (idx == 1) {
                return cnt;
            }

            if (!visited.contains(idx - 1)) {
                visited.add(idx - 1);
                dq.offer(new long[]{idx - 1, cnt + 1});
            }
            if (idx % 3 == 0 && !visited.contains(idx / 3)) {
                visited.add(idx / 3);
                dq.offer(new long[]{idx / 3, cnt + 1});
            }
            if (idx % 2 == 0 && !visited.contains(idx / 2)) {
                visited.add(idx / 2);
                dq.offer(new long[]{idx / 2, cnt + 1});
            }
        }
        return Integer.MIN_VALUE;
    }
}
