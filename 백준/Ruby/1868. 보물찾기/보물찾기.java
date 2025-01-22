/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, a, b, res;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1868_보물찾기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        res = dfs(1, 0);

        bw.write(String.valueOf(31 - Integer.numberOfLeadingZeros(res)));
        bw.flush();
        bw.close();
        br.close();
    }

    private int dfs(int curr, int parent){
        int currBitMask = 0; // 비트마스크를 사용하여 서브트리의 상태를 관리 (깊이)
        /*
            이진수: 0001 = 깊이 0 = 바로 옆 방을 확인하면 됨
            이진수: 0010 = 깊이 1 = 2번의 질문이 필요함
            이진수: 0100 = 깊이 2 = 3번의 질문이 필요함
         */
        int maxHeight = 0;

        /*
            각 노드에서:
              - 자식 노드들의 결과를 비트마스크로 합침
              - 겹치는 부분이 있으면 그 중 가장 높은 비트 위치를 찾음
              - 현재 노드의 비트마스크를 적절히 조정
         */

        // 현재 노드의 모든 자식 노드들 순회
        for(int child : tree[curr]){
            if(child == parent) continue;

            // 자식서브트리 결과
            int childBitMask = dfs(child, curr);

            // 현재 비트마스크와 자식 결과 사이에 겹치는 서브트리 있으면
            if((childBitMask & currBitMask) != 0){
                // 겹치는 비트 중 가장 높은 위치 찾기, 즉 더 깊은 깊이가 필요함
                maxHeight = Math.max(maxHeight, 31- Integer.numberOfLeadingZeros(childBitMask & currBitMask));
            }

            // 현재 비트마스크에 자식결과 합침
            currBitMask |= childBitMask;
        }

        // 현재 노드의 최종 비트마스크 계산
        currBitMask += 1 << maxHeight; // 갈래가 2개면 (4, 5), 한번 더 진행해야한다는 것이므로 깊이 하나 증가한다는 의미

        // maxHeight가 0이 아니면 비트마스크 조정
        if(maxHeight > 0){
            currBitMask >>= maxHeight;
            currBitMask <<= maxHeight;
        }
        return currBitMask;
    }
}