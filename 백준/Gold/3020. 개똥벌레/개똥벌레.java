/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    public class FastReader {
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[16384];
            bufferPointer = bytesRead = 0;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, buffer.length);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }
    }
    static FastReader fr;
    static StringBuilder sb = new StringBuilder();
    static int N, H, nums[], odd[], even[], count[], min = Integer.MAX_VALUE;
    static Map<Integer, List<Integer>> breakMap = new HashMap<>(); // key : 부수는횟수, value : 해당 구간들
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        fr = new FastReader();
        N = fr.nextInt();
        H = fr.nextInt();
        nums = new int[N+1];
        odd = new int[H+1]; // 홀수번째(석순) 누적합
        even = new int[H+1]; // 짝수번째(종유석) 누적합
        count = new int[H+1]; // 구간별 부술 개수 누적합배열

        for(int i = 1; i <= N; i++) {
            nums[i] = fr.nextInt();
        }

        for(int i=1; i<=N; i++){
            if(i%2 == 1) odd[nums[i]]++;
            else even[(H+1) - nums[i]]++;
        }
        // 홀수는 끝부터 누적합
        for(int i=H-1; i>=1; i--){
            odd[i] += odd[i+1];
        }
        // 짝수는 처음부터 누적합
        for(int i=2; i<=H; i++){
            even[i] += even[i-1];
        }

        for(int i=1; i<=H; i++){
            count[i] = odd[i] + even[i];
        }

        for(int i=1; i<=H; i++){
            if(!breakMap.containsKey(count[i])) breakMap.put(count[i], new ArrayList<>());
            breakMap.get(count[i]).add(i);
            if(min > count[i]) min = count[i];
        }
        sb.append(min).append(" ").append(breakMap.get(min).size());
        System.out.println(sb);
    }
}