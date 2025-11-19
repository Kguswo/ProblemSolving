import java.util.*;

class Number implements Comparable<Number> {
    String num;
    
    public Number(int n) {
        this.num = String.valueOf(n);
    }
    
    public String getNum() {
        return this.num;
    }
    
    @Override
    public int compareTo(Number o) {
        String o1 = this.num + o.num;
        String o2 = o.num + this.num;
        return o2.compareTo(o1);
    }
}

class Solution {
    public String solution(int[] arr) {
        List<Number> numbers = new ArrayList<>();
        for(int n : arr) {
            numbers.add(new Number(n));
        }
        
        Collections.sort(numbers);
        
        StringBuilder sb = new StringBuilder();
        for(Number number : numbers) {
            sb.append(number.getNum());
        }

        if(sb.toString().charAt(0) == '0') return "0";
        else return sb.toString();
    }
}