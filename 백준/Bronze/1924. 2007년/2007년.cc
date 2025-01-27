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

int month[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string day[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

void solve() {
    int x, y;
    cin >> x >> y;
    int sum = 0;
    for (int i = 0; i < x - 1; i++) {
        sum += month[i];
    }
    sum += y;

    cout << day[sum % 7] << "\n";
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