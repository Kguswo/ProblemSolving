#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    int N, M, K;
    cin >> N >> M >> K;

    int cnt = min(M, N/2);
    cnt = min(cnt, (N+M-K)/3);
    cout << cnt;
}