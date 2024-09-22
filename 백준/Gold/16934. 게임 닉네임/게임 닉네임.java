/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	static Trie root;

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		root = new Trie();
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			insertName(name);
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private void insertName(String name) throws IOException {
		Trie trie = root;
		StringBuilder sb = new StringBuilder();
		// 새로운 분기인지 판별 
		boolean flag = false;
		
		for (int i = 0; i < name.length(); i++) {
			int idx = name.charAt(i) - 'a';
			if(!flag) sb.append(name.charAt(i));
			
			// 새로 분기를 만들어야 하면 생성하고 별칭에 추가. 
			if (trie.children[idx] == null) {
				flag = true;
				trie.children[idx] = new Trie();
			}

			trie = trie.children[idx];
		}
		
		trie.isEnd = true;
			if(trie.count == 0)  trie.count++;
			else {
				String x = String.valueOf(++trie.count);
				sb.append(x);
			}
		bw.write(sb.toString() + "\n");
	}

}

class Trie {
	Trie[] children = new Trie[26];
	int count;
	boolean isEnd;

	Trie() {
		this.isEnd = false;
		for (int i = 0; i < 26; i++) {
			children[i] = null;
		}
		this.count = 0;
	}
}
