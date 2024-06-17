import java.util.*;

class Solution {
    static int R, C;
    static int[][] scoreArr;
    static String[][] stringArr = {{"RT","TR"}, {"CF","FC"}, {"JM","MJ"}, {"AN","NA"}};
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        R = 0; C = 0;
        scoreArr = new int[4][2];
        for(int i=0; i<survey.length; i++){
            findRC(survey[i]);
            addScore(R, C, choices[i]);
        }
        if(scoreArr[0][0] >= scoreArr[0][1]) answer += "R";
        else answer += "T";
        if(scoreArr[1][0] >= scoreArr[1][1]) answer += "C";
        else answer += "F";
        if(scoreArr[2][0] >= scoreArr[2][1]) answer += "J";
        else answer += "M";
        if(scoreArr[3][0] >= scoreArr[3][1]) answer += "A";
        else answer += "N";

        return answer;
    }
    
    private static void findRC(String str){
        for(int i=0; i<4; i++){
            for(int j=0; j<2; j++){
                if(stringArr[i][j].equals(str)){
                    R=i; C=j;
                }
            }
        }
    }
    
    private static void addScore(int R, int C, int choice){
        if(C == 0){
            if(choice < 4){
                scoreArr[R][C] += 4-choice;
                return;
            }
            else if(choice > 4){
                scoreArr[R][C+1] += choice-4;
                return;
            }
            else return;
        }
        else{
            if(choice < 4){
                scoreArr[R][C] += 4-choice;
                return;
            }
            else if(choice > 4){
                scoreArr[R][C-1] += choice-4;
                return;
            }
            else return; 
        }
    }
}