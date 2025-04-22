import java.util.*;

class Solution {
    class Trie{
        Trie[] children;
        Map<Integer, Integer> countMap; // 각 길이별 가능한 개수
        public Trie(){
            children = new Trie[26];
            countMap = new HashMap<>();
        }
        
        public void insert(String s, int length){
            Trie node = this;
            node.countMap.put(length, node.countMap.getOrDefault(length, 0) + 1);
            
            for(char c : s.toCharArray()){
                if(node.children[c-'a'] == null) node.children[c-'a'] = new Trie();
                
                node = node.children[c-'a'];
                node.countMap.put(length, node.countMap.getOrDefault(length, 0) + 1);
            }
        }
        
        public int query(String s, int length){
            Trie node = this;
            
            // ? 전까지 일치하는 노드로
            for(char c : s.toCharArray()){
                if(c == '?') break;
                
                if(node.children[c-'a'] == null) return 0;
                node = node.children[c-'a'];
            }
            
            return node.countMap.getOrDefault(length, 0);
        }
    }
    public int[] solution(String[] words, String[] queries) {
        int[] res = new int[queries.length];
        Trie normalTrie = new Trie();
        Trie reverseTrie = new Trie();
        Map<Integer, Integer> lenCount = new HashMap<>();
        
        for(String w : words){
            lenCount.put(w.length(), lenCount.getOrDefault(w.length(), 0) + 1);
            normalTrie.insert(w, w.length());
            StringBuilder sb = new StringBuilder(w);
            sb.reverse();
            reverseTrie.insert(sb.toString(), sb.toString().length());
        }
        
        for(int i=0; i<queries.length; i++){
            String q = queries[i];
            
            // "????????" 인 경우
            if(q.charAt(0) == '?' && q.charAt(q.length() - 1) == '?'){
                res[i] = lenCount.getOrDefault(q.length(), 0);
                continue;
            }
            
            // xxxx????? 인 경우
            if(q.charAt(q.length() - 1) == '?'){
                res[i] = normalTrie.query(q, q.length());
            }
            // ?????xxxx 인 경우
            else{
                StringBuilder sb = new StringBuilder(q);
                sb.reverse();
                res[i] = reverseTrie.query(sb.toString(), sb.toString().length());
            }
        }
        return res;
    }
}