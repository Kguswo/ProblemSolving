/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K, bookCnt, categorySize;
    static long dp[][];
    static ArrayList<Integer>[] books;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_5550_헌책방/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new long[11][K + 1];

        books = new ArrayList[11];
        for (int i = 0; i < 11; i++) {
            books[i] = new ArrayList<>();
        }

        int price, category;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            price = Integer.parseInt(st.nextToken());
            category = Integer.parseInt(st.nextToken());
            books[category].add(price);
        }

        for (int i = 1; i <= 10; i++) {
            Collections.sort(books[i], Collections.reverseOrder());

            ArrayList<Integer> tmp = new ArrayList<>(books[i]);

            for (int j = 1; j < books[i].size(); j++) {
                books[i].set(j, books[i].get(j) + books[i].get(j - 1));
            }

            for (int j = 1; j < books[i].size(); j++) {
                books[i].set(j, books[i].get(j) + j * (j + 1));
            }
        }
        
        int res = 0;
        bookCnt = 0;
        for (int i = 1; i <= 10; i++) {
            categorySize = books[i].size();
            /* 헷갈린부분
             * 똑같은 개수로 진행되어야하므로 이전에 골랐든 안골랐든 cnt만큼 추가
             * 예를 들면 앞 종류에서 2개 뒷종류에서 3개랑 같은 선상에서 뒷종류만 5개를 고른경우가 비교되어야하므로 min(K, size)하면안됨! 놓치는 경우생김
             */
            int leftAmount = Math.min(K, bookCnt + categorySize);
            for (int j = 0; j <= leftAmount; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= categorySize; k++) {
                    if (j >= k) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + books[i].get(k - 1));
                }
            }
            bookCnt = Math.min(bookCnt + categorySize, K);
        }

        bw.write(String.valueOf(dp[10][K]));
        bw.flush();
        bw.close();
        br.close();
    }
}