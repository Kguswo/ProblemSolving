/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    static PriorityQueue<Integer> ASC_PQ = new PriorityQueue<Integer>();
    static PriorityQueue<Integer> DESC_PQ = new PriorityQueue<Integer>(Collections.reverseOrder());
    static Map<Integer, Integer> map; // 숫자 개수
    static int T, N;

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            ASC_PQ.clear();
            DESC_PQ.clear();
            map = new HashMap<>();

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String mode = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (mode) {
                    case "I": {
                        ASC_PQ.add(num);
                        DESC_PQ.add(num);
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    }
                    case "D": {
                        if (!map.isEmpty()) {
                            if (num == 1) {
                                delete(DESC_PQ);
                            } else {
                                delete(ASC_PQ);
                            }
                        }
                        break;
                    }
                }
            }

            if (map.isEmpty()) sb.append("EMPTY\n");
            else {
                int max = delete(DESC_PQ);
                sb.append(max).append(" ");
                if (!map.isEmpty()) {
                    int min = delete(ASC_PQ);
                    sb.append(min);
                } else {
                    sb.append(max);
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

    private int delete(Queue<Integer> pq) {
        int deleteNum;
        while (true) {
            deleteNum = pq.poll();
            int cnt = map.getOrDefault(deleteNum, 0);
            if (cnt == 0) continue;
            
            if (cnt == 1) map.remove(deleteNum);
            else map.put(deleteNum, cnt - 1);
            break;
        }
        return deleteNum;
    }
}