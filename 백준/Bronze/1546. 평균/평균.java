import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double sum = 0;
		double[] arr = new double[n];
		for(int i=0; i<n; i++) {
			double num = sc.nextDouble();
			arr[i] = num;
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			arr[i] = (arr[i]/arr[arr.length-1])*100;
		}
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		System.out.println(sum/n);
		
    }
}