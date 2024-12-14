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
    int N, K;
    cin >> N >> K;
    vector<vector<int>> books(11);
    vector<vector<long long>> dp(11, vector<long long>(K + 1));

    for (int i = 0; i < N; i++) {
        int price, category;
        cin >> price >> category;
        books[category].push_back(price);
    }

    for (int i = 1; i <= 10; i++) {
        sort(books[i].rbegin(), books[i].rend());
        // sort(books[i].begin(), books[i].end(), greater<int>());
        // sort(books[i].begin(), books[i].end(),
        //      [](int a, int b) { return a > b; });

        vector<int> tmp = books[i];
        for (int j = 1; j < books[i].size(); j++) {
            books[i][j] = books[i][j] + books[i][j - 1];
        }
        for (int j = 1; j < books[i].size(); j++) {
            books[i][j] = books[i][j] + j * (j + 1);
        }
    }

    int bookCnt = 0;
    for (int i = 1; i <= 10; i++) {
        int categorySize = books[i].size();
        int leftAmount =
            min(K, bookCnt + categorySize);  // 고를 수 있는 최대 수

        for (int j = 0; j <= leftAmount; j++) {
            dp[i][j] = dp[i - 1][j];
            for (int k = 1; k <= categorySize; k++) {
                if (j >= k) {
                    dp[i][j] =
                        max(dp[i][j], dp[i - 1][j - k] + books[i][k - 1]);
                }
            }
        }
        bookCnt = min(bookCnt + categorySize, K);
    }
    cout << dp[10][K] << "\n";
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