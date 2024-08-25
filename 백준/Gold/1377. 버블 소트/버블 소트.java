import java.io.*;

public class Main {
	static int N, arr[], count[], sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        count = new int[1000001];

        /**
         * 각 숫자 등장횟수 세기
         * 인덱스값의 숫자가 몇번 등장했는지 저장
         */
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            count[arr[i]]++;
        }

        /**
         * 누적 합 계산
         * count 순회하며 각 숫자보다 작거나 같은 숫자들의 총 개수 계산
         * 이후 count[i]는 i보다 작거나 같은 숫자의 개수 - 1을 나타냄
         */
        sum = 0;
        for (int i = 0; i <= 1000000; i++) {
        	sum += count[i];
            count[i] = sum - 1;
        }

        /**
         * 최대 이동 거리 계산
         * 각 숫자의 현재 위치와 정렬 후 위치의 차이 중 최댓값 찾기
         * i - count[arr[i]]: 현재 위치 - 정렬 후 위치
         */
        int ans = 0;
        for (int i = 0; i < N; i++) {
        	ans = Math.max(ans, i - count[arr[i]]);
        }

        System.out.println(ans + 1);
    }
}