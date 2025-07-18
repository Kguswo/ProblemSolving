/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int X;
    static double Y;
    static long[][] comb;
    static final int MOD = 20150116;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/제9회천하제일코딩대회본선OpenContest/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Double.parseDouble(st.nextToken());

        comb = new long[X+1][X+1];
        for(int i=0; i<=X; i++){
            comb[i][0] = 1;
            for(int j=1; j<=i; j++){
                comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % MOD;
            }
        }

        long res = 0;

        for(int a=0; a<=X; a++){
            for(int b=0; b<=X-a; b++){
                for(int c=0; c<=X-a-b; c++){
                    for(int d=0; d<=X-a-b-c; d++){
                        for(int e=0; e<=X-a-b-c-d; e++){
                            int f = X-a-b-c-d-e;

                            if(a+b+c+d+e+f == 0 || a+b+c+d+f == 0) continue;

                            double OBP = (double) (a+b+c+d+e)/(a+b+c+d+e+f);
                            double SLG = (double) (a+2*b+3*c+4*d)/(a+b+c+d+f);
                            double OPS = OBP + SLG;

                            if(OPS >= Y){
                                long num = getNum(a, b, c, d, e);
                                res = (res + num) % MOD;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(res);

        bw.flush();
        bw.close();
        br.close();
    }

    private long getNum(int a, int b, int c, int d, int e) {
        long tmp = 1;
        int x = X;
        tmp = (tmp * comb[x][a]) % MOD;
        x-=a;
        tmp = (tmp * comb[x][b]) % MOD;
        x-=b;
        tmp = (tmp * comb[x][c]) % MOD;
        x-=c;
        tmp = (tmp * comb[x][d]) % MOD;
        x-=d;
        tmp = (tmp * comb[x][e]) % MOD;
        x-=e;
        // f는 빈자리채우기라 *1
        return tmp;
    }
}