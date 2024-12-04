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
    int k, n;
    cin >> k >> n;
    vector<vector<int>> C(4, vector<int>(n));
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < n; j++) {
            cin >> C[i][j];
        }
    }

    vector<int> C1plusC2;
    vector<int> C3plusC4;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            C1plusC2.push_back(C[0][i] + C[1][j]);
            C3plusC4.push_back(C[2][i] + C[3][j]);
        }
    }

    sort(ALL(C1plusC2));
    sort(ALL(C3plusC4));

    int res = C1plusC2[0] + C3plusC4[0];

    for (int i = 0; i < C1plusC2.size(); i++) {
        int target = k - C1plusC2[i];
        int left = 0;
        int right = C3plusC4.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = C1plusC2[i] + C3plusC4[mid];

            if (abs(k - sum) < abs(k - res) ||
                (abs(k - sum) == abs(k - res) && sum < res))
                res = sum;

            if (sum == k) break;
            if (C3plusC4[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
    }
    cout << res << "\n";
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