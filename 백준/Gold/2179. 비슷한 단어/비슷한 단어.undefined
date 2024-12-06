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
    int N;
    cin >> N;

    vector<string> arr(N);

    map<string, int> prefixMap;
    int res1 = 0, res2 = 1;
    int maxLen = 0;

    for (int i = 0; i < N; i++) {
        cin >> arr[i];
        string str = arr[i];

        for (int j = str.length(); j >= 1; j--) {
            string pattern = str.substr(0, j);
            if (pattern.length() < maxLen) break;

            /*
            map.find(key)는:

            키를 찾으면 해당 요소를 가리키는 반복자(iterator)를 반환
            키가 없으면 map.end()를 반환

            그래서 it != map.end()는 "키가 존재한다"는 의미.
            */
            auto p = prefixMap.find(pattern);
            if (p != prefixMap.end()) {
                if (pattern.length() == maxLen && prefixMap[pattern] > res1)
                    break;

                if (pattern.length() == maxLen && prefixMap[pattern] == res1 &&
                    res2 < i)
                    break;

                res1 = prefixMap[pattern];
                res2 = i;
                maxLen = pattern.length();
                break;
            }
            prefixMap[pattern] = i;
        }
    }
    cout << arr[res1] << "\n" << arr[res2] << "\n";
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