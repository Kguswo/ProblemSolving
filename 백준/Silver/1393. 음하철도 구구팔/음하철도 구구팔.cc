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
    int x0, y0;
    cin >> x0 >> y0;

    int x1, y1, dx, dy;
    cin >> x1 >> y1 >> dx >> dy;

    int g = gcd(abs(dx), abs(dy));
    if (g > 0) {
        dx /= g;
        dy /= g;
    }

    long long min_dist = LLONG_MAX;
    int tx = x1, ty = y1;

    for (int t = 0; t < 200; t++) {
        int currX = x1 + t * dx;
        int currY = y1 + t * dy;
        long long dist = 1LL * (x0 - currX) * (x0 - currX) +
                         1LL * (y0 - currY) * (y0 - currY);

        if (dist < min_dist) {
            min_dist = dist;
            tx = currX;
            ty = currY;
        }
    }

    cout << tx << " " << ty << "\n";
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