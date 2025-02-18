import math

N, W, H = map(int, input().split())
diagonal = math.sqrt(W*W + H*H)

for _ in range(N):
    match_length = int(input())
    if match_length <= diagonal:
        print("DA")
    else:
        print("NE")