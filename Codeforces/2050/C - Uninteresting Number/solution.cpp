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
    string n;
    cin >> n;
    vector<int> digits;
    for (char c : n) digits.push_back(c - '0');
 
    int len = digits.size();
    vector<bool> possible(9, false);
    possible[0] = true;
 
    for (int digit : digits) {
        vector<bool> next(9, false);
        for (int mod = 0; mod < 9; mod++) {
            if (!possible[mod]) continue;
            next[(mod + digit) % 9] = true;
            if (digit * digit < 10) {
                next[(mod + digit * digit) % 9] = true;
            }
        }
        possible = next;
    }
 
    cout << (possible[0] ? "YES
" : "NO
");
}
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
 
    int tt = 1;  // 기본적으로 1번의 테스트 케이스를 처리
    cin >> tt;   // 테스트 케이스 수 입력 (필요 시)
 
    while (tt--) {
        solve();
    }
    return 0;
}