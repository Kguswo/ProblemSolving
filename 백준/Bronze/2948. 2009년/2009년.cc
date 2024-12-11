#include <bits/stdc++.h>
using namespace std;

int month[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
char w[7][20] = {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};

void solve() {
    // 2008.12.31은 수요일
    int d, m;
    cin >> d >> m;
    
    int total_days = d;  // Start with the input day
    for (int i = 1; i < m; i++) {
        total_days += month[i];  // Add days from previous months
    }
    
    cout << w[total_days % 7] << '\n';
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tt = 1;
    while (tt--) {
        solve();
    }
    return 0;
}