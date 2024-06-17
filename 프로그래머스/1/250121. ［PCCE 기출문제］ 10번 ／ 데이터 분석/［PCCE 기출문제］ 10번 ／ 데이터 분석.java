import java.util.*;

class Solution {
    class Data implements Comparable<Data> {
        int code;
        int date;
        int maximum;
        int remain;
        String sort_by;
        
        public Data() {}
        
        public Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
        
        public void setSort_by(String sort_by) { // 그때그때 정렬기준 바뀌니까
            this.sort_by = sort_by;
        }
        
        public int findExt(String ext) {
            if (ext.equals("code")) return code;
            else if (ext.equals("date")) return date;
            else if (ext.equals("maximum")) return maximum;
            else return remain;
        }
        
        @Override
        public int compareTo(Data data) {
            return this.findExt(this.sort_by) - data.findExt(data.sort_by);
        }
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            Data D = new Data(data[i][0], data[i][1], data[i][2], data[i][3]);
            D.setSort_by(sort_by); // 정렬기준 설정
            list.add(D);
        }
        Collections.sort(list);
        
        List<Data> answerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Data ansD = list.get(i);
            if (ansD.findExt(ext) < val_ext) {
                answerList.add(ansD);
            }
        }
        
        int[][] answer = new int[answerList.size()][4];
        for (int i = 0; i < answerList.size(); i++) {
            Data ansD = answerList.get(i);
            answer[i][0] = ansD.code;
            answer[i][1] = ansD.date;
            answer[i][2] = ansD.maximum;
            answer[i][3] = ansD.remain;
        }
        return answer;
    }
}
