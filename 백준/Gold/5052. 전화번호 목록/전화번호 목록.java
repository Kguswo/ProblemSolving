/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	class Trie{
		Trie[] children = new Trie[10];
		boolean isEnd;
		Trie(){
			for(int i=0; i<10; i++) {
				children[i] = null;
			}
			isEnd = false;
		}
	}
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Trie root;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			root = new Trie();
			int n = Integer.parseInt(br.readLine());
			
			flag = true;
			for(int i=0; i<n; i++) {
				String num = br.readLine();
				insertNum(num);
			}
			
			sb.append(flag ? "YES" : "NO").append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	private void insertNum(String num) {
		Trie trie = root;
		
		for(int i=0; i<num.length(); i++) {
			int number = num.charAt(i) - '0';
			
			if(trie.isEnd) {
				flag = false;
				return;
			}
			
			if(trie.children[number]==null) {
				trie.children[number] = new Trie();
			}
			
			trie = trie.children[number];
		}
		
		if(trie.isEnd) {
			flag = false;
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(trie.children[i] != null) {
				flag = false;
				return;
			}
		}
		trie.isEnd = true;
	}
}