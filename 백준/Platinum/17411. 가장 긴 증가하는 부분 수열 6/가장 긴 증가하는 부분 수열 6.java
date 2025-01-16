/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000007;

    static class Pair{
        int length;
        long count;
        public Pair(int length, long count){
            this.length = length;
            this.count = count;
        }
    }

    static Pair merge(Pair a, Pair b){
        if(a.length > b.length) return a;
        else if (a.length < b.length) return b;
        // 같은 길이일때는 count를 더함
        return new Pair(a.length, (a.count + b.count) % MOD);
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, arr[], compressed[];
    static Pair segment[];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_17411_가장긴증가하는부분수열6/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 좌표압축
        TreeSet<Integer> uniqueSet = new TreeSet<>();
        for(int n : arr) uniqueSet.add(n);
        ArrayList<Integer> unique = new ArrayList<>(uniqueSet); // 중복제거
        compressed = new int[N];
        for(int i = 0; i < N; i++){
            int pos = binarySearch(unique, arr[i]);
            compressed[i] = pos + 1; // 1-based
        }

        int uniqueSize = unique.size();
        segment = new Pair[4*uniqueSize];
        for (int i=0; i<4*uniqueSize; i++) {
            segment[i] = new Pair(0, 0);
        }

        for(int i=0; i<N; i++){
            // 지금i위치보다 앞에있는 작은수들 중 LIS 찾기
            Pair curr = query(1, compressed[i]-1, 1, uniqueSize, 1);

            /*
            지금위치i까지 포함해서 길이 1 증가
            count가 0일땐 새로운수열 시작 (1)
            count가 0아닐땐 이전까지 count 다 더함
            */
            Pair newValue = new Pair(curr.length + 1, Math.max(curr.count, 1));

            update(compressed[i], newValue, 1, uniqueSize, 1);
        }

        Pair result = query(1, uniqueSize, 1, uniqueSize, 1);
        
        bw.write(result.length + " " + result.count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int binarySearch(ArrayList<Integer> unique, int target) {
        int left = 0, right = unique.size() - 1;
        int res = 0;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(unique.get(mid) >= target) {
                res = mid;
                right = mid - 1;
            } 
            else left = mid + 1;
        }
        return res;
    }

    /*
    구간 [left, right]에서 최댓값 찾기
     */
    static Pair query(int left, int right, int start, int end, int node){
        if(left > end || right < start) return new Pair(0, 0);

        if(left <= start && end <= right) return segment[node];

        int mid = start + (end-start)/2;
        Pair leftRes = query(left, right, start, mid, node*2);
        Pair rightRes = query(left, right, mid+1, end, node*2 + 1);
        
        return merge(leftRes, rightRes);
    }

    /*
    pos 위치를 value로 업데이트
     */
    static void update(int pos, Pair value, int start, int end, int node){
        if(pos > end || pos < start) return;

        if(start == end){
            segment[node] = merge(segment[node], value);
            return;
        }

        int mid = start + (end-start)/2;
        update(pos, value, start, mid, node * 2);
        update(pos, value, mid+1, end, node * 2 + 1);

        segment[node] = merge(segment[node * 2], segment[node * 2 + 1]);
    }

}