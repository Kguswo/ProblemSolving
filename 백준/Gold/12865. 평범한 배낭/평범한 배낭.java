// package knapsack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] W, V;
    static int[] knapsack; // i번째 물건의 j번째 무게에서 가질 수 있는 최댓값을 저장할 수 있는 2차원테이블
    static int maxvalue = 0;
    public static void main(String[] args) throws FileNotFoundException {
    	Scanner sc = new Scanner(System.in);
//    	Scanner sc = new Scanner(new File("input.txt"));
    	
    	N = sc.nextInt();
    	K = sc.nextInt();
    	W = new int[N+1]; // 아무것도 넣지않은 인덱스 0도 추가
    	V = new int[N+1];
        
 // dp1차원배열 풀이
    	knapsack = new int[K+1];
    	for (int i = 1; i <= N; i++) {
    		W[i] = sc.nextInt();
    		V[i] = sc.nextInt();
    	}
    	
    	for(int i=1; i<=N; i++) {
    		for(int j=K; j>=W[i]; j--) {
    		/*
    		 * 1차원 dp배열 풀이이다
    		 * 넣을 수 없는 경우 갱신되지 않기 때문에 조건문 필요 없다.
    		 * 넣을 수 있는 경우, 
    		 * i - 1번째 물건까지 고려했을때 무게 j에서의 최대 가치와,
    		 * i - 1번째 물건까지 고려했을때 무게 j - W[i] + V[i] 중 더 큰 값 선택
    		 */ 
    			knapsack[j] = Math.max(knapsack[j], knapsack[j-W[i]]+V[i]);
    		}
    	}
    	System.out.println(knapsack[K]);
    }
}
