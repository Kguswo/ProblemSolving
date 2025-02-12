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

    vector<int> x(n), y(n);
    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i];
    }

    if (n == 1) {
        cout << 0 << "\n";
        return;
    }

    int min_x = *min_element(x.begin(), x.end());
    int max_x = *max_element(x.begin(), x.end());
    int min_y = *min_element(y.begin(), y.end());
    int max_y = *max_element(y.begin(), y.end());

    int area = (max_x - min_x) * (max_y - min_y);
    cout << area << "\n";
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