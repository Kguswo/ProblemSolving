class Solution {
    static int ePlusCnt, eSalesMoney;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        ePlusCnt=0; // 플러스사용자 수
        eSalesMoney=0; // 이모티콘 판매액
        
        int[] saleP = new int[emoticons.length]; // 이모티콘 할인율 %
        dfs(0, emoticons.length, saleP, users, emoticons);
        answer[0] = ePlusCnt;
        answer[1] = eSalesMoney;
        return answer;
    }
    private void dfs(int depth, int target, int[] saleP, int[][] users, int[] emoticons){
        if(depth == target){
            int[] res = solve(saleP, users, emoticons);
            if(ePlusCnt < res[0]){
                ePlusCnt=res[0];
                eSalesMoney=res[1];
            }
            else if(ePlusCnt == res[0]){
                if(eSalesMoney < res[1]) eSalesMoney=res[1];
            }
            return;
        }   
        
        for(int i=10; i<=40; i+=10){
            saleP[depth] = i;
            dfs(depth+1, target, saleP, users, emoticons);
        }
    }
    private int[] solve(int[] saleP, int[][] users, int[] emoticons){
        int totalPeople = 0; // 가입수
        int totalMoney = 0; // 매출
        
        // 각 사람마다 얼마 쓰는지 체크
        for(int[] u : users){
            int currSaleP = u[0];
            int currMoney = u[1];
            
            int sum=0;
            for(int i=0; i<emoticons.length; i++){
                if(saleP[i] >= currSaleP){ // 이 이모티콘은 삼
                    int discountPrice = (emoticons[i] * (100 - saleP[i])) / 100;
                    sum += discountPrice;
                }
            }
            if(sum >= currMoney) totalPeople++;
            else totalMoney += sum;
        }
        
        return new int[] {totalPeople, totalMoney};
    }
}