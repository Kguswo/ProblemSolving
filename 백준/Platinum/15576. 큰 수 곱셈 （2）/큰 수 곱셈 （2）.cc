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

typedef complex<double> base;
typedef long long ll;
const double PI = acos(-1);

void fft(vector<base>& a, bool invert) {
    int n = a.size(), j = 0;
    vector<base> roots(n / 2);

    for (int i = 1; i < n; i++) {
        int bit = (n >> 1);
        while (j >= bit) {
            j -= bit;
            bit >>= 1;
        }
        j += bit;
        if (i < j) swap(a[i], a[j]);
    }

    double ang = 2 * PI / n * (invert ? -1 : 1);
    for (int i = 0; i < n / 2; i++) {
        roots[i] = base(cos(ang * i), sin(ang * i));
    }

    for (int i = 2; i <= n; i <<= 1) {
        int step = n / i;
        for (int j = 0; j < n; j += i) {
            for (int k = 0; k < i / 2; k++) {
                base u = a[j + k], v = a[j + k + i / 2] * roots[step * k];
                a[j + k] = u + v;
                a[j + k + i / 2] = u - v;
            }
        }
    }
    if (invert) {
        for (int i = 0; i < n; i++) a[i] /= n;
    }
}

void solve() {
    string s1, s2;
    cin >> s1 >> s2;

    if (s1 == "0" || s2 == "0") {
        cout << "0\n";
        return;
    }

    vector<ll> a(s1.size()), b(s2.size());
    for (int i = 0; i < s1.size(); i++) a[s1.size() - i - 1] = s1[i] - '0';
    for (int i = 0; i < s2.size(); i++) b[s2.size() - i - 1] = s2[i] - '0';

    vector<base> fa(a.begin(), a.end()), fb(b.begin(), b.end());
    int n = 2;
    while (n < a.size() + b.size()) n <<= 1;
    fa.resize(n);
    fb.resize(n);

    fft(fa, false);
    fft(fb, false);
    for (int i = 0; i < n; i++) fa[i] *= fb[i];
    fft(fa, true);

    vector<ll> result(n);
    for (int i = 0; i < n; i++) result[i] = (ll)round(fa[i].real());

    for (int i = 0; i < result.size() - 1; i++) {
        result[i + 1] += result[i] / 10;
        result[i] %= 10;
    }

    int idx = result.size() - 1;
    while (idx > 0 && result[idx] == 0) idx--;
    for (; idx >= 0; idx--) cout << result[idx];
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