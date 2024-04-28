import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(fact(1, N));
    }

    private static BigInteger fact(int L, int R){
        
        BigInteger num = BigInteger.valueOf(L);
        if (L < R){
            int mid = (L+R)/2;
            num = fact(L,mid).multiply(fact(mid+1, R));
        }
        return num;
    }
}
