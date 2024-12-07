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
    vector<int> arr(N + 2);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    int minCnt = 0;
    for (int i = 0; i < N; i++) {
        int cycle;
        if (arr[i + 1] > arr[i + 2]) {
            // 2묶음
            cycle = min(arr[i], arr[i + 1] - arr[i + 2]);
            for (int j = 0; j < 2; j++) {
                arr[i + j] -= cycle;
            }
            minCnt += cycle * 5;

            // 3묶음
            cycle = min(arr[i], min(arr[i + 1], arr[i + 2]));
            for (int j = 0; j < 3; j++) {
                arr[i + j] -= cycle;
            }
            minCnt += cycle * 7;

            // 1묶음
            cycle = arr[i];
            arr[i] -= cycle;
            minCnt += cycle * 3;
        } else {
            // 3묶음
            cycle = min(arr[i], min(arr[i + 1], arr[i + 2]));
            for (int j = 0; j < 3; j++) {
                arr[i + j] -= cycle;
            }
            minCnt += cycle * 7;

            // 2묶음
            int cycle = min(arr[i], arr[i + 1]);
            for (int j = 0; j < 2; j++) {
                arr[i + j] -= cycle;
            }
            minCnt += cycle * 5;

            // 1묶음
            cycle = arr[i];
            arr[i] -= cycle;
            minCnt += cycle * 3;
        }
    }
    cout << minCnt << "\n";
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