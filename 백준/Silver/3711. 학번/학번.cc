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
    int G;
    cin >> G;
    vector<int> students(G);

    for (int i = 0; i < G; i++) {
        cin >> students[i];
    }

    for (int m = 1;; m++) {
        vector<int> remainers;
        bool flag = true;

        for (int s : students) {
            int remainer = s % m;
            if (find(ALL(remainers), remainer) != remainers.end()) {
                flag = false;
                break;
            }
            remainers.push_back(remainer);
        }
        if (flag) {
            cout << m << "\n";
            break;
        }
    }
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