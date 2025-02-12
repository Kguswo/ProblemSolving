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
    int a, b, c;
    cin >> a >> b >> c;

    vector<int> sides = {a, b, c};
    sort(ALL(sides));

    int res = 0;

    if (sides[0] + sides[1] <= sides[2]) {
        res = 2 * (sides[0] + sides[1]) - 1;
    } else {
        res = sides[0] + sides[1] + sides[2];
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