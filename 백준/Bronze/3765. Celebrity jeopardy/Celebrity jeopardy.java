import java.io.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static String s;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}
