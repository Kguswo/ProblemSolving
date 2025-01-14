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

int n, res;
vector<pair<int, int>> flavor;

void dfs(int depth, int visited, int sour, int bitter) {
    if (depth == n) {
        if (visited > 0) {
            res = min(res, abs(sour - bitter));
        }
        return;
    }

    dfs(depth + 1, visited | (1 << depth), sour * flavor[depth].first,
        bitter + flavor[depth].second);
    dfs(depth + 1, visited, sour, bitter);
}

void solve() {
    cin >> n;
    flavor.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> flavor[i].first >> flavor[i].second;
    }
    res = INT_MAX;
    dfs(0, 0, 1, 0);
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