import java.io.*;

public class Main {
  
    static class Number {
        public int n, idx;
        public Number (int n,int idx) {
            this.n = n;
            this.idx = idx;
        }              
    }
    
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        
        String[] str = br.readLine().split(" ");        
        Number a[] = new Number[n];                        
        for(int i=0; i<n;i++) {                            
            a[i] = new Number(Integer.parseInt(str[i]),i);
        }
        int b[] = new int[n];                            
        for(int i = 0;i<n;i++) {
            int min = a[0].n;                             
            int minIdx = 0;                                
            for(int j=1; j<n; j++) {                    
                if(a[minIdx].n > a[j].n) {                
                    min = a[j].n;
                    minIdx = j;
                }
            }
            
            b[i] = minIdx;                                
            a[minIdx].n = 100000;                        
        }
        for(int i=0; i<n; i++) {
            for(int j=0;j<n;j++) {
                if(a[i].idx == b[j])                    
                    bw.write(j + " ");                    
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}