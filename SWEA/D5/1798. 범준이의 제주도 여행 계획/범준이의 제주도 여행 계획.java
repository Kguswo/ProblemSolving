/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Solution {
	
	class Node{
		char c;
		int t;
		int s;
		public Node(char c, int time, int satisfication) {
			this.c = c;
			this.t = time;
			this.s = satisfication;
		}
	}
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, map[][];
	static int v, time, satisfication, maxS, airport;
	static Node[] place;
	boolean[] visited;
	static List<Integer> hotels;
	static List<Integer> bestPlan, myPlan;
	
	public static void main(String[] args) throws Exception {
		new Solution().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			place = new Node[N];
			for(int i=0; i<N-1; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=i+1; j<N; j++) {
					v = Integer.parseInt(st.nextToken());
					map[i][j] = v;
					map[j][i] = map[i][j];
				}
			}
			
			airport=0;
			hotels = new ArrayList<Integer>();
			char p;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				p = st.nextToken().charAt(0);
				if(p == 'A') {
					place[i] = new Node('A', -1, -1);
					airport = i;
				}
				else if(p == 'H') {
					place[i] = new Node('H', -1, -1);
					hotels.add(i);
				}
				else {
					time = Integer.parseInt(st.nextToken());
					satisfication = Integer.parseInt(st.nextToken());
					place[i] = new Node('P', time, satisfication);
				}
			}
			
			visited = new boolean[N];
			maxS = 0;
			
			bestPlan = new ArrayList<>();
			myPlan = new ArrayList<>();
			
			dfs(airport, 1, 0, 0); // 시작위치, 일차, 누적시간, 누적만족도
			if(maxS == 0) sb.append(0);
			else {			
				sb.append(maxS).append(" ");
				for(int i : bestPlan) {
					sb.append(i + 1).append(" ");
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private void dfs(int start, int day, int time, int sat) {
		if(day > M) return;
		if(time > 540) return;
		
		// M일차 공항 도착, M=1일때 첫 시작은 그냥 넘어가기
		if(day == M && start == airport && !(M == 1 && time == 0)) {
			if(sat > maxS) {
				maxS = sat;
				bestPlan = new ArrayList<Integer>(myPlan);
			}
			return;
		}
		
		// 1일차 ~ M-1일차
		for(int next = 0; next < N; next++) {
			if(!visited[next] || place[next].c == 'H') {
				// 마지막날 아니면 공항은 가지말고
				if(place[next].c == 'A') {
					if(M == 1) {
	                    // 하루여행에서는 공항가능
	                    if(sat > 0 && sat > maxS) {
	                        maxS = sat;
	                        bestPlan = new ArrayList<Integer>(myPlan);
	                    }
	                    continue;
	                }
	                if(day != M) continue;  // 마지막 날이 아니면 공항 방문 불가
	            }
				
				int nextTime = time + map[start][next];
				// 놀러간거면 노는 시간도 더하기
				if(place[next].c == 'P') nextTime += place[next].t;
				
				// 9시간규칙 먼저 검사
				if(nextTime > 9 * 60) continue;
				
				if(day < M) {
					if(!canGoHotel(day, next, nextTime)) continue;
				}
				else { // 마지막날은 호텔이 아니라 공항으로체크
					if(!canGoAirport(next, nextTime)) continue;
				}
				
				if(place[next].c == 'P') {
					visited[next] = true;
					myPlan.add(next);
					dfs(next, day, nextTime, sat + place[next].s);
					
					myPlan.remove(myPlan.size()-1);
					visited[next] = false;
				}
				else if (place[next].c == 'H' && day < M) { // 호텔돌아옴 -> 다음날 시작부분
					myPlan.add(next);
					dfs(next, day+1, 0, sat);
					myPlan.remove(myPlan.size()-1);
				}
				else if(next == airport && day == M){
					myPlan.add(next);
					dfs(next, day, nextTime, sat);
					myPlan.remove(myPlan.size()-1);
				}
			}
		}
	}
	
	private boolean canGoHotel(int day, int next, int nextTime) {		
		for(int h : hotels) {
			int toHotelTime = map[next][h];
			if(nextTime + toHotelTime <= 540) return true;
		}
		return false;
	}
	
	private boolean canGoAirport(int start, int time) {
		int toAirportTime = time + map[start][airport];
		return toAirportTime <= 540; 
	}
}