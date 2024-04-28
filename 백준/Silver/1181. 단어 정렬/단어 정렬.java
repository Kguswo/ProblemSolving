import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();
        String[] arr = new String[N];
 
        sc.nextLine();
 
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } 
                else {
                    return o1.length() - o2.length();
                }
            }
        }); 
        
        Set<String> set = new LinkedHashSet<>();
        for (String s : arr) {
            set.add(s);
        }
        
        for (String s : set) {
            System.out.println(s);
        }
    }
}
