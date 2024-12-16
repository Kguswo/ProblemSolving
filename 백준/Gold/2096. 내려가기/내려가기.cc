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

    vector<int> maxdp(3), mindp(3);
    vector<int> nextmaxdp(3), nextmindp(3);

    for (int i = 0; i < 3; i++) {
        int num;
        cin >> num;
        maxdp[i] = mindp[i] = num;
    }

    for (int i = 1; i < N; i++) {
        vector<int> tmp(3);
        for (int j = 0; j < 3; j++) {
            cin >> tmp[j];
        }

        nextmaxdp[0] = tmp[0] + max(maxdp[0], maxdp[1]);
        nextmindp[0] = tmp[0] + min(mindp[0], mindp[1]);
        nextmaxdp[1] = tmp[1] + max(maxdp[0], max(maxdp[1], maxdp[2]));
        nextmindp[1] = tmp[1] + min(mindp[0], min(mindp[1], mindp[2]));
        nextmaxdp[2] = tmp[2] + max(maxdp[1], maxdp[2]);
        nextmindp[2] = tmp[2] + min(mindp[1], mindp[2]);

        maxdp = nextmaxdp;
        mindp = nextmindp;
    }

    int maxres = max(maxdp[0], max(maxdp[1], maxdp[2]));
    int minres = min(mindp[0], min(mindp[1], mindp[2]));

    cout << maxres << " " << minres << "\n";
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