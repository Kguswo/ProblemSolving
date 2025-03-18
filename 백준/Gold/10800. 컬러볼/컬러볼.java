/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Ball implements Comparable<Ball>{
        int idx, C, S;
        public Ball(int idx, int color, int size){
            this.idx = idx;
            this.C = color;
            this.S = size;
        }

        @Override
        public int compareTo(Ball o) {
            if(this.S == o.S) return this.C - o.C;
            return this.S - o.S;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, colorSum[][], res[];
    static Ball[] balls;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
            br = new BufferedReader(new InputStreamReader(System.in));
//            br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_10800_컬러볼/input.txt")));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            balls = new Ball[N];
            res = new int[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                Ball ball = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                balls[i] = ball;
            }

            Arrays.sort(balls);

            // color 1-based
            int sum = 0;
            colorSum = new int[N+1][2]; // j=0 : 이전사이즈까지 합, j=1 : 같은 사이즈 크기

            int finalSize=0; // 바로전 공 사이즈(지금이랑 같거나 작음)
            int sameSizeSum = 0; // 같은 크기 공들 사이즈 합

            for(int i=0; i<N; i++){
                Ball curr = balls[i];

                if(curr.S != finalSize){
                    sum += sameSizeSum; // 지금이랑 같은 크기 공들 다 전체에 더해줌(이제 다음 크기로 고려)

                    for(int c=1; c<=N; c++){
                        colorSum[c][0] += colorSum[c][1];
                        colorSum[c][1] = 0;
                    }

                    finalSize = curr.S;

                    // 다음 크기로 넘어감
                    sameSizeSum = 0;
                }

                // 지금까지 합 - 같은색
                res[curr.idx] = sum - colorSum[curr.C][0];

                colorSum[curr.C][1] += curr.S;
                sameSizeSum += curr.S;
            }

            for (int i = 0; i < N; i++) {
                sb.append(res[i] + "\n");
            }
            System.out.println(sb.toString());
            br.close();
    }
}