import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static class Belt{
		boolean isRobotOn;
		int value;
		
		Belt(boolean inRobotOn, int value){
			this.isRobotOn = isRobotOn;
			this.value = value;
		}
	}
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] beforeIdx, nextIdx;
	static int N, K, L, startIdx, dropIdx, rotateCnt, zeroValueCnt;
	static Belt[] conveyorBelt;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		L = 2*N;
		beforeIdx = new int[L];
		nextIdx = new int[L];
		startIdx = 0;
		dropIdx = N-1;
		
		conveyorBelt = new Belt[L];
		st = new StringTokenizer(br.readLine());
		
		int i;
		for(i=0; i<L; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (value == 0) zeroValueCnt++;
			conveyorBelt[i] = new Belt(false, value);

		}
		makeCircle();
		
		while(zeroValueCnt<K) {
			
			rotate();
			drop();
			move();
			addRobot();
			
			rotateCnt++;
		}
		bw.write(String.valueOf(rotateCnt));
		bw.flush();
		bw.close();
		br.close();		
	}

	private static void rotate() {
		startIdx = (startIdx + (L-1))%L;
		dropIdx = (startIdx + N - 1)%L;
		drop();
	}
	
	private static void drop() {
		if(conveyorBelt[dropIdx].isRobotOn) conveyorBelt[dropIdx].isRobotOn = false;
	}
	
	private static void move() {
		dropIdx = (startIdx + N - 1)%L;
		int i;
		for(i=N-2; i>=0; i--) {
			int beforeMoveIdx = (startIdx + i) % L;
			int afterMoveIdx = (beforeMoveIdx + 1) % L;
	
			if(conveyorBelt[beforeMoveIdx].isRobotOn && !conveyorBelt[afterMoveIdx].isRobotOn) {
				if(conveyorBelt[afterMoveIdx].value > 0) {
					conveyorBelt[beforeMoveIdx].isRobotOn = false;
					conveyorBelt[afterMoveIdx].isRobotOn = true;
					conveyorBelt[afterMoveIdx].value -= 1;
					
					if(conveyorBelt[afterMoveIdx].value == 0) zeroValueCnt++;
					
					if(afterMoveIdx == dropIdx) conveyorBelt[afterMoveIdx].isRobotOn = false;
				}
			}
		} 
		
	}
	
	private static void addRobot() {
		if(!conveyorBelt[startIdx].isRobotOn && conveyorBelt[startIdx].value > 0) {
			conveyorBelt[startIdx].isRobotOn = true;
			conveyorBelt[startIdx].value -= 1;
			if(conveyorBelt[startIdx].value <= 0) zeroValueCnt ++;
		}
	}
	
	private static void makeCircle() {
		nextIdx[1] = 2;
		beforeIdx[1] = 2*N-1;
		nextIdx[2*N-1] = 1;
		beforeIdx[2*N-1] = 2*N-2;
		int i;
		for(i=0; i<2*N; i++) {
			nextIdx[i] = i+1;
			beforeIdx[i] = i-1;
		}
		
	}
}
