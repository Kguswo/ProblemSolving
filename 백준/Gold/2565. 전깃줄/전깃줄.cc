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

    vector<pair<int, int>> board(N + 1);
    vector<int> dp(N + 1, 1);

    for (int i = 1; i <= N; i++) {
        cin >> board[i].first >> board[i].second;
    }

    sort(ALL(board));

    int res = 0;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j < i; j++) {
            if (board[i].second > board[j].second)
                dp[i] = max(dp[i], dp[j] + 1);
        }
        res = max(res, dp[i]);
    }
    cout << N - res << "\n";
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