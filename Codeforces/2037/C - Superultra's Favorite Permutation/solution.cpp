#include <bits/stdc++.h>
using namespace std;
 
#define f(x1,x2,x3) for(int x1=x2;x1<x3;x1++)
#define fr(x1,x2,x3) for(int x1=x2;x1>=x3;x1--)
#define forni for(int i=0;i<n;i++)
#define pb push_back
 
const int N = 2e5+20;
bool ch[N];
 
bool check(long long n) {
    for(int i=2; i*i<=n; i++) {
        if(!(n%i)) return true;
    }
    return false;
}
 
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    
    while(t--) {
        long long n;
        cin >> n;
        
        vector<long long> v;
        // 첫 번째로 1 추가
        v.pb(1);
        
        // 모든 홀수 추가 (3, 5, 7, ...)
        long long l = 3;
        while(l <= n) {
            v.pb(l);
            l += 2;
        }
        
        // 마지막으로 추가된 홀수
        l -= 2;
        // 사용된 짝수 체크 배열 초기화
        memset(ch, false, sizeof(ch));
        
        // 첫 번째 짝수 찾기
        long long r = 2;
        bool f = false;
        while(r <= n) {
            if(check(l+r)) {  // 마지막 홀수와의 합이 합성수인 짝수 찾기
                f = true;
                ch[r] = true;  // 사용했다고 표시
                v.pb(r);
                break;
            }
            r += 2;
        }
        
        if(!f) {
            cout << "-1
";
        } else {
            // 나머지 짝수들 추가
            r = 2;
            while(r <= n) {
                if(!ch[r]) {
                    v.pb(r);
                }
                r += 2;
            }
            
            // 결과 출력
            for(auto c : v) {
                cout << c << " ";
            }
            cout << endl;
        }
    }
    return 0;
}