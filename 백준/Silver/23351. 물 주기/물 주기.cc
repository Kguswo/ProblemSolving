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

int N, K, A, B;
vector<int> tree, lazy;

void propagate(int node, int start, int end) {
    if (lazy[node]) {
        tree[node] += (end - start + 1) * lazy[node];
    }

    if (start != end) {
        lazy[node * 2] += lazy[node];
        lazy[node * 2 + 1] += lazy[node];
    }
    lazy[node] = 0;
}

int init(vector<int>& arr, int node, int start, int end) {
    if (start == end) return tree[node] = arr[start];
    int mid = start + (end - start) / 2;
    return tree[node] = init(arr, node * 2, start, mid) +
                        init(arr, node * 2 + 1, mid + 1, end);
}

int query(int node, int start, int end, int left, int right) {
    propagate(node, start, end);
    if (start > right || end < left) return 0;
    if (start >= left && end <= right) return tree[node];

    int mid = start + (end - start) / 2;

    return query(node * 2, start, mid, left, right) +
           query(node * 2 + 1, mid + 1, end, left, right);
}

void update(int node, int start, int end, int left, int right, int value) {
    propagate(node, start, end);
    if (start > right || end < left) return;
    if (start >= left && end <= right) {
        tree[node] += (end - start + 1) * value;
        if (start != end) {
            lazy[node * 2] += value;
            lazy[node * 2 + 1] += value;
        }
        return;
    }
    int mid = start + (end - start) / 2;
    update(node * 2, start, mid, left, right, value);
    update(node * 2 + 1, mid + 1, end, left, right, value);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

void solve() {
    cin >> N >> K >> A >> B;
    vector<int> arr(N, K);

    int h = ceil(log2(N));
    int size = (1 << (h + 1));
    tree.resize(size);
    lazy.resize(size);

    init(arr, 1, 0, N - 1);

    int res = 0;
    while (true) {
        res++;

        int minSum = INT_MAX, minIdx = 0;
        for (int i = 0; i <= N - A; i++) {
            int sum = query(1, 0, N - 1, i, i + A - 1);
            if (sum < minSum) {
                minSum = sum;
                minIdx = i;
            }
        }

        update(1, 0, N - 1, minIdx, minIdx + A - 1, B);
        update(1, 0, N - 1, 0, N - 1, -1);

        int minValue = query(1, 0, N - 1, 0, 0);
        for (int i = 1; i < N; i++) {
            minValue = min(minValue, query(1, 0, N - 1, i, i));
        }

        if (minValue <= 0) break;
    }

    cout << res << '\n';
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