import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> hashMap = new HashMap<>();
        while (true){
            int n = sc.nextInt();
            if (n==0) break;
            String[] s = new String[n];
            for (int i= 0; i<n;i++){
                s[i] = sc.next();
            }
            for (int i =0;i<n;i++){
                String tmp = s[i].toLowerCase();
                hashMap.put(tmp,s[i]);
                s[i] = s[i].toLowerCase();
            }
            Arrays.sort(s);
            System.out.println(hashMap.get(s[0]));
        }

    }
}