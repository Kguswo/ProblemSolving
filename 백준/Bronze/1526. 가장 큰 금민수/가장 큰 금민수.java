import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		while(true) {
			boolean flag = true;
            
			for(int i = 0; i < N.length(); i++) {
				if(N.charAt(i) != '4' && N.charAt(i) != '7') {
					flag = false;
					break;
				}
			}
			if(flag == true) break;
			else N = String.valueOf(Integer.parseInt(N) - 1);
		}
		System.out.println(N);
	}

}