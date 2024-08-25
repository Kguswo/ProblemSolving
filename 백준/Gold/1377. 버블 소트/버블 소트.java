import java.io.*;
import java.util.*;

public class Main {
	
	public static class Data implements Comparable<Data>{
		int value;
		int idx;
		
		public Data(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}

		@Override
		public int compareTo(Data o) {
			return this.value - o.value;
		}
	}
	
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Data[] data = new Data[N];
		
		for(int i=0; i<N; i++) {
			data[i]	 = new Data(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(data);
		
		int max = 0;
		for(int i=0; i<N; i++) {
			if(max < data[i].idx-i) max = data[i].idx -i;
		}
		System.out.println(max+1);
	}
}
