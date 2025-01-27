/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_18115_카드놓기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            기술 1 : 덱 맨 앞에 넣기
            기술 2 : 덱 맨앞 제거(기억) 후 넣고 다시 넣기 ( 맨 앞에서 두번째 넣기)
            기술 3 : 맨 뒤에 넣기
         */
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Deque<Integer> command = new ArrayDeque<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            command.addLast(Integer.parseInt(st.nextToken()));
        }

        for(int i=1; i <= N; i++) {
            int c = command.removeLast();
            if(c==1){
                deque.addFirst(i);
            }
            else if(c==2){
                int first = deque.removeFirst();
                deque.addFirst(i);
                deque.addFirst(first);
            }
            else{
                deque.addLast(i);
            }
        }

        while(!deque.isEmpty()) {
            sb.append(deque.removeFirst() + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
