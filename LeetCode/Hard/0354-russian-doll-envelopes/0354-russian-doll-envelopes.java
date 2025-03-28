import java.util.*;

class Solution {
    class Size implements Comparable<Size>{
        int x, y;
        public Size(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Size o){
            if(this.x == o.x) return o.y - this.y;
            return this.x - o.x;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Size[] sizes = new Size[n];
        for(int i=0; i<n; i++){
            sizes[i] = new Size(envelopes[i][0], envelopes[i][1]);
        }

        Arrays.sort(sizes);

        int[] dp = new int[n]; // LIS
        int len = 0;

        for(Size s : sizes){ // x기준 오름차순, y는 내림차순
            int left = 0, right = len-1;

            int res = len; // 맨뒤 삽입 디폴트, res 위치가 새 LIS값 삽입할 위치.
            while(left<=right){
                int mid = left + (right-left)/2;
                if(dp[mid] >= s.y) {
                    res = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }

            dp[res] = s.y;

            if(res == len) len++; // 맨끝 삽입한 경우
        }
        return len;
    }
}