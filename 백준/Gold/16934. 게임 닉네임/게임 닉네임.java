import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringBuilder result;
    static Trie root;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();
        root = new Trie();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            insertName(name);
        }

        System.out.print(result.toString());
    }

    private static void insertName(String name) {
        Trie trie = root;
        StringBuilder sb = new StringBuilder();
        boolean isNewBranch = false;

        for (int i = 0; i < name.length(); i++) {
            int idx = name.charAt(i) - 'a';
            if (!isNewBranch) sb.append(name.charAt(i));

            if (trie.children == null) {
                trie.children = new Trie[26];
            }

            if (trie.children[idx] == null) {
                isNewBranch = true;
                trie.children[idx] = new Trie();
            }

            trie = trie.children[idx];
        }

        if (trie.isEnd) {
            sb.append(++trie.count);
        } else {
            trie.isEnd = true;
            trie.count = 1;
        }

        result.append(sb.toString()).append("\n");
    }
}

class Trie {
    Trie[] children;
    int count;
    boolean isEnd;

    Trie() {
        this.children = null;
        this.count = 0;
        this.isEnd = false;
    }
}
