import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스의 수
        
        while (t-- > 0) {
            int xc = sc.nextInt();
            int yc = sc.nextInt();
            int k = sc.nextInt();
            
            long sumX = 0, sumY = 0;
            
            for (int i = 0; i < k - 1; i++) {
                int x = i - 500000; // 충분히 작은 값에서 시작
                int y = i - 500000;
                System.out.println(x + " " + y);
                sumX += x;
                sumY += y;
            }
            
            // 마지막 점 계산
            long lastX = (long)k * xc - sumX;
            long lastY = (long)k * yc - sumY;
            
            // 마지막 점의 좌표가 범위를 벗어나지 않도록 보정
            lastX = Math.max(-1000000000, Math.min(1000000000, lastX));
            lastY = Math.max(-1000000000, Math.min(1000000000, lastY));
            
            System.out.println(lastX + " " + lastY);
        }
    }
}