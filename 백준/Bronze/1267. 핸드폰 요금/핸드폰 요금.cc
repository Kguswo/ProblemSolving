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
    int N, Y = 0, M = 0;
    cin >> N;

    for (int i = 0; i < N; i++) {
        int T;
        cin >> T;
        Y += (T / 30 + 1) * 10;
        M += (T / 60 + 1) * 15;
    }

    if (Y == M)
        cout << "Y M " << Y << "\n";
    else if (Y > M)
        cout << "M " << M << "\n";
    else
        cout << "Y " << Y << "\n";
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