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
    int N, dasom, res = 0;
    cin >> N;

    if (N == 1) {
        cout << "0" << "\n";
        return;
    }

    cin >> dasom;
    priority_queue<int> pq;
    for (int i = 1; i < N; i++) {
        int num;
        cin >> num;
        pq.push(num);
    }

    while (!pq.empty() && dasom <= pq.top()) {
        int tmp = pq.top();
        pq.pop();
        dasom++;
        res++;
        pq.push(tmp - 1);
    }

    cout << res << "\n";
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