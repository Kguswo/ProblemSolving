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
    int N, W;
    cin >> N >> W;
    long long leaf = 0;
    double res = 0;
    vector<int> tree(500010, 0);

    for (int i = 0; i < N - 1; i++) {
        int U, V;
        cin >> U >> V;
        tree[U]++;
        tree[V]++;
    }

    for (int i = 2; i <= 500000; i++) {
        if (tree[i] == 1) leaf++;
    }

    res = 1.0 * W / leaf;
    cout << fixed << setprecision(10) << res << "\n";
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