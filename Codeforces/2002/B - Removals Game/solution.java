import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()); // Number of test cases
 
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // Length of permutations
            int[] a = new int[n];
            int[] b = new int[n];
 
            // Read Alice's permutation
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
 
            // Read Bob's permutation
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
 
            System.out.println(solveCase(n, a, b));
        }
 
        br.close();
    }
 
    private static String solveCase(int n, int[] a, int[] b) {
        int leftA = 0, rightA = n - 1;
        int leftB = 0, rightB = n - 1;
 
        while (leftA <= rightA) {
            if (a[leftA] != b[leftB] && a[leftA] != b[rightB]) {
                return "Alice";
            }
            if (a[rightA] != b[leftB] && a[rightA] != b[rightB]) {
                return "Alice";
            }
 
            if (a[leftA] == b[leftB]) {
                leftA++;
                leftB++;
            } else if (a[leftA] == b[rightB]) {
                leftA++;
                rightB--;
            } else if (a[rightA] == b[leftB]) {
                rightA--;
                leftB++;
            } else {
                rightA--;
                rightB--;
            }
        }
 
        return "Bob";
    }
}