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
    vector<char> gestures(N);
    for (int i = 0; i < N; i++) {
        cin >> gestures[i];
    }
    /**
     * prefixSum[0] : H, prefixSum[1] : S , prefixSum[2] : P
     */
    vector<vector<int>> prefixSum(3, vector<int>(N + 1));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < 3; j++) {
            prefixSum[j][i + 1] = prefixSum[j][i];
        }

        if (gestures[i] == 'H') prefixSum[2][i + 1]++;
        if (gestures[i] == 'S') prefixSum[0][i + 1]++;
        if (gestures[i] == 'P') prefixSum[1][i + 1]++;
    }
    int maxCnt = 0;

    for (int first = 0; first < 3; first++) {
        for (int second = 0; second < 3; second++) {
            for (int switchIdx = 0; switchIdx <= N; switchIdx++) {
                int tmp = prefixSum[first][switchIdx] +
                          (prefixSum[second][N] - prefixSum[second][switchIdx]);
                maxCnt = max(maxCnt, tmp);
            }
        }
    }
    cout << maxCnt << "\n";
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