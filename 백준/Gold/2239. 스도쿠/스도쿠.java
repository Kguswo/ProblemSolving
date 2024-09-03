/**
 * Author : nowalex322, Kim hyeonjae
 */
import java.io.*;
import java.util.*;

/**
 * 비트마스킹 연습
 */
public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringBuilder sb = new StringBuilder();
	static int map[][], checkRow[], checkCol[], check3by3[][];
    static List<int[]> listToSolve = new ArrayList<>();
    private static boolean solved = false;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new int[10][10];
        checkRow = new int[10];
        checkCol = new int[10];
        check3by3 = new int[4][4];

        for (int i=1; i<=9; i++) {
            String s = br.readLine();
            for (int j=1; j<=9; j++) {
                int num = s.charAt(j-1) - '0';
                checkRow[i] |= 1 << num;
                checkCol[j] |= 1 << num;
                check3by3[((i-1)/3)+1][((j-1)/3)+1] |= 1 << num;
                map[i][j] = num;
                if (num == 0) {
                	listToSolve.add(new int[]{i, j});
                }
            }
        }

        sudoku(0);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void sudoku(int idx) {
        if (solved) return;
        
        if (idx == (listToSolve.size())) {
            for (int i=1; i<=9; i++) {
                for (int j=1; j<=9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            solved = true;
            return;
        }

        int[] zero = listToSolve.get(idx);
        int r = zero[0];
        int c = zero[1];
        for (int i=1; i<=9; i++) {
            if (((checkRow[r] & 1<<i) == 0) && ((checkCol[c] & 1<<i) == 0) && ((check3by3[((r-1)/3)+1][((c-1)/3)+1] & 1<<i) == 0)) {
                map[r][c] = i;
                checkRow[r] |= 1 << i;
                checkCol[c] |= 1 << i;
                check3by3[((r - 1) / 3) + 1][((c - 1) / 3) + 1] |= 1 << i;
                sudoku(idx + 1);
                
                map[r][c] = 0;
                checkRow[r] &= ~(1 << i);
                checkCol[c] &= ~(1 << i);
                check3by3[((r - 1) / 3) + 1][((c - 1) / 3) + 1] &= ~(1 << i);
            }
        }
    }
}