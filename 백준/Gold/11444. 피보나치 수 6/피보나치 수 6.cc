/**
 * Author: nowalex322, Kim HyeonJae
 */
#include <bits/stdc++.h>
using namespace std;

#define int long long
#define MOD 1000000007
#define INF LLONG_MAX
#define ALL(v) v.begin(), v.end()

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#endif

map<int, int> fibo;

int getFibo(int n) {
    if (fibo.contains(n)) return fibo[n];
    int num;
    if (n % 2 == 0)
        num =
            (getFibo(n / 2) * (getFibo(n / 2 - 1) + getFibo(n / 2 + 1)) % MOD) %
            MOD;
    else
        num = ((getFibo((n - 1) / 2)) * (getFibo((n - 1) / 2)) % MOD) % MOD +
              ((getFibo((n + 1) / 2)) * (getFibo((n + 1) / 2)) % MOD) % MOD;

    return fibo[n] = num % MOD;
}

void solve() {
    int n;
    cin >> n;
    fibo[0] = 0;
    fibo[1] = 1;
    fibo[2] = fibo[0] + fibo[1];
    int res = 0;
    res = getFibo(n);
    cout << res << "\n";
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tt = 1;  // 기본적으로 1번의 테스트 케이스를 처리
    // cin >> tt;    // 테스트 케이스 수 입력 (필요 시)

    while (tt--) {
        solve();
    }
    return 0;
}