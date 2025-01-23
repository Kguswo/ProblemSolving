/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Trie{
        Trie[] childred = new Trie[2];

        void insert(int num){
            Trie node = this; // 현재노드부터 시작
            // 32비트 정수의 각 비트를 순회 (MSB부터 LSB까지)
            // i = 31부터 이유: int는 32비트이므로 가장 왼쪽 비트 31
            for(int i=31; i>=0; i--){
                int bit = (num >> i) & 1; // x의 i번째 비트
                if(node.childred[bit]==null){ // 가려고하는 그 경로 없으면 새로 생성
                    node.childred[bit] = new Trie();
                }
                node = node.childred[bit]; // 다음으로 이동
            }
        }

        int getMaxXOR(int num){
            Trie node = this;
            int res=0;
            for(int i=31; i>=0; i--){
                int bit = (num >> i) & 1;
                if(node.childred[1-bit] != null){ // XOR을 위해 반대비트값 찾는데 있으면
                    res |= (1 << i);
                    node = node.childred[1-bit]; // 다음으로 이동
                }
                else{
                    node = node.childred[bit];
                }
            }
            return res;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, arr[], maxXOR, cumulativeXOR;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_13504_XOR합/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Trie trie = new Trie();
            trie.insert(0);
            maxXOR = 0;
            cumulativeXOR = 0;

            for(int i = 0; i < N; i++){
                cumulativeXOR ^= arr[i]; // 누적 XOR
                trie.insert(cumulativeXOR); // 현재까지 누적 XOR 넣기
                maxXOR = Math.max(maxXOR, trie.getMaxXOR(cumulativeXOR));
            }

            sb.append(maxXOR).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}