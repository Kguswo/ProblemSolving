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

int N, M, H, a, b, res = -1;
vector<vector<int>> ladder;
bool flag;

bool needMoreThan4() {
    int sum = 0;
    for (int i = 1; i < N; i++) {
        int cnt = 0;
        for (int j = 1; j <= H; j++) {
            if (ladder[j][i] == 1) cnt++;
        }
        if (cnt % 2 != 0) sum++;
    }
    return sum >= 4;
}

int goDown(int start) {
    int r = 1;
    int c = start;
    while (r <= H) {
        c += ladder[r][c];
        r++;
    }
    return c;
}

bool check() {
    for (int i = 1; i <= N; i++) {
        if (goDown(i) != i) return false;
    }
    return true;
}

void dfs(int cnt, int depth, int line) {
    if (cnt > line) return;
    if (cnt == line) {
        if (check()) {
            res = cnt;
            return;
        }
        return;
    }

    for (int i = depth; i <= H; i++) {
        for (int j = 1; j < N; j++) {
            if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
                if (j >= 2 && ladder[i][j - 1] == 1) continue;
                if (j < N - 1 && ladder[i][j + 2] == -1) continue;

                ladder[i][j] = 1;
                ladder[i][j + 1] = -1;

                dfs(cnt + 1, i, line);
                if (res != -1) return;

                ladder[i][j] = 0;
                ladder[i][j + 1] = 0;
            }
        }
    }
}

void solve() {
    cin >> N >> M >> H;
    ladder.resize(H + 1, vector<int>(N + 1, 0));

    if (M == 0) {
        cout << 0 << endl;
        return;
    } else if (M == 1) {
        if (H == 1)
            cout << -1 << endl;
        else
            cout << 1 << endl;
        return;
    }

    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        ladder[a][b] = 1;
        ladder[a][b + 1] = -1;
    }

    if (needMoreThan4()) {
        cout << -1 << endl;
        return;
    }

    if (check()) {
        cout << 0 << endl;
        return;
    }

    for (int i = 0; i <= 3; i++) {
        dfs(0, 1, i);
        if (res != -1) break;
    }

    cout << res << endl;
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