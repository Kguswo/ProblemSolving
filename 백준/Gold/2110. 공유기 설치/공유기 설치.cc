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
    int N, C;
    cin >> N >> C;
    vector<int> arr;

    int pos;
    for (int i = 0; i < N; i++) {
        cin >> pos;
        arr.push_back(pos);
    }
    sort(ALL(arr));
    int minlen = 1;
    int maxlen = (arr[N - 1] - arr[0]) / (C - 1);
    int res = 0;

    while (minlen <= maxlen) {
        int mid = minlen + (maxlen - minlen) / 2;

        int currPos = arr[0];
        int tmpCnt = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] - currPos >= mid) {
                tmpCnt++;
                currPos = arr[i];
            }
        }

        if (tmpCnt < C) {
            maxlen = mid - 1;
        } else {
            res = mid;
            minlen = mid + 1;
        }
    }
    cout << res << "\n";
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