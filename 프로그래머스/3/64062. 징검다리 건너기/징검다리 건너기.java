import java.util.Arrays;

class Solution {

public static int solution(int[] stones, int k) {
		int low = 1; 
		int high = 200000000; 
		int mid = 0;
		int answer = 0;

		while(low <= high){
			mid = (low + high) / 2; 

			if(!cross(stones, k, mid)) {
				high = mid - 1; 
			} else {
				low = mid + 1; 
				answer = Math.max(answer, mid); 
			}
		}

		return answer;
	}
	
	public static boolean cross(int[] stones, int k, int mid) {
		int cnt = 0;

		for (int stone : stones) {
			if (stone - mid < 0) { 
				cnt++;
			} else {
				cnt = 0;
			}

			if (cnt == k) 
				return false;
		}

		return true; 
	}
}