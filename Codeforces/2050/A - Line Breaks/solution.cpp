/**
 * Author: nowalex322, Kim HyeonJae
 */
#include <bits/stdc++.h>
using namespace std;
 
// #define int long long
#define MOD 1000000007
#define INF LLONG_MAX
#define ALL(v) v.begin(), v.end()
 
#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif
 
void solve() {
    int n, m;
    cin >> n >> m;
 
    vector<string> words(n);
    for (int i = 0; i < n; i++) {
        cin >> words[i];
    }
 
    int len = 0;
    int ans = 0;
 
    for (const string& word : words) {
        if (word.length() > m) break;
        if (len + word.length() > m) break;
 
        len += word.length();
        ans++;
    }
 
    cout << ans << '
';
}
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
 
    int tt = 1;  // 기본적으로 1번의 테스트 케이스를 처리
    cin >> tt;   // 테스트 케이스 수 입력 (필요 시)
 
    while (tt--) {
        solve();
    }
    return 0;
}