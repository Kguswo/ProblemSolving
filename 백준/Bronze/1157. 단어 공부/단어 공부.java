import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }
        int idx = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) { 
            if (arr[i] > max) {
                max = arr[i]; 
                idx = i; 
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != idx && max == arr[i]) { 
                System.out.println('?'); 
                return;
            }
        }
        System.out.println((char) (idx + 'A'));
    }
}
