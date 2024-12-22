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
    int N;
    cin >> N;
    vector<int> arr(N);
    int minNum = INT_MAX, maxNum = INT_MIN;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
        minNum = min(minNum, arr[i]);
        maxNum = max(maxNum, arr[i]);
    }
    /*
    반드시 한바퀴 돌 때 min->max 할 때 그리고 max->min할 때 각각 |max-min|
    이상의 길이가 필요하므로 최소값은 2 x |maxNum - minNum|
    */
    cout << 2 * abs(maxNum - minNum) << "\n";
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