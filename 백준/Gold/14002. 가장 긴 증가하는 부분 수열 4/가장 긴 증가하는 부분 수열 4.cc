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
    int n;
    cin >> n;
    vector<int> arr(n + 1);
    vector<int> dp(n + 1, 1);

    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    int maxLen = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j < i; j++) {
            if (arr[i] > arr[j]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        maxLen = max(maxLen, dp[i]);
    }

    // 역추적
    vector<int> result;
    int len = maxLen;
    for (int i = n; i >= 1; i--) {
        if (dp[i] == len) {
            result.push_back(arr[i]);
            len--;
        }
    }

    cout << maxLen << "\n";
    for (int i = result.size() - 1; i >= 0; i--) {
        cout << result[i] << " ";
    }
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