import java.io.*;

public class Main {
    static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String rew = N%2==0?"Duck":"Goose";
		
		System.out.println(rew);
	}
}