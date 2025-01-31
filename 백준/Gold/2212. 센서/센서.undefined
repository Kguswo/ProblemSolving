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
    int N, K;
    cin >> N >> K;
    if (K >= N) {
        cout << 0;
        return;
    }

    vector<int> arr(N);
    vector<int> len(N - 1);
    int res = 0;

    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    sort(ALL(arr));

    for (int i = 0; i < N - 1; i++) {
        len[i] = arr[i + 1] - arr[i];
        res += len[i];
    }

    sort(ALL(len));

    for (int i = len.size() - 1; i > len.size() - 1 - (K - 1); i--) {
        res -= len[i];
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