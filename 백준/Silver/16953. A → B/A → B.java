import java.util.Scanner;

public class Main {
    static int A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        int count = 1;

        if(B < A) {
            System.out.println(-1);
            return;
        }
        while (B != A) {
            if(B < A) {
                System.out.println(-1);
                return;
            }
        	if(B == 1) break;
            if (B % 10 == 1) B = B / 10;
            else if (B % 2 == 0)  B = B / 2;
            else {
                System.out.println(-1);
                return;
            }
            count++;
        }
        System.out.println(count);
    }
}
