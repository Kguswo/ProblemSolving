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

int dr[] = {0, -1, 0, 1}, dc[] = {-1, 0, 1, 0};
int N;
vector<vector<int>> board;
vector<vector<bool>> visited;
int maxVal = -210, minVal = 210;

bool canGo(int i, int j) {
    if (!(board[1][1] >= i && board[1][1] <= j)) return false;

    queue<pair<int, int>> queue;
    visited.assign(N + 2, vector<bool>(N + 2, false));
    queue.push({1, 1});
    visited[1][1] = true;

    while (!queue.empty()) {
        int curr[] = {queue.front().first, queue.front().second};
        queue.pop();

        if (curr[0] == N && curr[1] == N) return true;

        for (int k = 0; k < 4; k++) {
            int next[] = {curr[0] + dr[k], curr[1] + dc[k]};
            if (board[next[0]][next[1]] == -1 || visited[next[0]][next[1]])
                continue;
            if (board[next[0]][next[1]] >= i && board[next[0]][next[1]] <= j) {
                queue.push({next[0], next[1]});
                visited[next[0]][next[1]] = true;
            }
        }
    }
    return false;
}

void solve() {
    cin >> N;

    board.assign(N + 2, vector<int>(N + 2, -1));
    visited.assign(N + 2, vector<bool>(N + 2, false));

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> board[i][j];
            maxVal = max(maxVal, board[i][j]);
            minVal = min(minVal, board[i][j]);
        }
    }

    int res = 210;
    int left = abs(board[1][1] - board[N][N]);
    int right = maxVal - minVal;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        bool flag = false;

        for (int i = minVal; i <= maxVal - mid; i++) {
            int j = i + mid;
            if (canGo(i, j)) {
                flag = true;
                break;
            }
        }

        if (flag) {
            right = mid - 1;
            res = mid;
        } else {
            left = mid + 1;
        }
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