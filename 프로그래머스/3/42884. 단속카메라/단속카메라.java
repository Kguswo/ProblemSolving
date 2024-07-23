import java.io.*;
import java.util.*;

class Solution {
    class Car implements Comparable<Car>{
        int in;
        int out;
        
        Car(int in, int out){
            this.in = in;
            this.out = out;
        }
        
        @Override
        public int compareTo(Car o){
            return this.out - o.out;
        }
    }
    
    public int solution(int[][] routes) {
        int ans = 0;
        int camera = Integer.MIN_VALUE;
        ArrayList<Car> car = new ArrayList<>();

        for (int i = 0; i < routes.length; i++) {
            car.add(new Car(routes[i][0], routes[i][1]));
        }
        
        Collections.sort(car);
        for(Car c : car){
            if(camera < c.in){
                ans++;
                camera = c.out;
            }
        }
        
        return ans;
    }
}