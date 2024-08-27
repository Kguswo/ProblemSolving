import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String T, P;
	static int[] pi;
	static List<Integer> positions;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
    	
        T = br.readLine(); P = br.readLine();
        
        pi = getPi();
        
        List<Integer> positions = KMP(); // 일치하는 패턴 시작 위치
        
        
        bw.write(positions.size() + "\n");
        for (int pos : positions) {
            bw.write((pos + 1) + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    static List<Integer> KMP() {    	
        positions = new ArrayList<>();
      
        int j = 0;
        for (int i = 0; i < T.length(); i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            
            if (T.charAt(i) == P.charAt(j)) {
            	// 패턴 찾았을 때
                if (j == P.length() - 1) {
                    positions.add(i-(P.length()-1));
//                    System.out.println(T.substring(i-(P.length()-1), i+1));
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        
        return positions;
    }
    
    static int[] getPi() {
    	int[] pi = new int[P.length()];
    	int j = 0;
    	
    	for (int i = 1; i < P.length(); i++) {
    		while (j > 0 && P.charAt(i) != P.charAt(j)) {
    			j = pi[j - 1];
    		}
    		
    		if (P.charAt(i) == P.charAt(j)) {
    			pi[i] = ++j;
    		}
    	}
    	
    	return pi;
    }
}