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

struct Node {
    int to;
    int W;
    Node(int to, int W) : to(to), W(W) {}
};

vector<vector<Node>> board;
vector<bool> visited;
int N, robot1, robot2, totalD, maxW;

bool dfs(int start, int end) {
    if (start == end) return true;

    visited[start] = true;

    for (const Node& n : board[start]) {
        if (!visited[n.to]) {
            int prevMaxW = maxW;
            maxW = max(maxW, n.W);
            totalD += n.W;

            if (dfs(n.to, end)) return true;

            maxW = prevMaxW;
            totalD -= n.W;
        }
    }

    visited[start] = false;
    maxW = 0;
    return false;
}

void solve() {
    cin >> N >> robot1 >> robot2;
    if (N == 1 || robot1 == robot2) {
        cout << 0 << "\n";
        return;
    }

    board.resize(N + 1);
    visited.resize(N + 1, false);

    for (int i = 0; i < N - 1; i++) {
        int first, second, w;
        cin >> first >> second >> w;
        board[first].push_back(Node(second, w));
        board[second].push_back(Node(first, w));
    }

    totalD = 0;
    maxW = 0;

    dfs(robot1, robot2);
    cout << totalD - maxW << "\n";
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