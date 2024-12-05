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

class Checker {
   public:
    int x, y;
    Checker(int x, int y) : x(x), y(y) {}
};

int getDis(int i, int j, Checker c) { return abs(i - c.x) + abs(j - c.y); }

void solve() {
    int N;
    cin >> N;
    vector<int> x_arr(N), y_arr(N), dist(N, INT_MAX);
    vector<Checker> checkers;

    for (int i = 0; i < N; i++) {
        int x, y;
        cin >> x >> y;
        x_arr[i] = x;
        y_arr[i] = y;
        checkers.emplace_back(x, y);  // 객체 생성과 동시에 삽입
    }

    for (int i = 0; i < x_arr.size(); i++) {
        for (int j = 0; j < y_arr.size(); j++) {
            vector<int> distances;
            for (auto& c : checkers) {
                distances.push_back(getDis(x_arr[i], y_arr[j], c));
            }

            sort(ALL(distances));

            int cnt = 0;
            for (int k = 0; k < distances.size(); k++) {
                cnt += distances[k];
                dist[k] = min(cnt, dist[k]);
            }
        }
    }

    for (int i = 0; i < N; i++) {
        cout << dist[i] << " ";
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