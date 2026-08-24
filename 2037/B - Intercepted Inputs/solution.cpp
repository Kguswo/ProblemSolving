#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
#include <cmath>
 
using namespace std;
 
// grid_size의 약수를 구하는 함수
vector<int> find_divisors(int x) {
    vector<int> divisors;
    for (int i = 1; i <= sqrt(x); ++i) {
        if (x % i == 0) {
            divisors.push_back(i);
            if (i != x / i) {
                divisors.push_back(x / i);
            }
        }
    }
    return divisors;
}
 
// 각 테스트 케이스를 처리하는 함수
pair<int, int> solve_test_case() {
    int k;
    cin >> k; // 총 숫자 개수
    vector<int> nums(k); // k개의 섞인 숫자들 입력
    set<int> nums_set;
 
    for (int i = 0; i < k; ++i) {
        cin >> nums[i];
        nums_set.insert(nums[i]);
    }
 
    int grid_size = k - 2;
    vector<int> divisors = find_divisors(grid_size);
 
    // 가능한 (n, m) 쌍 필터링
    vector<pair<int, int>> candidates;
    for (int n : divisors) {
        int m = grid_size / n;
        if (nums_set.count(n) && nums_set.count(m)) {
            candidates.emplace_back(n, m);
        }
    }
 
    // 정렬: n이 작은 순, n이 같다면 m이 큰 순
    sort(candidates.begin(), candidates.end(), [](pair<int, int> a, pair<int, int> b) {
        return (a.first < b.first) || (a.first == b.first && a.second > b.second);
    });
 
    return candidates[0]; // 가장 적합한 (n, m) 쌍 반환
}
 
// 메인 함수
void solve() {
    int t;
    cin >> t; // 테스트 케이스 수
    for (int i = 0; i < t; ++i) {
        pair<int, int> result = solve_test_case();
        cout << result.first << " " << result.second << endl;
    }
}
 
int main() {
    solve();
    return 0;
}