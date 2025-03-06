import java.util.*;

class Solution {
    static StringBuilder sb;
    static long[] totalCnt, pow26;
    public String solution(long n, String[] bans) {
        String answer = "";
        
        // 누적합으로 길이별 개수 계산
        pow26 = new long[12];
        pow26[0] = 1;
        for(int i=1; i<=11; i++){
            pow26[i] = pow26[i-1] * 26;
        }
        totalCnt = new long[12];
        totalCnt[0] = 0;
        for(int i=1; i<=11; i++){
            totalCnt[i] = totalCnt[i-1] + pow26[i];
        }
        
        
        // 밴 목록 위치 값으로 변환
        long[] banPos = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            banPos[i] = wordToPos(bans[i]);
        }
        Arrays.sort(banPos);
        
        long targetPos = n;
        for(long b : banPos){
            if(b <= targetPos){
                targetPos++;
            }
            else break;
        }
        
        return posToWord(targetPos);
    }
    private static long wordToPos(String word){
        int len = word.length();
        long pos = totalCnt[len-1] + 1;
        
        for(int i=0; i<len; i++){
            int charVal = word.charAt(i) - 'a';
            pos += charVal * pow26[len - 1 -i];
        }
        return pos;
    }
    
    private static String posToWord(long pos){
        int len = 1;
        while(len <= 11 && totalCnt[len] < pos){
            len++;
        }
        
        long offset = pos - 1 - totalCnt[len-1];
        
        sb = new StringBuilder();
        for(int i=len-1; i>=0; i--){
            int digit = (int) (offset/pow26[i]);
            sb.append((char)('a' + digit));
            offset -= digit * pow26[i];
        }
        return sb.toString();
    }
}