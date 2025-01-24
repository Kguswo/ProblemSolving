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

int N, M;
vector<vector<char>> board;
int dr[4] = {-1, 1, 0, 0}, dc[4] = {0, 0, -1, 1};

bool isValid(int r, int c) { return r >= 0 && r < N && c >= 0 && c < M; }

void command2(int r, int c) { board[r][c] = (board[r][c] == 'W') ? 'B' : 'W'; }

void solve() {
    cin >> N >> M;

    board.resize(N, vector<char>(M));

    for (int i = 0; i < N; i++) {
        string str;
        cin >> str;
        for (int j = 0; j < M; j++) {
            board[i][j] = str[j];
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 4; k++) {
                int nr = i + dr[k];
                int nc = j + dc[k];
                if (isValid(nr, nc)) command2(nr, nc);
            }
        }
    }

    cout << 1 << "\n";
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cout << (board[i][j] == 'B' ? 3 : 2);
        }
        cout << "\n";
    }
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