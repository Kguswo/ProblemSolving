
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

    //10번의 테스트케이스
        for(int tc = 0; tc<10; tc++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int house = 0;

            //n개의 숫자 입력받음
            for (int i=0; i<n; i++) {
                int num = sc.nextInt();
                arr[i] = num;
            }

            for (int i=2; i<(n-2); i++) {
                int max = 0;
                //양 옆 4개중 최댓값 구하기
                int maxarr[] = {arr[i-2], arr[i-1], arr[i+1], arr[i+2]};
                for(int j=0; j<4; j++) {
                    if(maxarr[j]>max) {
                        max = maxarr[j];
                    }
                }
                //세대 개수 더하기
                if(arr[i]>=max) {
                    house += arr[i] - max;
                }
            }
        System.out.println("#" + (tc+1) + " " + house);
		}
	}
}

