/**
 * Author: nowalex322, Kim HyeonJae
 */
#include <bits/stdc++.h>
using namespace std;

using ll = long long;
#define MOD 1000000007
#define INF LLONG_MAX
#define ALL(v) v.begin(), v.end()

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

int n;
vector<pair<int, int>> board;

void solve() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        board.push_back({x, y});
    }

    vector<int> pos_x;
    for (auto& p : board) {
        pos_x.push_back(p.first);
    }
    sort(ALL(pos_x));
    int mid_x = pos_x[n / 2];

    vector<int> pos_y;
    for (auto& p : board) {
        pos_y.push_back(p.second);
    }
    sort(ALL(pos_y));
    int mid_y = pos_y[n / 2];

    ll res = 0;
    for (const auto& p : board) {
        res += abs(p.first - mid_x) + abs(p.second - mid_y);
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