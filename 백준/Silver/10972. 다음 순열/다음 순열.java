/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, nums[];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
		
		if(isNextPermutation()) bw.write(getNextPermutation());
		else bw.write(String.valueOf(-1));
		

		bw.flush();
		bw.close();
		br.close();
	}
		/*
		 * 3 5 4 2 1
		 * 다음순열 구하는법
		 * 끝에서부터 작아지는 구간 있는지 체크해서 5에서 3으로 내려가니까 다음 순열이 존재. (끝까지 오름차순으로 끝나면 없다는거)
		 * 3보다 큰 수 찾아서 바꾸고
		 * 4 5 3 2 1
		 * 다시 끝에서부터 체크해서 전부 내림차순이어야함.
		 * 
		 * 3 4 5 2 1였으면
		 *idx : 인덱스2, target : 인덱스2 , target이랑 idx-1을 교환
		 * 3 5 4 2 1가 됐다가
		 * 3 5 1 2 4로 돌려야함. 
		 */
	private String getNextPermutation() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
            sb.append(nums[i] + " ");
        }
		return sb.toString();
	}

	private void swap(int i, int j) {
		int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;		
	}

	private boolean isNextPermutation() {
		int i = N-1;
		 while (i>0 && nums[i-1] >= nums[i]) {
	            i--; 
	        }
	        if (i <= 0) return false;
	 
	        int j = nums.length - 1;
	        while (nums[j] <= nums[i-1]) {
	            j--; 
	        }
	 
	        swap(i-1, j);
	        j = nums.length - 1;
	        while (i<j) {
	            swap(i, j);
	            i++;
	            j--;
	        }
	        return true;
	}
}