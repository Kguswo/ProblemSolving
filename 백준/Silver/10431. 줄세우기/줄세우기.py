import sys
imput = sys.stdin.readline

T = int(input())

for _ in range(T):
    data = list(map(int, input().split()))
    TC = data[0]
    heights = data[1:]

    cnt = 0
    sorted_heights = []

    for h in heights:
        for j in range(len(sorted_heights)-1, -1, -1):
            if sorted_heights[j] > h: cnt += 1
            else: break

        sorted_heights.append(h)
        sorted_heights.sort()

    print(TC, cnt)