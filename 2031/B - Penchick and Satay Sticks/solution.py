def can_sort(n, p):
    # First check: each number must be at most distance 1 from its target position
    for i in range(n):
        if abs(p[i] - (i + 1)) > 1:
            return False
    
    # Second check: impossible if two adjacent positions both need to decrease
    for i in range(n-1):
        if p[i] > i+1 and p[i+1] > i+2:
            return False
            
    return True
 
t = int(input())
for _ in range(t):
    n = int(input())
    p = list(map(int, input().split()))
    print("YES" if can_sort(n, p) else "NO")