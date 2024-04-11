//1000자리 BinInteger사용
import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    static BigInteger A, B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextBigInteger();
        B = sc.nextBigInteger();
        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));
    }
}
