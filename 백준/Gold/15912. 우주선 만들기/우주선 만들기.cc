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
    int N;
    cin >> N;
    vector<long long> W(N + 1), E(N + 1), dp(N + 1);

    for (int i = 1; i <= N; i++) {
        cin >> W[i];
    }
    for (int i = 1; i <= N; i++) {
        cin >> E[i];
    }

    for (int i = 1; i <= N; i++) {
        dp[i] = LLONG_MAX;
        long long maxW = 0, maxE = 0;
        for (int j = i; j >= 1; j--) {
            maxW = max(maxW, W[j]);
            maxE = max(maxE, E[j]);
            dp[i] = min(dp[j - 1] + maxW * maxE, dp[i]);
        }
    }

    cout << dp[N] << "\n";
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