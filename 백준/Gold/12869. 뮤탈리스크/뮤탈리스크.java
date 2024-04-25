import java.util.Scanner;

public class Main {

    static class attack {
        int a, b, c;

        attack(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int[][][] dp;
    static int N, scv[];
    static attack[] mutalDamage = {
            new attack(9, 3, 1), new attack(9, 1, 3), new attack(3, 9, 1), new attack(3, 1, 9), new attack(1, 9, 3), new attack(1, 3, 9)
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        scv = new int[3];
        for (int i = 0; i < N; i++) {
            scv[i] = sc.nextInt();
        }

        dp = new int[61][61][61];
        for (int i = 0; i <= scv[0]; i++) {
            for (int j = 0; j <= scv[1]; j++) {
                for (int k = 0; k <= scv[2]; k++) {
                    dp[i][j][k] = mutal(i, j, k);
                }
            }
        }
        System.out.println(dp[scv[0]][scv[1]][scv[2]]);
    }

    static int mutal(int i, int j, int k) {
        if (dp[i][j][k] != 0) return dp[i][j][k];

        if (i <= 0 && j <= 0 && k <= 0) return 0;

        int min = 987654321;

        for (attack attack : mutalDamage) {
			int scv1 = i - attack.a;
			if(scv1<0) scv1 = 0;
			int scv2 = j - attack.b;
			if(scv2<0) scv2 = 0;
			int scv3 = k - attack.c;
			if(scv3<0) scv3 = 0;
            min = Math.min(min, mutal(scv1, scv2, scv3) + 1);
        }
        return dp[i][j][k] = min;
    }

}
