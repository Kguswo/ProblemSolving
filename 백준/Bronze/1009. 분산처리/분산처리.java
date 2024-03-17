import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int a, b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            int data = 1;
            for(int j=0; j<b; j++) {
                data *= a;
                data %= 10;
            }
            if(data == 0)
                data = 10;
            list.add(data);
        }

        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }
}