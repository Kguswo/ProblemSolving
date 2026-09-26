// 문제 : 바위를 n개 제거한 뒤 각 지점 사이의 거리의 최솟값 중에 가장 큰 값
// 전환 : 모든 간격이 x이상이 되도록 n개 지우는 x값 찾기

import java.util.*;

class Solution {
    
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        return binarySearch(left, right, n, rocks, distance);
    }
    
    private int binarySearch(int left, int right, int target, int[] rocks, int distance) {
        int res = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (checkCnt(mid, rocks, distance) <= target) {
                left = mid + 1;
                res = mid;
            }
            else {
                right = mid - 1;
            }
        }
        
        return res;
    }
    
    // 간격 최소 x 이상이 되는지 체크할것. 반환 값은 몇개 지웠는지
    private int checkCnt(int x, int[] rocks, int distance) {
        int cnt = 0;
        int prev = 0;
        
        for (int r : rocks) {
            if (r - prev < x) {
                cnt++;
            }
            else {
                prev = r;
            }
        }
        
        // 마지막 도착지 별도계산
        if (distance - prev < x) cnt++;
        
        return cnt;
    }
}