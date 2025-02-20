K, N, M = map(int, input().split())

price = K * N
money = M
if price >= money :
    print(price - money)
else :
    print(0)