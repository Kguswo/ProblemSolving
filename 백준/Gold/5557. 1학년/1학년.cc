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

int N, end_num;

void solve() {
    cin >> N;
    int arr[N];
    for (int i = 1; i < N; i++) {
        cin >> arr[i];
    }
    cin >> end_num;

    long long dp[N + 1][21];
    memset(dp, 0, sizeof(dp));

    dp[1][arr[1]] = 1;

    long long up, down;
    for (int i = 2; i <= N - 1; i++) {
        for (int j = 0; j <= 20; j++) {
            up = (j - arr[i] >= 0) ? dp[i - 1][j - arr[i]] : 0;
            down = (j + arr[i] <= 20) ? dp[i - 1][j + arr[i]] : 0;
            dp[i][j] = up + down;
        }
    }

    cout << dp[N - 1][end_num];
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