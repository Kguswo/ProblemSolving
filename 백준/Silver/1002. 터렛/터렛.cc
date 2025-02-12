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
    int x1, y1, r1, x2, y2, r2;
    cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

    int dist_squared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

    if (x1 == x2 && y1 == y2) {
        if (r1 == r2)
            cout << -1 << "\n";
        else
            cout << 0 << "\n";
        return;
    }

    if (dist_squared == (r1 + r2) * (r1 + r2) ||
        dist_squared == abs(r1 - r2) * abs(r1 - r2)) {
        cout << 1 << "\n";
        return;
    }

    if (abs(r1 - r2) * abs(r1 - r2) < dist_squared &&
        dist_squared < (r1 + r2) * (r1 + r2)) {
        cout << 2 << "\n";
        return;
    }

    cout << 0 << '\n';
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