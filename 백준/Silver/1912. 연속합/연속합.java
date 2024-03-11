import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N, maxsum;
    static int[] arr;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = maxsum(arr);
        System.out.println(ans);
    }

    private static int maxsum(int[] arr) {
        maxsum = arr[0];
        int currentsum = 0;
        int left = 0;

        int right = 0;
        while (right < N) {
            currentsum += arr[right];
            maxsum = Math.max(maxsum, currentsum);

            if (currentsum < 0) { // 합이 음수일 때
                currentsum = 0;
                left = right + 1;
            }

            right++;
        }

        return maxsum;
    }
}
