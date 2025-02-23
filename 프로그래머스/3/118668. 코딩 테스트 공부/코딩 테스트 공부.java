class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAl = -1;
        int maxCo = -1;
        for(int i=0; i<problems.length; i++){
            if(problems[i][0] > maxAl) maxAl = problems[i][0];
            if(problems[i][1] > maxCo) maxCo = problems[i][1];
        }
        
        // 바로 다 풀수있음
        if(alp >= maxAl && cop >= maxCo) return 0;
        
        // 최댓값만 능력으로 가지고있어도 됨
        if(alp >= maxAl) alp = maxAl;
        if(cop >= maxCo) cop = maxCo;
        
        int[][] time = new int[maxAl + 2][maxCo + 2];
        for(int i=alp; i<=maxAl; i++){
            for(int j=cop; j<=maxCo; j++){
                time[i][j] = Integer.MAX_VALUE;
            }
        }
        time[alp][cop] = 0;
        for(int i=alp; i<=maxAl; i++){
            for(int j=cop; j<=maxCo; j++){
                // 1시간에 1 증가
                int currT = time[i][j];
                if(currT == Integer.MAX_VALUE) continue;
                
                time[i+1][j] = Math.min(currT + 1, time[i+1][j]);
                time[i][j+1] = Math.min(currT + 1, time[i][j+1]);
                
                for(int k=0; k<problems.length; k++){
                    int[] currP = problems[k];
                     
                    // 문제 풀 수 있을때
                    if(i>=currP[0] && j>=currP[1]) {
                        int nextAl = i + currP[2];
                        int nextCo = j + currP[3];
                        int nextT = currT + currP[4];

                        nextAl = Math.min(nextAl, maxAl);
                        nextCo = Math.min(nextCo, maxCo);

                        time[nextAl][nextCo] = Math.min(nextT, time[nextAl][nextCo]);
                    }
                    
                }
            }
        }
        return time[maxAl][maxCo];
    }
}