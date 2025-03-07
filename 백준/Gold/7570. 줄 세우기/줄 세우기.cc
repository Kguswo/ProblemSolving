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

int N, maxLISLen = 1;
vector<int> dp;

void solve() {
    cin >> N;
    dp.resize(N + 1, 0);
    for (int i = 1; i <= N; i++) {
        int n;
        cin >> n;
        dp[n] = dp[n - 1] + 1;
        maxLISLen = max(maxLISLen, dp[n]);
    }
    cout << N - maxLISLen << "\n";
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tt = 1;  // 기본적으로 1번의 테스트 케이스를 처리
    // cin >> tt;    // 테스트 케이스 수 입력 (필요 시)

    while (tt--) {
        solve();
    }
    return 0;
}