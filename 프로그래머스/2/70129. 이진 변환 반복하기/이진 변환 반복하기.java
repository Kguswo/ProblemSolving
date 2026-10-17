class Solution {
    public int[] solution(String s) {
        String binary = s;
        int convertCnt = 0;
        int zeroCnt = 0;
        while(binary.length() > 1) {
            int len = binary.length();
            int zeros = 0;
            for (int i=0; i<len; i++) {
                if (binary.charAt(i) == '0') {
                    zeros++;
                }
            }
            zeroCnt += zeros;
            convertCnt++;
            binary = Integer.toBinaryString(len - zeros);
        }
        
        return new int[] {convertCnt, zeroCnt};
    }
}