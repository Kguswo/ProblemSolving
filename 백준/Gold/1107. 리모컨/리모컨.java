import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int buttoncount = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt(); // 이동할 채널번호
		int M = sc.nextInt(); // 고장난 버튼개수
		int count[] = new int [10];
		
		for(int i=0; i<M; i++) {
			count[sc.nextInt()]++;
		}
		List<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<10; i++) {
			if(count[i] == 0) {
				arr.add(i);
			}
		}
//		System.out.println(arr);
//		System.out.println(N);
		
		// 타겟숫자와 차이 가장 적은 숫자 만들고 같은지 다른지 확인
		// 타겟숫자 자릿수 확인하기
		int totaldigitnum = Integer.toString(N).length(); // 자릿수
//		System.out.println("타겟숫자 자릿수 :" + totaldigitnum);
		
		List<Integer> newlymakednum = new ArrayList<Integer>();
		List<Integer> newlymakedlongnum = new ArrayList<Integer>();
		List<Integer> newlymakedshortnum = new ArrayList<Integer>();

		
		// 가장 차이 적은 숫자 만들기
		generateNums(arr, totaldigitnum, 0, 0, newlymakednum);
		generatelongNums(arr, totaldigitnum+1, 0, 0, newlymakedlongnum);
		generateshortNums(arr, totaldigitnum-1, 0, 0, newlymakedshortnum);

//		System.out.println(newlymakednum);
//		System.out.println(newlymakedlongnum);
//		System.out.println(newlymakedshortnum);

		
		int mindiff = Integer.MAX_VALUE;
		int closestnum = 0;
        for (int num : newlymakednum) {
            int difference = Math.abs(N - num);
            if (difference < mindiff) {
            	mindiff = difference;
            	closestnum = num;
            }
        }
        for (int num : newlymakedlongnum) {
            int difference = Math.abs(N - num);
            if (difference < mindiff) {
            	mindiff = difference;
            	closestnum = num;
            }
        }
        if(totaldigitnum!=1 ) {
	        for (int num : newlymakedshortnum) {
	            int difference = Math.abs(N - num);
	            if (difference <= mindiff) {
	            	mindiff = difference;
	            	closestnum = num;
	            }
	        }
        }
        if(newlymakedshortnum.size()==1&&newlymakedshortnum.get(0)==0) {
        	buttoncount = Math.abs(100-N);
        }
        
		totaldigitnum = Integer.toString(closestnum).length();
//		System.out.println("만든숫자 자릿수 :" + totaldigitnum);
        if(closestnum != N) {
        	buttoncount = Math.min(Math.abs(100-N), Math.abs(closestnum-N) + totaldigitnum);
        }
        else if(arr.isEmpty()) buttoncount=Math.abs(100-N);
        else buttoncount = Math.min(Math.abs(100-N), totaldigitnum);
//        System.out.println("가까운수 : " + closestnum + " 버튼횟수 : " + buttoncount);
        if(arr.isEmpty()) buttoncount=Math.abs(100-N);
        System.out.println(buttoncount);
	}
	
    public static void generateNums(List<Integer> list, int totaldigitnum, int currentdigit, int number, List<Integer> newlymakednum) { // 가능한 숫자 조합 생성
        if (currentdigit == totaldigitnum) {
            newlymakednum.add(number);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            generateNums(list, totaldigitnum, currentdigit + 1, number * 10 + list.get(i), newlymakednum);
        }
    }
    // 자리수 바뀌게 만들수도 있어야함 9999타겟 10000생성
    public static void generatelongNums(List<Integer> list, int totaldigitnum, int currentdigit, int number, List<Integer> newlymakednum) { // 가능한 숫자 조합 생성
        if (currentdigit == totaldigitnum) {
            newlymakednum.add(number);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            generateNums(list, totaldigitnum, currentdigit + 1, number * 10 + list.get(i), newlymakednum);
        }
    }
    //100타겟 99생성
    public static void generateshortNums(List<Integer> list, int totaldigitnum, int currentdigit, int number, List<Integer> newlymakednum) { // 가능한 숫자 조합 생성
        if (currentdigit == totaldigitnum) {
            newlymakednum.add(number);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            generateNums(list, totaldigitnum, currentdigit + 1, number * 10 + list.get(i), newlymakednum);
        }
    }
} 