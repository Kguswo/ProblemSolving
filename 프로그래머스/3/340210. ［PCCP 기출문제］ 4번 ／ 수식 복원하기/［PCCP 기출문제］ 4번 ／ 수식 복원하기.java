import java.util.*;

class Solution {
    static List<String> ansList = new ArrayList<>();
    static List<Integer> ableRadix = new ArrayList<>();
    public String[] solution(String[] expressions) {        
        int maxN = 0;
        for(String e : expressions){
            maxN = Math.max(maxN, getMaxFromExpression(e));
        }
        int minRadix = maxN + 1; // 최소 가능한 진법
        
        for(int i=minRadix; i<=9; i++){
            boolean flag = true;
            for(String e : expressions){
                if(!e.contains("X")){
                    if(!isValid(e, i)){
                        flag = false;
                        break;  
                    }
                }
            }
            
            // i진법이 유효할때
            if(flag) ableRadix.add(i);
        }
        
        for(String e : expressions){
            if(e.contains("X")){
                String res = makeAns(e);
                ansList.add(res);
            }
        }
        
        return ansList.toArray(new String[0]);
    }
    
    // 전체식에서 최대숫자찾기
    private int getMaxFromExpression(String e){
        int m = 0;
        String[] arr = e.split(" ");
        
        m = Math.max(m, getMaxFromNumber(arr[0]));
        m = Math.max(m, getMaxFromNumber(arr[2]));
        if(!arr[4].equals("X")){
            m = Math.max(m, getMaxFromNumber(arr[4]));
        }
        
        return m;
    }
    
    // 각 숫자 String에서 최대 숫자(0~9) 찾기
    private int getMaxFromNumber(String str){
        if(str.equals("X")) return 0;
        
        int max = 0;
        for(char c : str.toCharArray()){
            int digit = c - '0';
            max = Math.max(max, digit);
        }
        return max;
    }
    
    private boolean isValid(String e, int i){
        String[] arr = e.split(" ");
        
        // 숫자가 i진법에서 유효한지 체크 ex) 2진법에선 0,1 만 가능
        if(!canParse(arr[0], i) || !canParse(arr[2], i) || !canParse(arr[4], i)) return false;
        
        // a (+/-) b = c
        int a = getNum(arr[0], i);
        int b = getNum(arr[2], i);
        int c = getNum(arr[4], i);
        
        int cal = 0;
        if(arr[1].equals("+")) cal = a + b;
        else cal = a - b;
        
        return c == cal;
    }
    
    private String makeAns(String e){ // X 채우기
        String[] arr = e.split(" ");
        
        Set<String> cals = new HashSet<>();
        
        for(int i : ableRadix){
            // i진법에서 숫자들이 유효한지 체크
            if(!canParse(arr[0], i) || !canParse(arr[2], i)) continue;
            
            int a = getNum(arr[0], i);
            int b = getNum(arr[2], i);
            
            int cal = 0;
            if(arr[1].equals("+")) cal = a + b;
            else cal = a - b;
            
            cals.add(Integer.toString(cal, i));
        }
        
        if(cals.size() == 1) return e.replace("X", cals.stream().findFirst().orElse(null));
        else return e.replace("X", "?");
    }
    
    private int getNum(String str, int radix){
        if(str.equals("X")) return 0;
        return Integer.parseInt(str, radix);
    }
    
    private boolean canParse(String str, int i){
        if(str.equals("X")) return true;
        
        for(char c : str.toCharArray()){
            int digit = c - '0';
            if(digit >= i) return false;
        }
        return true;
    }
}