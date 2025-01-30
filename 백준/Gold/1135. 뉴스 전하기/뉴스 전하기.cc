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

int N;
vector<int> parent;
vector<int> childTime;
int maxT = 0;

void updateTime(int num) {
    vector<int> childList;
    for (int i = 0; i < N; i++) {
        if (parent[i] == num) childList.push_back(childTime[i]);
    }

    sort(ALL(childList), greater<int>());

    maxT = 0;
    for (int order = 1; order <= childList.size(); order++) {
        maxT = max(maxT, order + childList[order - 1]);
    }
    childTime[num] = maxT;
}

void solve() {
    cin >> N;
    parent.resize(N);
    childTime.resize(N);

    for (int i = 0; i < N; i++) {
        cin >> parent[i];
    }

    for (int i = N - 1; i >= 0; i--) {
        updateTime(i);
    }
    cout << childTime[0] << "\n";
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