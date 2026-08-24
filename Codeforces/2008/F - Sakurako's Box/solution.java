import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    private static final int MOD = 1000000007;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());  // 배열의 크기
            String[] tokens = br.readLine().split(" ");
            long[] a = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(tokens[i]);
                sum = (sum + a[i]) % MOD;
            }
 
            long result = 0;
            for (int i = 0; i < n; i++) {
                sum = (sum - a[i] + MOD) % MOD;
                result = (result + a[i] * sum) % MOD;
            }
 
            // 두 개의 공을 선택하는 조합의 수는 nC2 = n * (n - 1) / 2
            long combinationCount = (long) n * (n - 1) / 2 % MOD;
 
            // 기대값 계산: P * Q^(-1) % MOD
            long expectedValue = result * modInverse(combinationCount, MOD) % MOD;
 
            sb.append(expectedValue).append("
");
        }
 
        System.out.print(sb.toString());
        br.close();
    }
 
    // 모듈러 역수를 계산하는 함수 (페르마의 소정리 이용)
    private static long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }
 
    // 거듭제곱을 계산하는 함수
    private static long power(long a, long b, int mod) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return result;
    }
}