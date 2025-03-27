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
    vector<int> height;
    int cnt = 0;

    int tc;
    cin >> tc;
    cout << tc << " ";

    for (int i = 1; i <= 20; i++) {
        int h;
        cin >> h;

        for (int j = height.size() - 1; j >= 0; j--) {
            if (height[j] > h)
                cnt++;
            else
                break;
        }

        height.push_back(h);
        sort(ALL(height));
    }

    cout << cnt << "\n";
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tt;
    cin >> tt;

    while (tt--) {
        solve();
    }
    return 0;
}