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
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(minHeap.size() == maxHeap.size()) {
                maxHeap.offer(num);
            }
            else minHeap.offer(num);

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(maxHeap.peek() > minHeap.peek()) {
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}