
/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N;
	static Line[] lines;
    static Group[] groups;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		lines = new Line[N];
        groups = new Group[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			lines[i] = new Line(x1, y1, x2, y2);
            groups[i] = new Group(i);
		}
				
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(isLineCrossed(lines[i], lines[j])) union(i, j);
			}
		}
		
		int groutCnt = 0;
		int maxSize = 0;
		for(int i=0; i<N; i++) {
			if(groups[i].parent == i) {
				groutCnt++;
				maxSize = Math.max(maxSize, groups[i].size);
			}
		}
		
        bw.write(groutCnt + "\n" + maxSize);
		bw.flush();
		bw.close();
		br.close();
	}
	
	private int find(int start) {
		if(groups[start].parent != start) groups[start].parent = find(groups[start].parent);
		return groups[start].parent;
	}
	
	private void union(int start, int end) {
		int root1 = find(start);
		int root2 = find(end);
		
		if(root1 != root2) {
			if (groups[root1].size < groups[root2].size) { // 그룹2에 1을 포함시키기
                groups[root1].parent = root2;
                groups[root2].size += groups[root1].size;
            } else { // 그룹1에 2을 포함시키기
                groups[root2].parent = root1;
                groups[root1].size += groups[root2].size;
            }
		}
	}

	private static int ccw(Point p1, Point p2, Point p3) {
        long res = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.x * p3.y + p3.x * p2.y + p2.x * p1.y);
		if(res == 0) return 0;
		else if (res > 0) return 1;
		else return -1;
	}
	
	private static boolean isLineCrossed(Line l1, Line l2) {
		Point p1 = l1.p1;
		Point p2 = l1.p2;
		
		Point p3 = l2.p1;
		Point p4 = l2.p2;
		
		int ccw1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
		int ccw2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
		
		// 1. 한 줄 일때 
		// 1 3 2 4 처럼 겹칠텐데 1<4 고 2>3 임을 수식으로 작성
		if (ccw1 == 0 && ccw2 == 0) {
            if (Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) &&
            	Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x) && 
            	Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) && 
            	Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y)) {
                return true;
            } 
            else return false;
        } 
		// 2. 크로스가 있을 가능성이 있을 때
		// 2-1. 둘 다 ccw 곱이 음수면 완전 크로스 : true
		else if (ccw1 <= 0 && ccw2 <= 0) return true;
        
		// 그 외는 한쪽 음수 한쪽 양수이므로 ㅡ ㅣ 같은 모양임 : false
		else return false;
        
	}

	class Point implements Comparable<Point>{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if(this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
	}
	
	class Line{

	    Point p1, p2;

	    public Line(int x1, int y1, int x2, int y2) {
	        Point point1 = new Point(x1, y1);
	        Point point2 = new Point(x2, y2);

	        p1 = point1.compareTo(point2) <= 0 ? point1 : point2;
	        p2 = point1.compareTo(point2) <= 0 ? point2 : point1;
	    }

	}
	
	class Group{
		int parent;
		int size;
		public Group(int parent) {
			this.parent = parent;
			this.size = 1;
		}
	}

}
