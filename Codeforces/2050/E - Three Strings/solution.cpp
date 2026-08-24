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
    string a, b, c;
    cin >> a >> b >> c;
 
    int n = a.size(), m = b.size();
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, n + m));
    dp[0][0] = 0;
 
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            if (i < n && dp[i][j] < n + m) {
                dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + (a[i] != c[i + j]));
            }
            if (j < m && dp[i][j] < n + m) {
                dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + (b[j] != c[i + j]));
            }
        }
    }
 
    cout << dp[n][m] << '
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