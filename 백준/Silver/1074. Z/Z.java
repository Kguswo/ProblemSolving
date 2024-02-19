import java.util.*;

public class Main {
	static int N;
	static int r;
	static int c;
	static int num = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		Z((int) Math.pow(2, N), 0, 0);
		System.out.println(num);
	}

	static void Z( int Size, int starti, int startj) {
		if (Size == 2) {
            // 2 1
			// 3 4
			if(starti<= r && r<starti+1 && startj<= c && c<startj+1) { // 2사분면
				return;
			}
			else if(startj+1<= c && starti<= r && r<starti+1) { // 1사분면
				num += 1;
			}
			else if(starti+1<= r && startj<= c && c<startj+1) { // 3사분면
				num += 2;
			}
			else{ // 4사분면
				num += 3;
			}			
		} else {	
			int newSize = Size / 2;
			// 2 1
			// 3 4
			if(starti<= r && r<starti+newSize && startj<= c && c<startj+newSize) { // 2사분면
				Z( newSize, starti, startj);
			}
			else if(startj+newSize<= c && starti<= r && r<starti+newSize) { // 1사분면
				Z( newSize, starti, startj+newSize);
				num += newSize*newSize;
			}
			else if(starti+newSize<= r && startj<= c && c<startj+newSize) { // 3사분면
				Z( newSize, starti+newSize, startj);
				num += 2*newSize*newSize;
			}
			else{ // 4사분면
				Z( newSize, starti+newSize, startj+newSize);
				num += 3*newSize*newSize;
			}			
		}
	}
}
