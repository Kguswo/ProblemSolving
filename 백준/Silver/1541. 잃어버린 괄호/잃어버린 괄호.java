import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static String str;
	static boolean flag;
	static int idx=0, minsum=0, end=0;
	static int [][] board;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		
		str = sc.next();
//		System.out.println(str);
		calculate(0, 0, str, false);
		
//		while(idx<str.length()) {
////			System.out.println("idx : " + idx + " end : " + end);
//			
//			while(end < str.length()) {
//				if(str.charAt(end) == '-' || str.charAt(end) == '+') break;
////				System.out.println("값 : " + str.charAt(end));
//				end++;
////				System.out.println("end 변경 : " + end);
//			}
//			int num = Integer.parseInt(str.substring(idx, end));
////			System.out.println("num : " + num);			
//			if(idx==0) minsum += num;
//			else {
//				if(str.charAt(idx-1) == '-') {
//					if(flag == true) flag = false;
//					else flag = true;
//					minsum -= num;
//				}
//				else if(str.charAt(idx-1) == '+') {
//					if(flag) minsum -= num;
//					else minsum += num;
//				}
//			}
//			end++;
//			idx = end; 
//
//		}
//		System.out.println(minsum);
	}

	private static void calculate(int idx, int end, String str, boolean flag) {
		while(idx<str.length()) {
//			System.out.println("idx : " + idx + " end : " + end);
			
			while(end < str.length()) {
				if(str.charAt(end) == '-' || str.charAt(end) == '+') break;
//				System.out.println("값 : " + str.charAt(end));
				end++;
//				System.out.println("end 변경 : " + end);
			}
			int num = Integer.parseInt(str.substring(idx, end));
//			System.out.println("num : " + num);			
			if(idx==0) minsum += num;
			else {
				if(str.charAt(idx-1) == '-') {
					if(!flag) flag = true;
					minsum -= num;
				}
				else if(str.charAt(idx-1) == '+') {
					if(flag) minsum -= num;
					else minsum += num;
				}
			}
			end++;
			idx = end; 

		}
		System.out.println(minsum);
	}
}
