import java.io.*;

public class Main{
    static int n;
    static int m;
    static int[][] paper;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line[] = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        
        
        paper = new int[n][m];
        
        for(int i=0; i < n; i++){
            line = br.readLine().split(" ");
            for(int j=0; j < m; j++){
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        int max = 0;
        for(int i=0; i < n; i++){
            for(int j=0; j < m; j++){
                max = Math.max(max, put(i, j));
            }
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
    }
    
    private static int put(int y, int x){
        int ret_val = 0;
        
        // 1번 테트로미노 : 우측, 아래측이 넘어가지 않는 지 확인 
        // ㅇㅇ
        // ㅇ
        // ㅇ
        if(y+2 <= n-1 && x+1 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y][x+1] + paper[y+1][x] + paper[y+2][x]);
        }
        
        // 2번 테트로미노 : 우측, 아래측이 넘어가지 않는 지 확인
        // ㅇㅇ
        //   ㅇ
        //   ㅇ
        if(y+2 <= n-1 && x+1 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y][x+1] + paper[y+1][x+1] + paper[y+2][x+1]);
        }
        
        // 3번 테트로미노 : 우측, 아래측이 넘어가지 않는 지 확인
        // ㅇㅇㅇ
        // ㅇ
        if(y+1 <= n-1 && x+2 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y][x+1] + paper[y][x+2]);
        }
        
        // 4번 테트로미노 : 우측, 아래측이 넘어가지 않는 지 확인
        // ㅇㅇㅇ
        //     ㅇ
        if(y+1 <= n-1 && x+2 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y][x+1] + paper[y][x+2] + paper[y+1][x+2]);
        }
        
        // 5번 테트로미노 : 우측, 아래측이 넘어가지 않는 지 확인
        // ㅇㅇ
        // ㅇㅇ
        if(y+1 <= n-1 && x+1 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y][x+1] + paper[y+1][x+1]);
        }
        
        // 6번 테트로미노 : 우측, 아래측이 넘어가지 않는 지 확인
        // ㅇ
        // ㅇ
        // ㅇㅇ
        if(y+2 <= n-1 && x+1 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+2][x] + paper[y+2][x+1]);
        }
        
        // 7번 테트로미노 : 좌측, 아래측이 넘어가지 않는 지 확인
        //   ㅇ
        //   ㅇ
        // ㅇㅇ
        if(y+2 <= n-1 && x-1 >= 0){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+2][x] + paper[y+2][x-1]);
        }
        
        // 8번 테트로미노 : 좌측, 아래측이 넘어가지 않는 지 확인
        //     ㅇ
        // ㅇㅇㅇ
        if(y+1 <= n-1 && x-2 >= 0){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+1][x-1] + paper[y+1][x-2]);
        }
        
        // 9번 테트로미노 : 우측, 아래측이 넘어가지 않는 지 확인
        // ㅇ
        // ㅇㅇㅇ
        if(y+1 <= n-1 && x+2 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+1][x+1] + paper[y+1][x+2]);
        }
        
        // 10번 테트로미노 : 아래측이 넘어가지 않는 지 확인
        // ㅇ
        // ㅇ
        // ㅇ
        // ㅇ
        if(y+3 <= n-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+2][x] + paper[y+3][x]);
        }
        
        // 11번 테트로미노 : 우측, 아래측이 넘어가지 않는 지 확인
        // ㅇ
        // ㅇㅇ
        //   ㅇ
        if(y+2 <= n-1 && x+1 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+1][x+1] + paper[y+2][x+1]);
        }
        
        // 12번 테트로미노 : 좌측, 아래측이 넘어가지 않는 지 확인
        //   ㅇ
        // ㅇㅇ
        // ㅇ
        if(y+2 <= n-1 && x-1 >= 0){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+1][x-1] + paper[y+2][x-1]);
        }
        
        // 13번 테트로미노 : 좌측, 우측, 아래측이 넘어가지 않는 지 확인
        //   ㅇㅇ
        // ㅇㅇ
        if(y+1 <= n-1 && x-1 >= 0 && x+1 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y][x+1] + paper[y+1][x] + paper[y+1][x-1]);
        }
        
        // 14번 테트로미노 : 우측, 아래측이 넘어가지 않는 지 확인
        // ㅇㅇ
        //   ㅇㅇ
        if(y+1 <= n-1 && x+2 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y][x+1] + paper[y+1][x+1] + paper[y+1][x+2]);
        }
        
        // 15번 테트로미노 : 우측이 넘어가지 않는 지 확인
        // ㅇㅇㅇㅇ
        if(x+3 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y][x+1] + paper[y][x+2] + paper[y][x+3]);
        }
        
        // 16번 테트로미노 : 좌, 우, 아래측이 넘어가지 않는 지 확인
        //   ㅇ
        // ㅇㅇㅇ
        if(y+1 <= n-1 && x-1 >= 0 && x+1 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+1][x-1] + paper[y+1][x+1]);
        }
        
        // 17번 테트로미노 : 좌, 우, 아래측이 넘어가지 않는 지 확인
        // ㅇㅇㅇ
        //   ㅇ
        if(y+1 <= n-1 && x-1 >= 0 && x+1 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y][x+1] + paper[y][x-1] + paper[y+1][x]);
        }
        
        // 18번 테트로미노 : 좌, 아래측이 넘어가지 않는 지 확인
        //   ㅇ
        // ㅇㅇ
        //   ㅇ
        if(y+2 <= n-1 && x-1 >= 0){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+2][x] + paper[y+1][x-1]);
        }
        
        // 19번 테트로미노 : 좌, 우, 아래측이 넘어가지 않는 지 확인
        // ㅇ
        // ㅇㅇ
        // ㅇ
        if(y+2 <= n-1 && x+1 <= m-1){
            ret_val = Math.max(ret_val, paper[y][x] + paper[y+1][x] + paper[y+2][x] + paper[y+1][x+1]);
        }
        return ret_val;
    }
}