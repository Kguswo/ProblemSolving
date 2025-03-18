import java.util.*;

class Solution {
    static int[] p;
    static String[] values;
    static Map<Integer, List<Integer>> cellList = new HashMap<>();
    public String[] solution(String[] commands) {
        p = new int[2500];
        values = new String[2500];
        List<String> res = new ArrayList<>();
        for(int i=0; i<2500; i++){
            p[i] = i;
        }
        
        for(int i=0; i<2500; i++){
            List<Integer> initialList = new ArrayList<>();
            initialList.add(i);
            cellList.put(i, initialList);
        }
        
        for(String command : commands){
            String[] line = command.split(" ");
            String type = line[0];
            if(type.equals("UPDATE")){
                // "UPDATE r c value"
                if(line.length == 4){
                    int r = Integer.parseInt(line[1]) - 1;
                    int c = Integer.parseInt(line[2]) - 1;
                    String value = line[3];
                    
                    int idx = r*50 + c;
                    values[find(idx)] = value;
                }
                
                // "UPDATE value1 value2"
                else{
                    String value1 = line[1];
                    String value2 = line[2];
                    
                    for(int i=0; i<2500; i++){
                        if(i==find(i) && value1.equals(values[i])){
                            values[i] = value2;
                        }
                    }
                }
            }
            else if(type.equals("MERGE")){
                int r1 = Integer.parseInt(line[1]) - 1;
                int c1 = Integer.parseInt(line[2]) - 1;
                int r2 = Integer.parseInt(line[3]) - 1;
                int c2 = Integer.parseInt(line[4]) - 1;
                
                int idx1 = r1 * 50 + c1;
                int idx2 = r2 * 50 + c2;
                int p1 = find(idx1);
                int p2 = find(idx2);
                
                // 이미 같음
                if(p1 == p2) continue;
                
                // 각 셀 빈거 체크
                boolean is_p1_empty = false;
                if(values[p1] == null) is_p1_empty=true;
                boolean is_p2_empty = false;
                if(values[p2] == null) is_p2_empty=true;
                
                // 둘 다 비었으면 바로합치기
                if(is_p1_empty && is_p2_empty) union(idx1, idx2);
                
                // p2로 병합 (p1 비었고 p2값있음)
                else if(is_p1_empty && !is_p2_empty) union(idx2, idx1);
                    
                // 둘다 값있으면 r1 c1쪽
                else union(idx1, idx2);
            }
            else if(type.equals("UNMERGE")){
                int r = Integer.parseInt(line[1]) - 1;
                int c = Integer.parseInt(line[2]) - 1;
                int idx = r * 50 + c;
                String value = values[find(idx)];
                
                // null로 초기화하고 r, c만 값할당
                List<Integer> cells = new ArrayList<>(cellList.get(find(idx)));
                for(int cellIdx : cells){
                    p[cellIdx] = cellIdx;
                    values[cellIdx] = null;
                    
                    List<Integer> initialCell = new ArrayList<>();
                    initialCell.add(cellIdx);
                    cellList.put(cellIdx, initialCell);
                }
                
                values[idx] = value;                
            }
            else if(type.equals("PRINT")){
                int r = Integer.parseInt(line[1]) - 1;
                int c = Integer.parseInt(line[2]) - 1;
                int idx = r * 50 + c;
                String value = values[find(idx)];
                
                res.add(value == null ? "EMPTY" : value);
            }
        }
        String[] ans = new String[res.size()];
        for(int a=0; a<ans.length; a++){
            ans[a] = res.get(a);
        }
        return ans;
    }
    
    static int find(int x){
        if(p[x] != x) return p[x] = find(p[x]);
        return p[x];
    }
    
    static void union(int x, int y){ // x를 부모로 합치기
        int px = find(x);
        int py = find(y);
        
        if(px == py) return;
        
        p[py] = px;
        values[py] = null;
        
        // 셀합치기
        List<Integer> mergedCells = new ArrayList<>(cellList.get(px));
        for(int i : cellList.get(py)){
            mergedCells.add(i);
        }
        cellList.put(px, mergedCells);
        cellList.put(py, mergedCells);
    }
}