import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int G, P, arr[], ans; 
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		G = Integer.valueOf(br.readLine());
		P = Integer.valueOf(br.readLine());
		arr = new int[G+1];
		/*
		 * 비행기 개수만큼 반복하고 flag로 불가능한 포인트 도달할때까지 반복하면서
		 * g 입력받고 g이하가 꽉 찼는지 확인하는 것이므로 
		 * arr[g]가 0이 아니고 g값이 0이 아닐때까지
		 * 이미 차있는 비행기수 빼고 그 위치 비행기수++을 반복
		 * 
		 * 만약 arr[어딘가] 가 0인곳을 먼저 발견했고 g가 0이 아니면 비행기 넣을 수 있으므로 그 arr[어딘가] = 1로 만들고 ans++
		 * 그게 아니면 arr은 다 찼는데 g만 0이므로 
		*/
		while(P>0 && !flag) {
			P--;
			int g = Integer.valueOf(br.readLine());
			while(arr[g] > 0 && g>0) {
				int tmp = arr[g];
				arr[g]++;
				g -= tmp;
			}
			
			if(g>0) {
				arr[g] = 1;;
				ans++;
			}
			else flag = true;
		}
		System.out.println(ans);
		bw.close();
		br.close();
	}
}
