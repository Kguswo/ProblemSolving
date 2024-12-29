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

int N;
vector<int> number;
stringstream res;

void permutation(int depth, int visited) {
    if (depth == N) {
        for (int i = 0; i < N; i++) {
            res << number[i] << " ";
        }
        res << "\n";
        return;
    }

    for (int i = 1; i <= N; i++) {
        if ((visited & (1 << (i - 1))) == 0) {
            number[depth] = i;
            permutation(depth + 1, visited | (1 << (i - 1)));
        }
    }
}

void solve() {
    cin >> N;
    number.resize(N);
    permutation(0, 0);
    cout << res.str();
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