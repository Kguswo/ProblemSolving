import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] hasClothes = new boolean[n+2];
        for (int i=1; i<=n; i++) {
            hasClothes[i] = true;
        }
        
        Set<Integer> lostSet = new HashSet<>();
        for (int l : lost) {
            lostSet.add(l);
        }
        Set<Integer> reserveSet = new HashSet<>();
        for (int r : reserve) {
            reserveSet.add(r);
        }
        
        for (int l : lost) {
            if(reserveSet.contains(l)) {
                reserveSet.remove(l);
                lostSet.remove(l);
            }
            else {
                hasClothes[l] = false;
            }
        }
        
        for (int r : reserveSet) {
            for (int lostNum : new ArrayList<>(lostSet)) {
                if (lostNum == r-1 || lostNum == r+1) {
                    hasClothes[lostNum] = true;
                    lostSet.remove(lostNum);
                    break;
                }
            }
        }
        
        int ans = 0;
        for (int i=1; i<=n; i++) {
            if (hasClothes[i]) ans++;
        }
        
        return ans;
    }
}