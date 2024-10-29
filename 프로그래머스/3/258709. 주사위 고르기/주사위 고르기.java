import java.util.*;

class Solution {
    private int[][] dice;
    private int[] comb;
    private ArrayList<int[]> diceComb;
    private ArrayList<Integer> score;
    
    public int[] solution(int[][] dice) {
        int[] answer = {};
        int diceCnt = dice.length;
        int maxWinCnt = 0;

        this.dice = dice;
        this.diceComb = new ArrayList<>();
        this.score = new ArrayList<>();

        comb = new int[diceCnt / 2];
        
        //모든 점수 조합 구하기
        calComb(0, 0, diceCnt / 2);

        for (int i = 0; i < diceComb.size() / 2; i++) {
            int myIdx = i;
            int enemyIdx = diceComb.size() - i - 1;

            int[] myComb = diceComb.get(myIdx);
            int[] enemyComb = diceComb.get(enemyIdx);

		    //점수 조합 압축
            HashMap<Integer, Integer> myScoreCnt = calScoreCnt(myComb, 0, diceCnt / 2);
            HashMap<Integer, Integer> enemyScoreCnt = calScoreCnt(enemyComb, 0, diceCnt / 2);

            int winCnt = 0;
            int loseCnt = 0;
            for (int m : myScoreCnt.keySet()) {
                for (int o : enemyScoreCnt.keySet()) {
                    if (m > o) {
                        winCnt += (myScoreCnt.get(m) * enemyScoreCnt.get(o));
                    } else if (m < o) {
                        loseCnt += (myScoreCnt.get(m) * enemyScoreCnt.get(o));
                    }
                }
            }
            if (maxWinCnt < winCnt) {
                maxWinCnt = winCnt;
                answer = myComb;
            }
            if (maxWinCnt < loseCnt) {
                maxWinCnt = loseCnt;
                answer = enemyComb;
            }
        }
        
        // index 0 주사위 > 1번 주사위 변경 작업
        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
        }
        return answer;
    }
    
    private void calComb(int start, int curDepth, int maxDepth) {
        if (curDepth == maxDepth) {
            diceComb.add(arrayDeepCopy(comb));
            return;
        }
        for (int i = start; i < dice.length; i++) {
            comb[curDepth] = i;
            calComb(i + 1, curDepth + 1, maxDepth);
        }
    }

    private int[] arrayDeepCopy(int[] arr) {
        return Arrays.stream(arr).toArray();
    }

    private HashMap<Integer, Integer> calScoreCnt(int[] comb, int curDepth, int maxDepth) {
        if (curDepth == maxDepth) {
            HashMap<Integer, Integer> scoreCnt = new HashMap<>();
            for (int s : score) {
                if (!scoreCnt.containsKey(s)) {
                    scoreCnt.put(s, 1);
                } else {
                    scoreCnt.put(s, scoreCnt.get(s) + 1);
                }
            }
            score.clear();
            return scoreCnt;
        }
        int idx = comb[curDepth];
        if (score.size() == 0) {
            for (int i = 0; i < 6; i++) {
                score.add(dice[idx][i]);
            }
        } else {
            int size = score.size();
            for (int i = 0; i < size; i++) {
                int s = score.remove(0);
                for (int j = 0; j < 6; j++) {
                    score.add(dice[idx][j] + s);
                }
            }
        }
        return calScoreCnt(comb, curDepth + 1, maxDepth);
    }
}