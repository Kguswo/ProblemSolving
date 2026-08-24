import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
 
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
 
            int result = solveCase(n, m, k);
            System.out.println(result);
        }
 
        scanner.close();
    }
 
    private static int solveCase(int n, int m, int k) {
        int rowColors = Math.min(n, k);
        int colColors = Math.min(m, k);
        return rowColors * colColors;
    }
}