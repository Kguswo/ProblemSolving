import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static int count, dr[] = {-1, 0, 1, 0}, dc[] = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            list.add(str);
        }
        board = new char[list.size()][list.get(0).length()]; // 12x6배열
        visited = new boolean[12][6];
        count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).length(); j++) {
                board[i][j] = list.get(i).charAt(j);
            }
        }
//		showboard(list, board);

        while (true) {
            if (!play())
                break;
            arrange();
            visited = new boolean[12][6];
            count++;
//    		showboard(list, board);
        }
        System.out.println(count);
    }

    private static boolean play() { // 더이상 어떤 색깔도 4개이상 붙어있지 않으면 false, 아니면 true
        boolean isPuyo = false;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '.' && !visited[i][j]) {
                    List<int[]> puyopuyo = new ArrayList<>(); // 터뜨릴 애들 좌표 넣을곳
                    dfs(i, j, board[i][j], puyopuyo);
                    if (puyopuyo.size() >= 4) {
                    	isPuyo = true;
                        for (int[] arr : puyopuyo) {
                            board[arr[0]][arr[1]] = '.';
                        }
                    }
                }
            }
        }
        return isPuyo;
    }

    private static void dfs(int x, int y, char color, List<int[]> puyopuyo) {
        if (x < 0 || x >= 12 || y < 0 || y >= 6 || visited[x][y] || board[x][y] != color) return;
        
        visited[x][y] = true;
        puyopuyo.add(new int[]{x, y});
        for(int k=0; k<4; k++) {
        	dfs(x+dr[k], y+dc[k], color, puyopuyo);
        }
    }

    private static void arrange() { // 중력으로 내리는 작업
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if (board[i][j] == '.') { // 빈칸찾고
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] != '.') { // 그 위에 색깔있으면 쭉 내리고 그자린 .으로
                            board[i][j] = board[k][j]; 
                            board[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
    
	private static void showboard(List<String> list, char[][] board) {
		System.out.println("===게임 시작 전===");
		for (int i = 0; i < list.size(); i++) {
			System.out.print("  ");
			for (int j = 0; j < list.get(0).length(); j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");
	}
}
