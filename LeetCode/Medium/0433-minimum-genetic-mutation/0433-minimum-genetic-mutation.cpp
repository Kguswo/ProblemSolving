#define ALL(v) v.begin(), v.end()

class Solution {
public:
    int minMutation(string startGene, string endGene, vector<string>& bank) {
        int start = hashing(startGene);
        int end = hashing(endGene);

        vector<int> geneBank;
        for(string s : bank){
            geneBank.push_back(hashing(s));
        }

        if(find(ALL(geneBank), end) == geneBank.end()) return -1;

        queue<int> queue;
        unordered_set<int> visited;

        queue.push(start);
        visited.insert(start);

        int cnt = 0;
        while(!queue.empty()){
            int size = queue.size();
            for(int s=0; s<size; s++){
                int curr = queue.front();
                queue.pop();
                if(curr == end) return cnt;

                for(int idx = 0; idx<8; idx++){
                    int idxNum = curr / (int) pow(10, idx) % 10;
                    for(int newNum=1; newNum <= 4; newNum++){
                        if(idxNum != newNum) {
                            int next = curr + (newNum - idxNum) * (int)pow(10, idx);
                            if(find(ALL(geneBank), next) != geneBank.end() && !visited.contains(next)){
                                queue.push(next);
                                visited.insert(next);
                            }
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

private:
    int hashing(string str){
        int num = 0;
        for(int i=0; i<8; i++){
            num *= 10;
            char c = str[i];
            if(c=='A') num += 1;
            else if(c=='C') num += 2;
            else if(c=='G') num += 3;
            else num += 4;
        }
        return num;
    }
};