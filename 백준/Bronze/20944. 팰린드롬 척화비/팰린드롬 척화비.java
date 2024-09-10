import java.io.*;
import java.util.*;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        char [] arr = new char [num];

        Arrays.fill(arr, 'a');

        sb.append(arr);
        System.out.println(sb.toString());
    }
}