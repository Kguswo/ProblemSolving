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

int getTime(char c) {
    if (c >= 'A' && c <= 'C') return 3;
    if (c >= 'D' && c <= 'F') return 4;
    if (c >= 'G' && c <= 'I') return 5;
    if (c >= 'J' && c <= 'L') return 6;
    if (c >= 'M' && c <= 'O') return 7;
    if (c >= 'P' && c <= 'S') return 8;
    if (c >= 'T' && c <= 'V') return 9;
    if (c >= 'W' && c <= 'Z') return 10;
    return 0;
}

void solve() {
    string word;
    cin >> word;

    int total_time = 0;
    for (char c : word) {
        total_time += getTime(c);
    }

    cout << total_time << endl;
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