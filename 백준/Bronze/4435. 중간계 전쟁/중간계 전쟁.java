/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] G = new int[6];
            
            for (int j = 0; j < 6; j++) 
                G[j] = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int[] S = new int[7];
            for (int j = 0; j < 7; j++)
                S[j] = Integer.parseInt(st.nextToken());
            
            int G_score = G[0] + G[1] * 2 + (G[2] + G[3]) * 3 + G[4] * 4 + G[5] * 10;
            int S_score = S[0] + (S[1] + S[2] + S[3]) * 2 + S[4] * 3 + S[5] * 5 + S[6] * 10;
            
            if (G_score > S_score) System.out.printf("Battle %d: Good triumphs over Evil\n", i);
            else if (G_score < S_score) System.out.printf("Battle %d: Evil eradicates all trace of Good\n", i);
            else System.out.printf("Battle %d: No victor on this battle field\n", i);
        }
        
        br.close();
    }
}