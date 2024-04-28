import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(pact(N));
    }

    private static int pact(int n) {
        if (n <= 1) return 1;
        return n * pact(n - 1);
    }
}
