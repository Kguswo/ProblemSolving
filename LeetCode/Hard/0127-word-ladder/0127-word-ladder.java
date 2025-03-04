class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int cnt = 1;

        if(!wordList.contains(endWord)) return 0;

        Map<String, Integer> visited = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.put(beginWord, 0);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String curr = queue.poll();

                if(curr.equals(endWord)) return cnt;

                for(String next : wordList){
                    if(!visited.containsKey(next) && oneDifferent(curr, next)){
                        queue.offer(next);
                        visited.put(next, 0);
                    }
                }
            }
            cnt ++;
        }
        return 0;
    }

    boolean oneDifferent(String curr, String next) {
        if(curr.length() != next.length()) return false;

        int diffCnt = 0;
        for(int i=0; i<curr.length(); i++){
            if(curr.charAt(i) != next.charAt(i)) {
                diffCnt ++;
                if(diffCnt > 1) return false;
            }
        }
        return diffCnt == 1;
    }
}