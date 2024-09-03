/**
 * Author : nowalex322, Kim Hyeonjae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static Queue<Integer> queue;
	static Set<Integer> plugged;	
	static StringTokenizer st;
	static int n, k, originarr[], arr[], next[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        originarr = new int[k];
        arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
        	int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        
        System.out.println(solve());
        
        br.close();
    }

    public static int solve(){
    	
        plugged = new HashSet<>();
        next = new int[k + 1];
        // arr : 해당 인덱스 전기용품의 다음 사용 시점 인덱스 계산 (ex i번째 인덱스의 다음 사용 시점은 j인덱스 - 같은 제품일 것임)
        // next : 각 전기용품 다음 사용 시점 저장 ( k번 제품이 l인덱스 일 때 사용됩니다, arr 사용해서 계속 업데이트됨)
        
        int count = 0;

        for (int i = 0; i < k; i++) {
//        	System.out.println(Arrays.toString(next));
            if (!plugged.contains(arr[i])) {
                if (plugged.size() == n) {
                    int unplug = unplug(i);
                    plugged.remove(unplug);
                    count++;
//                    System.out.println("뽑기이벤트: " + unplug + " 뽑기");
                }
                plugged.add(arr[i]);
            }
            updateNext(i);;
        }

        return count;
    }

    private static int unplug(int idx) {
    	int furthest = -987654321;
        int unplug = 0;
        for (int p : plugged) {
        	int next = findNext(p,idx);
        	// plugged중 다음 사용시점이 제일 먼 용품 뽑을거기 때문에
            if (next > furthest) {
            	furthest = next;
                unplug = p;
            }
        }
        return unplug;
    }
    
    private static int findNext(int p, int curr) {
        for (int i = curr + 1; i < k; i++) {
            if (arr[i] == p) {
                return i;
            }
        }
        return k;
    }
    
    private static void updateNext(int currentIndex) {
        for (int i = currentIndex; i < k; i++) {
            if (next[arr[i]] <= currentIndex) {
                next[arr[i]] = i;
            }
        }
    }
}
