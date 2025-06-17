/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] arr, visited;
    static TreeSet<Integer> tset = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new int[N+1]; // 0: 미방문, 1: 이번사이클, 2: 처리완료

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++){
            if(visited[i] == 0) cycle(i);
        }

        bw.write(tset.size() + "\n");
        for(int n : tset) bw.write(n + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private void cycle(int start) {
        visited[start] = 1;
        int next = arr[start];

        if(visited[next] == 0) {
            cycle(next);
        }
        else if(visited[next] == 1){
            int curr = next;
            
            // 최소 한번은 진행해야 아래 조건 가능. do-while 써도될듯
            tset.add(curr);
            curr = arr[curr];
            
            while(curr != next){
                tset.add(curr);
                curr = arr[curr];
            }

        }
        
        visited[start] = 2;
    }
}