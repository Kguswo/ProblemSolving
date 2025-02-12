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
    bool flag = false;
    while (!flag) {
        cin >> a >> b >> c;
        if (a == 0 && b == 0 && c == 0) {
            flag = true;
            break;
        };

        int maxSide = max({a, b, c});
        int sum = a + b + c;

        if (maxSide >= sum - maxSide) {
            cout << "Invalid\n";
            continue;
        }

        if (a == b && b == c) {
            cout << "Equilateral\n";
        }

        else if (a == b || b == c || a == c) {
            cout << "Isosceles\n";
        }

        else {
            cout << "Scalene\n";
        }
    }
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