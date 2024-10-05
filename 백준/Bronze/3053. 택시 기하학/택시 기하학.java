/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		double d = Double.parseDouble(br.readLine());
	
		System.out.println(d * d * Math.PI);	// 유클리드 원
		System.out.println(2 * d * d);		// 택시기하학 원
		
	}
}