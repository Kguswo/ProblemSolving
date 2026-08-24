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
    int n, q;
    cin >> n >> q;
    vector<long long> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
 
    // 세그먼트 트리를 사용하여 구간 GCD를 효율적으로 계산
    vector<long long> diff(n - 1);
    for (int i = 0; i < n - 1; i++) {
        diff[i] = abs(a[i + 1] - a[i]);
    }
 
    // 세그먼트 트리 구성
    int size = 1;
    while (size < n - 1) size *= 2;
    vector<long long> seg(2 * size);
 
    // 세그먼트 트리 초기화
    for (int i = 0; i < n - 1; i++) {
        seg[size + i] = diff[i];
    }
    for (int i = size - 1; i > 0; i--) {
        seg[i] = gcd(seg[2 * i], seg[2 * i + 1]);
    }
 
    // 구간 GCD 쿼리 함수
    auto query = [&](int l, int r) {
        l += size;
        r += size;
        long long result = 0;
        while (l < r) {
            if (l & 1) result = gcd(result, seg[l++]);
            if (r & 1) result = gcd(result, seg[--r]);
            l >>= 1;
            r >>= 1;
        }
        return result;
    };
 
    while (q--) {
        int l, r;
        cin >> l >> r;
        l--;
        r--;
 
        if (l == r) {
            cout << "0 ";
            continue;
        }
 
        // 구간 내 모든 수가 같은지 빠르게 확인
        if (query(l, r) == 0) {
            cout << "0 ";
            continue;
        }
 
        cout << query(l, r) << " ";
    }
    cout << "
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