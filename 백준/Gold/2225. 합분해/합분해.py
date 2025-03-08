N, K = map(int, input().split())
MOD = 1_000_000_000

dp = [[0] * (N+1) for _ in range(K+1)]

for j in range(1, N+1):
    dp[1][j] = 1

for i in range(2, K+1):
    dp[i][0] = 1
    for j in range(1, N+1):
        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD

print(dp[K][N])