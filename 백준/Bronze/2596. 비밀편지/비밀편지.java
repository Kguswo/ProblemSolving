/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2596_비밀편지/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] codes = {"000000","001111","010011","011100","100110","101001","110101","111010"};

        int n = Integer.parseInt(br.readLine());

        String message = br.readLine();

        StringBuilder result = new StringBuilder();
        boolean decodeFailed = false;
        int failPosition = 0;

        for (int i = 0; i < n; i++) {
            String encoded = message.substring(i * 6, (i + 1) * 6);
            char decoded = decodeChar(encoded, codes);

            if (decoded == '?') {
                decodeFailed = true;
                failPosition = i + 1;
                break;
            }

            result.append(decoded);
        }

        if (decodeFailed) {
            bw.write(String.valueOf(failPosition));
        } else {
            bw.write(result.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private char decodeChar(String encoded, String[] codes) {
        int minDiff = 6;
        int minIndex = -1;

        for (int i = 0; i < codes.length; i++) {
            int diff = getDifference(encoded, codes[i]);

            if (diff <= 1) {
                return (char)('A' + i);
            }

            if (diff < minDiff) {
                minDiff = diff;
                minIndex = i;
            }
        }

        return '?';
    }

    private int getDifference(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}