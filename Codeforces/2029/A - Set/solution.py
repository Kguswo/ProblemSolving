def solve(l, r, k):
    if k == 1:
        return r - l + 1
    if r - l + 1 < k:
        return 0
    
    max_x = r // k  # k개 이상의 배수를 가질 수 있는 최대값
    if max_x < l:
        return 0
    
    max_x = min(max_x, r)
    return max_x - l + 1
 
# 입력 처리
t = int(input())
for _ in range(t):
    l, r, k = map(int, input().split())
    print(solve(l, r, k))