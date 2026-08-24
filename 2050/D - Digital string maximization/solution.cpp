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
    string s;
    cin >> s;
    int n = s.length();
 
    // 각 위치에서 가능한 최대값을 한 번에 계산
    for (int i = 0; i < n - 1; i++) {
        // 현재 위치에서 가능한 최대값과 그 위치 찾기
        int maxVal = s[i] - '0';
        int maxPos = i;
 
        // i+1부터 시작하여 현재 위치까지 가져올 수 있는 최대값 찾기
        for (int j = i + 1; j < min(n, i + 10); j++) {
            if (s[j] == '0') continue;
            int val = s[j] - '0' - (j - i);
            if (val > maxVal) {
                maxVal = val;
                maxPos = j;
            }
        }
 
        // 최대값을 찾았다면 문자열 업데이트
        if (maxPos != i) {
            char c = maxVal + '0';
            for (int j = maxPos; j > i; j--) {
                s[j] = s[j - 1];
            }
            s[i] = c;
        }
    }
 
    cout << s << "
";
}
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
 
    int tt = 1;  // 기본적으로 1번의 테스트 케이스를 처리
    cin >> tt;   // 테스트 케이스 수 입력 (필요 시)
 
    while (tt--) {
        solve();
    }
    return 0;
}