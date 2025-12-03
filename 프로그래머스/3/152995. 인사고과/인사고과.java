import java.util.*;

class Person implements Comparable<Person>{
    int a, b, sum;
    
    public Person(int a, int b) {
        this.a = a;
        this.b = b;
        this.sum = Integer.sum(a, b);
    }
    
    @Override
    public int compareTo(Person o) {
        if(this.a == o.a) return Integer.compare(this.b, o.b); // b 오름차순
        return Integer.compare(o.a, this.a); // a 내림차순
    }
    
    @Override
    public String toString(){
        return "[" + this.a + ", " + this.b + "]";
    }
}

class Solution {
    public int solution(int[][] scores) {
        int targetA = scores[0][0];
        int targetB = scores[0][1];
        int targetSum = scores[0][0] + scores[0][1];
        
        List<Person> people = new ArrayList<>();
        for(int[] s : scores) {
            people.add(new Person(s[0], s[1]));
        }
        
        Collections.sort(people);
        
        // System.out.println(people);
        
        int rank = 1;
        int maxA = -1, maxB = -1;
        
        for(Person p : people) {
            if(p.a < maxA && p.b < maxB) {
                if(p.a == targetA && p.b == targetB) return -1;
            }
            else {
                maxA = p.a;
                maxB = Math.max(maxB, p.b);
                if(p.sum > targetSum) rank++;
            }
        }
        
        return rank;
    }
}