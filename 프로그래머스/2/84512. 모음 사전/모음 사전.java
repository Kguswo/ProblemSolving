class Solution {
    public int solution(String word) {
        int[] powarr = new int[6];
        powarr[0] = 1;
        for (int i=1; i<=5; i++) {
            powarr[i] = powarr[i-1] * 5;
        }
        
        int[] suffixCnt = new int[6];
        for (int r=0; r<=5; r++) {
            int sum = 0;
            for (int len = 0; len <= r; len++) {
                sum += powarr[len];
            }
            suffixCnt[r] = sum;
        }
        
        String vowels = "AEIOU";
        int ans = 1; // 자신 포함
        
        for (int i=0; i<word.length(); i++) {
            int k = vowels.indexOf(word.charAt(i));
            int remaining = 5-i-1;
            ans += k * suffixCnt[remaining];
        }
        ans += word.length() - 1;
        
        return ans;
    }
}