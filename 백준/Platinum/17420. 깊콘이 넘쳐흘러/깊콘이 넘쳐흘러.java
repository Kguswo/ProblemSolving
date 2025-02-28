/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Gifticon implements Comparable<Gifticon>{
        int idx, leftDate, usedDate;
        public Gifticon(int idx, int leftDate, int usedDate){
            this.idx = idx;
            this.leftDate = leftDate;
            this.usedDate = usedDate;
        }

        @Override
        public int compareTo(Gifticon o) {
            if(this.usedDate == o.usedDate) return this.leftDate - o.leftDate;
            return this.usedDate - o.usedDate;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static Gifticon[] gifticons;
    static long res;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_17420_깊콘이넘쳐흘러/input.txt")));

        N = Integer.parseInt(br.readLine());
        gifticons = new Gifticon[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gifticons[i] = new Gifticon(i, Integer.parseInt(st.nextToken()), 0);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gifticons[i].usedDate = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(gifticons);

        int previousMaxLeftDate = gifticons[0].usedDate; // 이전에 쓴 기프티콘들 중 최대 사용일자
        int maxLeftDate = 0; // 이전까지 처리된 기프티콘 중 최대 남은 기한
        for(int i = 0; i < N; i++){
            Gifticon currGifticon = gifticons[i];

            /*
                (i번째 기프티콘 남은기한)이 (i-1까지 처리한 남은기한들)보다 커야함. 그래야 이번에 처리순서가 되니까.
                (i번째 기프티콘 남은기한)이 (i-1까지 기프티콘들의 사용일자들)보다 커야함. 그래야 이전에 안써지고 지금써지니까.
                이때 연장해주는것임. 몇번 연장할지는 아래 addCnt로 계산, 지금기프티콘 남은기한은 (연장횟수 * 30)만큼 연장
             */

            // 남은 기한 < 사용일자 일땐 일단 먼저 연장해야함
            if (currGifticon.leftDate < currGifticon.usedDate) {
                /*
                addCnt = 기프티콘 추가횟수
                30일 -> 1번
                31일 ~ 60일 -> 2번
                61일 ~ 90일 -> 3번
                 */
                int addCnt = (currGifticon.usedDate - currGifticon.leftDate + 29) / 30;
                currGifticon.leftDate += addCnt * 30;
                res += addCnt;
            }

            //  현재 기한이 이전 최대값(previousMaxLeftDate)보다 작으면 추가 연장 (이전에 연장해서 써서 지금도 연장해야함을 의미한다)
            if(currGifticon.leftDate < previousMaxLeftDate ){
                int addCnt = (previousMaxLeftDate - currGifticon.leftDate + 29) / 30;
                currGifticon.leftDate += addCnt * 30; // 30일연장
                res += addCnt; // 연장횟수 추가
            }

            // 남은일자
            maxLeftDate = Math.max(maxLeftDate, currGifticon.leftDate);

            // 다음 기프티콘도 이번 기프티콘과 써야할 일자가 같다면 previousMaxUsedDate 업데이트할필요없음 쭉 같은날 사용
            // 그 외 다른 날짜면 업데이트
            if(i+1 < N && gifticons[i].usedDate != gifticons[i+1].usedDate){
                previousMaxLeftDate = maxLeftDate;
            }

        }

        System.out.println(res);
    }
}