import java.util.Scanner;

public class Solution {
    static int[][] ingredient;
    static int N;
    static int L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();
            L = sc.nextInt();
            ingredient = new int[2][N];
            for (int i = 0; i < N; i++) {
                ingredient[0][i] = sc.nextInt(); // 점수
                ingredient[1][i] = sc.nextInt(); // 칼로리
            }

            int maxscore = 0;

            for (int i = 0; i <= N; i++) {
                maxscore = Math.max(maxscore, Combination(0, 0, i, 0));
            }

            System.out.printf("#%d %d\n", tc, maxscore);
        }
    }

    static int Combination(int sum, int sumcal, int m, int idx) { // 조합 더하면서 칼로리 합과 점수합 구하기
        if (m == 0 || idx == N) {
            if (sumcal > L) return 0;
            return sum;
        }

        int maxsum = Integer.MIN_VALUE;

        for (int i = idx; i < N; i++) {
            int currentsum = Combination(sum + ingredient[0][i], sumcal + ingredient[1][i], m - 1, i + 1);
            maxsum = Math.max(maxsum, currentsum);
        }

        return maxsum;
    }
}