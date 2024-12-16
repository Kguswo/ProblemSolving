class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int start = hashing(startGene);
        int end = hashing(endGene);
        List<Integer> geneBank = new ArrayList<>();
        for(String s : bank){
            geneBank.add(hashing(s));
        }

        if(!geneBank.contains(end)) return -1;
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int cnt = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                int curr = queue.poll();
                if(curr == end) return cnt;

                for(int idx = 0; idx < 8; idx++){
                    int idxNum = curr/ (int) Math.pow(10, idx) % 10;
                    for(int newNum= 1; newNum <= 4; newNum++){
                         if(idxNum != newNum) {
                            int next = curr + (newNum - idxNum) * (int) Math.pow(10, idx);
                            if(geneBank.contains(next) && !visited.contains(next)){
                                queue.offer(next);
                                visited.add(next);
                            }
                         }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    
    private int hashing(String str){ // 10진수 해싱 
        int num = 0;
        for(int i=0; i<8; i++){
            num *= 10;
            char c = str.charAt(i);
            if(c=='A') num += 1;
            else if(c=='C') num += 2;
            else if(c=='G') num += 3;
            else num += 4;
        }
        return num;
    }
}