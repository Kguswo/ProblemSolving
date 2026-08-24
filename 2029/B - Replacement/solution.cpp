#include <bits/stdc++.h>
using namespace std;
 
class Solution {
public:
    void solve() {
        int t;
        cin >> t;
        while(t--) {
            int n;
            cin >> n;
            string s, r;
            cin >> s >> r;
            
            deque<char> dq;
            for(char c : s) dq.push_back(c);
            
            bool possible = true;
            int lastPos = 0;  // 이전에 찾은 위치부터 시작
            
            for(int i = 0; i < n-1 && possible; i++) {
                bool found = false;
                
                // lastPos부터 검사 시작
                for(int j = lastPos; j < dq.size()-1; j++) {
                    if(dq[j] != dq[j+1]) {
                        found = true;
                        dq[j] = r[i];
                        dq.erase(dq.begin() + j + 1);
                        lastPos = max(0, j-1);  // 하나 지웠으니 이전 위치부터 다시 검사
                        break;
                    }
                }
                
                // lastPos부터 못찾았다면 처음부터 한번 더 검사
                if(!found && lastPos > 0) {
                    for(int j = 0; j < min(lastPos+1, (int)dq.size()-1); j++) {
                        if(dq[j] != dq[j+1]) {
                            found = true;
                            dq[j] = r[i];
                            dq.erase(dq.begin() + j + 1);
                            lastPos = max(0, j-1);
                            break;
                        }
                    }
                }
                
                if(!found) possible = false;
            }
            
            cout << (possible ? "YES
" : "NO
");
        }
    }
};
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    Solution().solve();
    return 0;
}