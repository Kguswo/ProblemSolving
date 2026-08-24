import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, p[], F[];
    static boolean[] visited;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        // br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
 
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine()); // 순열의 크기
            p = new int[n]; // 순열 p
            visited = new boolean[n];
            F = new int[n];
 
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken()) - 1;
            }
 
            String s = br.readLine();
 
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    List<Integer> list = new ArrayList<>();
                    int current = i;
 
                    // 사이클을 탐색하면서 방문하지 않은 정점들을 기록
                    while (!visited[current]) {
                        visited[current] = true;
                        list.add(current);
                        current = p[current];
                    }
 
                    // 해당 사이클 내의 검정색 숫자 개수 카운트
                    int cnt = 0;
                    for (int idx : list) {
                    	// 색상이 검정색(0)인 경우 카운트++
                        if (s.charAt(idx) == '0') cnt++;
                    }
 
                    // 사이클 내의 모든 정점에 대해 F 값을 동일하게 설정 - 메모이제이션
                    for (int idx : list) {
                        F[idx] = cnt;
                    }
                }
            }
 
            // 결과를 StringBuilder에 추가하여 출력 속도 최적화
            for (int i = 0; i < n; i++) {
                sb.append(F[i]).append(" ");
            }
            sb.append("
");
        }
 
        System.out.print(sb.toString());
        br.close();
    }
}