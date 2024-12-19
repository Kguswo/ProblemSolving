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
    int N, M;
    cin >> N >> M;

    vector<int> list;
    for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        list.push_back(num);
    }

    for (int i = 0; i < M; i++) {
        int num;
        cin >> num;
        list.push_back(num);
    }

    sort(ALL(list));

    for (int num : list) {
        cout << num << " ";
    }
    cout << "\n";
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