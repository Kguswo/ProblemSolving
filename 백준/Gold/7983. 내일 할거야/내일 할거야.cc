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

struct Work {
    int time, end;
    Work(int time = 0, int end = 0) : time(time), end(end) {}
};

bool compare(const Work& a, const Work& b) { return a.end > b.end; }

void solve() {
    int n;
    cin >> n;

    vector<Work> work(n);
    for (int i = 0; i < n; i++) {
        cin >> work[i].time >> work[i].end;
    }

    sort(ALL(work), compare);

    int finalDay = work[0].end;
    for (int i = 0; i < n; i++) {
        if (work[i].end <= finalDay)
            finalDay = work[i].end - work[i].time;
        else
            finalDay -= work[i].time;
    }

    cout << finalDay << "\n";
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