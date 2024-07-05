// import java.util.*;
// import java.lang.Math;

// class Solution {
//     static int size;
//     public int solution(int[] money) {
//         int answer = 0;
//         size = money.length;
//         if(size%2 == 0) { // 짝수개
//             int oddsum = 0; int evensum = 0;
//             for(int i=0; i<size; i++){
//                 if(i%2!=0) oddsum+=money[i];
//                 else evensum+=money[i];
//             }
//             answer = Math.max(oddsum, evensum);
//         }
//         else{ // 홀수개
//             int[] moneycopy = new int[2*size];
//             for(int i=0; i<size; i++){
//                 moneycopy[i] = money[i];
//                 moneycopy[i+size] = money[i];
//             }
//             for(int i=0; i<size; i++){
//                 // size/2개 만큼 i부터 퐁당퐁당으로 골라서 더할거임
//                 int sum = 0;
//                 for(int j=i; j<i+size-1; j+=2){
//                     sum += moneycopy[j];
//                 }
//                 answer = Math.max(answer, sum);
//             }
//         }
//         return answer;
//     }
// }
import java.util.*;
import java.lang.Math;

class Solution {
    static int size;
    public int solution(int[] money) {
        int answer = 0;
        size = money.length;
        
        if (size == 3) {
            return Math.max(money[0] + money[2], money[1]);
        }
        
        int[] dp1 = new int[size+1]; // 1번집선택
        int[] dp2 = new int[size+1]; // 1번집선택x

        dp1[0] = 0;
        dp1[1] = money[0];
        dp1[2] = money[0];
        for(int i=3; i<size; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+money[i-1]);
        }
        dp2[0] = 0;
        dp2[1] = 0;
        dp2[2] = money[1];
        for(int i=3; i<=size; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i-1]);
        }
        return Math.max(dp1[size-1], dp2[size]);
    }
}
    