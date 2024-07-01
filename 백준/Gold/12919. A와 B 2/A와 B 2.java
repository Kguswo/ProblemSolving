import java.io.*;
import java.util.Scanner;

public class Main {
	static String S, T;
    static boolean Same = false;
    public static void main(String[] args) throws FileNotFoundException {

    	Scanner sc = new Scanner(System.in);
        S = sc.next();
        T = sc.next();

        TtoS(S, T, T.length() - 1);
        System.out.println(Same ? 1 : 0);
    }

    private static void TtoS(String S, String T, int end) {
        if (Same) return;
        
        if (S.length() == T.length()) { // 체크
            if (S.equals(T)) Same = true;
            return;
        }
        
        // A제거
        if (T.charAt(end) == 'A') TtoS(S, T.substring(0, end), end - 1);
        
        // 뒤집고 B제거 -> 뒤집기를 StringBuffer 및 StringBuilder로 바꿔보기
        if (new StringBuffer(T).reverse().toString().charAt(end) == 'B') TtoS(S, new StringBuffer(T).reverse().substring(0, end), end - 1);
//        if (new StringBuilder(T).reverse().toString().charAt(end) == 'B') TtoS(S, new StringBuilder(T).reverse().substring(0, end), end - 1);
    }
    
//    private static String reverse(String T) {
//        String newT = "";
//        for (int i = T.length() - 1; i >= 0; i--) {
//        	newT = newT + T.charAt(i);        
//        }
//		return newT;
//    }
}