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
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
 
    long long even_sum = 0, odd_sum = 0;
    for (int i = 0; i < n; i++) {
        if (i % 2)
            odd_sum += a[i];
        else
            even_sum += a[i];
    }
 
    int even_count = (n + 1) / 2;
    int odd_count = n / 2;
 
    if ((even_sum + odd_sum) % n != 0) {
        cout << "NO
";
        return;
    }
 
    long long target = (even_sum + odd_sum) / n;
    if (even_sum % even_count != 0 || odd_sum % odd_count != 0 ||
        even_sum / even_count != target || odd_sum / odd_count != target) {
        cout << "NO
";
        return;
    }
 
    cout << "YES
";
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