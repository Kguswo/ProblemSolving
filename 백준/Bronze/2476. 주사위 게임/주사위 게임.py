N = int(input())
maxnum = 0
for _ in range(N):
    dice = list(map(int, input().split()))
    dice.sort()
    num = 0
    if dice[0] == dice[1] == dice[2]:
        num = 10000 + dice[0] * 1000
    elif dice[0] == dice[1] or dice[1] == dice[2]:
        tmp = dice[1]
        num = 1000 + tmp * 100
    else:
        num = max(dice) * 100
    
    maxnum = max(maxnum, num)
    
print(maxnum)