/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Cow{
        int idx, height;
        public Cow(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_24492_CowFrisbee/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Cow> stack_LtoR = new Stack<>();
        long res = 0;
        for(int i = 0; i < N; i++) {
            Cow currCow = new Cow(i, arr[i]);
            while(!stack_LtoR.isEmpty()) {
                if(stack_LtoR.peek().height < currCow.height) {
                    Cow tmpCow = stack_LtoR.pop();
                    res += currCow.idx - tmpCow.idx + 1;
                }
                else break;
            }
            stack_LtoR.push(currCow);
        }

        Stack<Cow> stack_RtoL = new Stack<>();
        for(int i = N-1; i >=0; i--) {
            Cow currCow = new Cow(i, arr[i]);
            while(!stack_RtoL.isEmpty()) {
                if(stack_RtoL.peek().height < currCow.height) {
                    Cow tmpCow = stack_RtoL.pop();
                    res += tmpCow.idx - currCow.idx + 1;
                }
                else break;
            }
            stack_RtoL.push(currCow);
        }
        System.out.println(res);
        br.close();
    }
}