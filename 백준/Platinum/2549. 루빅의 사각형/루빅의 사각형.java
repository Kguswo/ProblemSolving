/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class State{
        int[][] board;
        List<Move> moves;

        public State(int[][] board, List<Move> moves){
            this.board = new int[4][4];
            for(int i = 0; i < 4; ++i){
                this.board[i] = Arrays.copyOf(board[i], 4);
            }
            this.moves = new ArrayList<>(moves);
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof State)) return false;
            State other = (State)o;
            for(int i = 0; i < 4; ++i){
                if(!Arrays.equals(this.board[i], other.board[i])) return false;
            }
            return true;
        }

        @Override
        public int hashCode(){
            return Arrays.deepHashCode(board);
        }
    }

    class Move{
        int type; // 1 : 오른쪽으로밀기, 2 : 아래로밀기
        int idx; // 0-based
        int cnt; // 이동한 칸 수
        public Move(int type, int idx, int cnt){
            this.type = type;
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static final int N = 4;
    static int[][] initialBoard, targetBoard;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2549_루빅의사각형/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 시작보드
        initialBoard = new int[N][N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j){
                initialBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 완성할 보드
        targetBoard = new int[N][N];
        int num = 1;
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                targetBoard[i][j] = num++;
            }
        }

        // 양방향탐색
        List<Move> sol = search(initialBoard);

        System.out.println(sol.size());
        for(Move m : sol){
            System.out.println(m.type + " " + (1+m.idx) + " " + m.cnt);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private List<Move> search(int[][] initialBoard){
        Queue<State> forwardQueue = new LinkedList<>();
        Queue<State> backwardQueue = new LinkedList<>();
        Map<String, State> forwardVisited = new HashMap<>();
        Map<String, State> backwardVisited = new HashMap<>();

        State initialState = new State(initialBoard, new ArrayList<>());
        State targetState = new State(targetBoard, new ArrayList<>());

        forwardQueue.offer(initialState);
        backwardQueue.offer(targetState);
        forwardVisited.put(boardToString(initialBoard), initialState);
        backwardVisited.put(boardToString(targetBoard), targetState);

        while(!forwardQueue.isEmpty() && !backwardQueue.isEmpty()){
            // 정방향
            State meetingState = expandSearch(forwardQueue, forwardVisited, backwardVisited, true);

            if(meetingState != null) return remakePath(meetingState, forwardVisited, backwardVisited);

            // 역방향
            meetingState = expandSearch(backwardQueue, backwardVisited, forwardVisited, false);

            if(meetingState != null) return remakePath(meetingState, forwardVisited, backwardVisited);

        }
        return new ArrayList<>(); // 못 찾았을때
    }

    private State expandSearch(Queue<State> queue, Map<String, State> visited, Map<String, State> otherVisited, boolean ifForward){
        State curr = queue.poll();

        //모든방법 시도
        for(int type=1; type<=2; type++){
            for(int idx=0; idx<4; idx++){
                for(int cnt=1; cnt<=3; cnt++){
                    int[][] newBoard = moveBoard(curr.board, type, idx, cnt);
                    List<Move> newMoves = new ArrayList<>(curr.moves);
                    newMoves.add(new Move(type, idx, cnt));

                    State newState = new State(newBoard, newMoves);
                    String boardString = boardToString(newBoard);

                    if(!visited.containsKey(boardString)){
                        visited.put(boardString, newState);
                        queue.offer(newState);

                        // 다른방향 탐색이랑 만나는지 체크
                        if(otherVisited.containsKey(boardString)){
                            return newState;
                        }
                    }
                }
            }
        }
        return null;
    }

    private int[][] moveBoard(int[][] board, int type, int idx, int cnt){
        int[][] newBoard = new int[N][N];
        for(int i=0; i<N; ++i){
            newBoard[i] = Arrays.copyOf(board[i], N);
        }

        // 가로오른쪽으로
        if(type == 1){
            int[] tmp = new int[N];
            for(int c=0; c<N; c++){
                tmp[(c+cnt) % 4] = board[idx][c];
            }
            newBoard[idx] = tmp;
        }
        // 세로아래로
        else{
            int[] tmp = new int[N];
            for(int r=0; r<N; r++){
                tmp[(r+cnt) % 4] = board[r][idx];
            }
            for(int r=0; r<N; r++){
                newBoard[r][idx] = tmp[r];
            }
        }
        return newBoard;
    }

    String boardToString(int[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                sb.append(board[i][j]).append(" ");
            }
        }
        return sb.toString();
    }

    List<Move> remakePath(State meetingState, Map<String, State> forwardVisited, Map<String, State> backwardVisited){
        String boardString = boardToString(meetingState.board);
        List<Move> forwardMoves = forwardVisited.get(boardString).moves;
        List<Move> backwardMoves = backwardVisited.get(boardString).moves;

        List<Move> totalPath = new ArrayList<>(forwardMoves);
        // 역방향을 반대로 붙이기
        for(int i=backwardMoves.size()-1; i>=0; i--){
            Move move = backwardMoves.get(i);
            // 반대방향 이동은 4-cnt칸 이동임
            totalPath.add(new Move(move.type, move.idx, 4 - move.cnt));
        }
        return totalPath;
    }
}